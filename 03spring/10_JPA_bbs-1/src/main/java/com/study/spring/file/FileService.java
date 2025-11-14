package com.study.spring.file;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

@Service
@Slf4j
public class FileService {
	
	@Autowired
	FileRepository fileRepository;
	
	@Value("${file.upload-dir}")
	private String uploadDir;
	
	public void FileCreate(TestDTO req) throws IllegalStateException, IOException {
		
		log.info("title   :" + req.getTitle());
		log.info("content :" + req.getContent());
		log.info("name    :" + req.getName());
		
		FileEntity createData = new FileEntity();
		createData.setName(req.getName());
		createData.setTitle(req.getTitle());
		createData.setContent(req.getContent());
		
		MultipartFile file = req.getFileUpload();
		if (file !=null && !file.isEmpty()) {
			log.info("파일이 있습니다. : " + file.getOriginalFilename());
			log.info("파일경로       : " + uploadDir);
			
			String origialFileName = file.getOriginalFilename();
			String newFileName = UUID.randomUUID() + "_" + origialFileName;
			
			// 저장폴더 없으면 생성
			File folder = new File(uploadDir);
			if(!folder.exists()){
				folder.mkdirs();
				log.info("경로폴더를 생성하였습니다.");
			}
			
			//저장경로 + 파일명
			File saveFile = new File(folder, newFileName);
			
			//저장
			file.transferTo(saveFile);
			
			// Thumbnail fileupload
			String thumbnailName = "thumb_100_" + newFileName;
			File thumbnailFile = new File(folder, thumbnailName);
			Thumbnails.of(saveFile).size(100,100).toFile(thumbnailFile);
			
			createData.setImageFileName(newFileName);
			
		}
		
		fileRepository.save(createData);
	}

}
