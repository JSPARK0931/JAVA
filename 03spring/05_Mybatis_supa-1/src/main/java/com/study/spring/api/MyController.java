package com.study.spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@Autowired
	IPostDao postDao;

	@GetMapping("/")
	public String root() {
		return "Hello RESTful API";
	}
	
	@GetMapping("/api/posts")
	public List<PostDto> postView(){
		List<PostDto> postView = postDao.listDao();
		return postView;
	}
	@GetMapping("/api/posts1")
	public List<PostDto> postView1(){
		return postDao.listDao();
	}
	
	@GetMapping("/api/test")
	public String requestParam(
			@RequestParam("name") String name,
			@RequestParam("age") String age
			) {
		return "[1]hello, request param , name :" + name + ", age :" + age;
	}
	
	@GetMapping("/api/test/{name}/{age}")
	public String pathParam(
			@PathVariable("name") String name,
			@PathVariable("age") String age
			) {
		return "[2]hello, request param , name :" + name + ", age :" + age;
	}
	
	@GetMapping("/api/dtest")
	public String dtoTest(
			@ModelAttribute testDto dto
			) {
		return "[3]hello, request param , name :" + dto.name + ", age :" + dto.age;
	}
	
	@GetMapping("/api/dtest/{name}/{age}")
	public String dtoTest2(
			@ModelAttribute testDto dto
			) {
		return "[4]hello, request param , name :" + dto.name + ", age :" + dto.age;
	}
	
}
