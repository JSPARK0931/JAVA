package com.study.spring.Posts;

import java.security.Timestamp;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BbsDTO {
	Long id;
	String title;
	String content;
	String name;
//	Timestamp created_at;
	LocalDateTime created_at;
}	
