package com.study.spring.Posts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BbsController {
	
	@Autowired
	IBbsDAO DAO;
	
	@GetMapping("/bbs/test")
	public String root() {
		return "Hello";
	}
	
	@GetMapping("/bbs")
	public List<BbsDTO> list(){
		return DAO.findALL();
	}
	
	@GetMapping("/bbs/list")
	public BbsDTO viewData(
		@RequestParam("id") Long id
		) {
		log.info("view :" + id);
		return DAO.findByID(id);
	}
	
	@PostMapping("/bbs")
	public void createPost(
		@RequestBody BbsDTO request
		) {
		log.info("title :" + request.title + ", content:" + request.content + ", name :" + request.name );
		DAO.createPost(request);
	}
	
	@PutMapping("/bbs/modify")
	public ResponseEntity<String> PostModify(
			@RequestParam("id") Long id,
			@RequestBody BbsDTO request	
			){
		log.info("id : " + id);
		request.setId(id);
		int updated = DAO.updatePost(request);
		if (updated > 0) {
			return ResponseEntity.ok("update success");
		} else {
			return ResponseEntity.badRequest().body("update failed");
		}
		
	}
	
	@DeleteMapping("bbs/delete")
	public ResponseEntity<String> Postdelete(
			@RequestParam("id") long id
			){
		
		int deleted = DAO.deletePost(id);
		if (deleted > 0){
			return ResponseEntity.ok("delete success");
		}else {
			return ResponseEntity.badRequest().body("delete failed");
			
		}

	}
	
	@PatchMapping("/bbs/modify1")
	public ResponseEntity<String> PostModify1(
			@RequestParam("id") Long id,
			@RequestBody BbsDTO request	
			){
		log.info("id : " + id);
		request.setId(id);
		int updated = DAO.updatePost(request);
		if (updated > 0) {
			return ResponseEntity.ok("update success");
		} else {
			return ResponseEntity.badRequest().body("update failed");
		}
		
	}
	

}
