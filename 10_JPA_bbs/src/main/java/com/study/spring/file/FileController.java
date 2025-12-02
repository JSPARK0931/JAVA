package com.study.spring.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j	
public class FileController {
	
	@Autowired
	FileService fileService;
	
	//aws spring S3 , supabase Storage
	//boot WAR : 톰캣있음, WAR : 톰켓없음
	//application propertiies에 파일경로 설정
	@Value("${file.upload-dir}")
	private String uploadDir;
	
	//postman form-data / @ModelAttribute 자료전송( 이미지파일 )
	@PostMapping("/api/upload")
	public ResponseEntity<String> testFileUpload(
			@ModelAttribute TestDto req
			) throws IllegalStateException, IOException  {

		fileService.fileCreate(req);
		return ResponseEntity.ok("SUCCESS");
	
	}
	
	@GetMapping("/api/image/{filename}")
	public ResponseEntity<Resource> getImage(
			@PathVariable("filename") String filename
			) throws IOException {
		File file = new File(uploadDir + "/" + filename); //C:/upload/filename
		if (!file.exists()) {
			log.info("[파일없음]filename :" + file);
			return ResponseEntity.notFound().build();
		}
		log.info("[파일있음]filename :" + file);
		Resource resource = new FileSystemResource(file);
		
		String contentType = Files.probeContentType(file.toPath());
		if (contentType == null) {
			contentType = "application/octet-stream";
		}
				
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.body(resource);
	}

}
