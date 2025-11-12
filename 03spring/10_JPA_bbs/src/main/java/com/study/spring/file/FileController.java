package com.study.spring.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j	
public class FileController {
	
	//aws spring S3 , supabase Storage
	//boot WAR : 톰캣있음, WAR : 톰켓없음
	//application propertiies에 파일경로 설정
	@Value("${file.upload-dir}")
	private String uploadDir;
	
	@PostMapping("/api/upload")
	public ResponseEntity<String> testFileUpload(
			@ModelAttribute TestDto req
			) throws IllegalStateException, IOException  {
		log.info("title   :" + req.getTitle());
		log.info("Content :" + req.getContent());
		log.info("Name    :" + req.getName());
		
		MultipartFile file = req.getFileUpload();
		if(file != null && !file.isEmpty()) {
			log.info("파일이 있습니다. :" + file.getOriginalFilename());
			log.info("파일경로 :" + uploadDir);
			
			String orignalFileName = file.getOriginalFilename();
			String newFileName = UUID.randomUUID() + "_" + orignalFileName;
			
			// 저장폴더 없으면 생성
			File folder = new File(uploadDir);
			if (!folder.exists()) {
				folder.mkdirs();
				log.info("경로폴더를 생성하였습니다.");
			}
			
			// 저장경로 + 파일명
			File saveFile = new File(folder, newFileName);
			
			// 저장
			file.transferTo(saveFile);
		}
		
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
