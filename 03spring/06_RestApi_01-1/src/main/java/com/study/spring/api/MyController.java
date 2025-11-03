package com.study.spring.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping("/hello/world")
	public String helloWorld() {
		return "[get] hello Spring Test!!";
	}
	
	@PostMapping("/hello/world")
	public String postHelloWorld() {
		return "[post] hello Spring Test!!";
	}
	
	@PutMapping("/hello/world")
	public String putHelloWorld() {
		return "[put] hello Spring Test!!";
	}
	
	@DeleteMapping("/hello/world")
	public String deleteHelloWorld() {
		return "[delete] hello Spring";
	}
	
	@GetMapping("/test/param")
	public String requestParam(
			@RequestParam("name") String name,
			@RequestParam("age") Integer age
			) {
		return "[Request Param] hello, request:" + name + "," + age;
	}
	
	//localhost:8080/test/path/홍길동/30
	@GetMapping("/test/path/{name}/{age}")
	public String requestPath(
			@PathVariable("name") String name,
			@PathVariable("age") String age
			) {
		return "[Request Path] hello, request:" + name + "," + age;
		
	}
	
	@PostMapping("/test/body")
	public String requestBody(
			@RequestBody TestDto request
			) {
		
		return "[Request Body] " + request.name + ", " + request.age + ", " + request.addr + ", " + request.hobby;
	}

}
