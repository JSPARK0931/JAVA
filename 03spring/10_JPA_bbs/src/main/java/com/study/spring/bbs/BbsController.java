package com.study.spring.bbs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BbsController {
	
	@Autowired
	BbsRepository bbsRepository;
	
	@GetMapping("/")
	public String root() {
		return "hi";
	}
	
//	@GetMapping("/api/bbs")
//	public List<Bbs> bbsList(){
////		return bbsRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
//		return bbsRepository.findAllByOrderByIdDesc();
////		return bbsRepository.findAllByOrderByNameDesc();
////		return bbsRepository.findAllByOrderByNameDesc();
//	}
	
	// 페이지네이션
	// import org.springframework.data.domain.Pageable;
	//https://localhost:8080/api/bbs?size=5&page=0
	//http://localhost:8080/api/bbs?size=5&page=0&title=test
	//http://localhost:8080/api/bbs?size=5&page=0&title=하&name=손
	@GetMapping("/api/bbs")
	public Page<Bbs> bbsList	(
			@RequestParam(name = "title", defaultValue="") String title,
			@RequestParam(name = "name", defaultValue="") String name,
			@RequestParam(name = "size", defaultValue="5") int size,
			@RequestParam(name = "page", defaultValue="0") int page
			) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"id"));
//		return bbsRepository.findAll(pageable);
		return bbsRepository.findByTitleContaining(title,pageable);
//		return bbsRepository.findByTitleContainingOrNameContaining(title,name,pageable);
	}
	
	@GetMapping("/api/bbs/{id}")
	public Optional<Bbs> bbsView(
			@PathVariable("id")  Long id
			){
		log.info("id :" + id);
		return bbsRepository.findById(id);
	}
	
	@GetMapping("api/bbs1/{name}")
	public Optional<Bbs> bbsView1(
			@PathVariable("name") String name
			) {
		return bbsRepository.findByName(name);
		
	}
	
	@PostMapping("/api/bbs")
	public Bbs bbsCreate(
			@RequestBody BbsDto request
			) {
//		Bbs bbs = new Bbs();
//		bbs.setName(request.name);
//		bbs.setTitle(request.title);
//		bbs.setContent(request.content);
		
		Bbs bbs = Bbs.builder()
				.name(request.getName())
				.title(request.getTitle())
				.content(request.getContent())
				.build();
		
		return bbsRepository.save(bbs);
		
	}
	
	@PostMapping("/api/bbs1")
	public Bbs bbsCreate1(
			@RequestBody BbsDto req
			) {
		Bbs bbs = new Bbs();
		bbs.setName(req.name);
		bbs.setTitle(req.title);
		bbs.setContent(req.content);
		
		return bbsRepository.save(bbs);
	}
	
	@PutMapping("/api/bbs/{id}")
	public void bbsUpdate(
			@PathVariable("id") Long id,
			@RequestBody BbsDto req
			) {
//		Bbs bbsEntity = bbsRepository.findById(id).orElseThrow(
//				()->new RuntimeException("자료가 없습니다...")
//				);
		
		Optional<Bbs> view = bbsRepository.findById(id);
		log.info("정보확인 :" + view.toString());
		
		if (view.isEmpty()) {
			log.info("자료가 없습니다.");
		} else {
			Bbs entity = view.get();
			entity.setName(req.getName());
			entity.setTitle(req.getTitle());
			entity.setContent(req.getContent());
			
			bbsRepository.save(entity);
			log.info("수정원료");
		} 
	}
	
	@DeleteMapping("/api/bbs/{id}")
	public ResponseEntity<?> bbsDelete(
			@PathVariable("id") Long id
			) {
		boolean data = bbsRepository.existsById(id);
		if (!data) {
			return ResponseEntity.notFound().build();
		} 
		
		bbsRepository.deleteById(id);
		
		return ResponseEntity.ok("삭제완료." );
		
	}
	
//	public void bbsList() {}
//	public void bbsView() {}
//	public void bbsCreate() {}
//	public void bbsUpdate() {}
//	public void bbsDelete() {}
	
//	
//	@GetMapping("api/bbs/{id}")
//	public Optional<Bbs> bbsView(
//			@PathVariable("id") Long id) {
//		return bbsRepository.findById(id);
//	}
//	
}
