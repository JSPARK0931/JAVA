package com.study.spring.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class StoreController {
	
	@Autowired
	IStoreDAO dao;

	@GetMapping("/")
	public String root() {
		return "store";
	}

	@GetMapping("/api/store")
	public List<StoreDTO> listStore(){
		return dao.findAll();
	}
}
