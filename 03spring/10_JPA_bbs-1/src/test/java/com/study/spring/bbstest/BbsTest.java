package com.study.spring.bbstest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.spring.bbs.Bbs;
import com.study.spring.bbs.BbsRepository;

@SpringBootTest
public class BbsTest {
	
	@Autowired
	public BbsRepository bbsRepo;
	
	@Test
	public void bbsInsert() {
		Bbs bbs = new Bbs();
		bbs.setName("부앙가");
		bbs.setTitle("안녕하세요.");
		bbs.setContent("MLS 우승합시다.");
		bbsRepo.save(bbs);
		
		Bbs bbs2 = Bbs.builder()
				.name("손흥민")
				.title("LA FC")
				.content("NICE ONE SONNY")
				.build();
		
		bbsRepo.save(bbs2);

	}
	

}
