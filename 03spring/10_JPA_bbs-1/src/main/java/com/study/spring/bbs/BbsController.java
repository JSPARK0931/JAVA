package com.study.spring.bbs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	BbsRepository bbsRepository;
	
	@GetMapping("/")
	public String root() {
		log.info("TEST");
		return "HI~~~";
	}
	
	@GetMapping("/api/bbs1")
	public List<Bbs> bbsList() {
//		return bbsRepository.findAll(Sort.by(Direction.DESC,"id"));
		return bbsRepository.findAllByOrderByIdDesc();
//		return bbsRepository.findAllByOrderByNameDesc();
	}
	
	// PageNation
	// import org.springframework.data.domain.Pageable;
	// http://localhost:8080/api/bbs?size=5&page=0
	
	@GetMapping("/api/bbs")
	public Page<Bbs> bbsList1(
			@RequestParam(name="title", defaultValue="") String title,
			@RequestParam(name="content", defaultValue="") String content,
			@RequestParam(name="size",  defaultValue="5") int size,
			@RequestParam(name="page",  defaultValue="0") int page
			) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"id"));
//		return bbsRepository.findAll(pageable);
//		return bbsRepository.findByTitleContaining(title, pageable);
		return bbsRepository.findByTitleContainingOrContentContaining(title, content, pageable);
	}
	
	@GetMapping("/api/bbs/{id}")
	public Optional<Bbs> bbsView(
			@PathVariable("id") Long id
			) {
		log.info("id :" + id);
		return bbsRepository.findById(id);
	}
	
	@GetMapping("/api/bbs1/{name}")
	public Optional<Bbs> bbsView1(
			@PathVariable("name") String name
			) {
		log.info("name :" + name);
		return bbsRepository.findByName(name);
		
	}
	
	@PostMapping("/api/bbs")
	public Bbs bbsCreate(
			@RequestBody BbsDto req
			) {
		Bbs bbs =  Bbs.builder(	)
				.name(req.getName())
				.title(req.getTitle())
				.content(req.getContent())
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
		Optional<Bbs> view = bbsRepository.findById(id);
		log.info("정보확인 :" + view.toString());
		
		if (view.isEmpty()) {
			log.info("자료가 없습니다.");
		}
		else  {
			Bbs entity = view.get();
			entity.setName(req.getName());
			entity.setTitle(req.getTitle());
			entity.setContent(req.getContent());
			
			bbsRepository.save(entity);
			log.info("수정완료");
		}
	}
}
