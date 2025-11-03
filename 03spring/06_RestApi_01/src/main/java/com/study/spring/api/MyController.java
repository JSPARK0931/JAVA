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
		return "hello Spring";
	}
	
	@PostMapping("/hello/world")
	public String postHelloWorld() {
		return "[post] hellow Spring";
	}

	@PutMapping("/hello/world")
	public String putHelloWorld() {
		return "[put] hellow Spring";
	}
	@DeleteMapping("/hello/world")
	public String deleteHelloWorld() {
		return "[delete] hellow Spring";
	}
	//localhost:8080/test/param?name=홍길동&age=20
	@GetMapping("/test/param")
	public String requestParam(
			@RequestParam("name") String name,
			@RequestParam("age") Integer age
			) {
		
		return "hellow, request:" + name + ", " + age;
	}
	
	//localhost:8080/test/path/{name}/{age}
	@GetMapping("/test/path/{name}/{age}")
	public String requestPath(
			@PathVariable("name" ) String name,
			@PathVariable("age") String age
			) {
		return "hellow, request:" + name + ", " + age;
	}
	
	@PostMapping("/test/body")
	public String requestBody(
			@RequestBody TestDto request
			) {
		return  "hellow, request:" + request.name + ", " + request.age + ", " + request.addr  + ", " + request.hobby;
	}
	
}
