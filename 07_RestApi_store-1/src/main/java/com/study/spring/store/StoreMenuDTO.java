package com.study.spring.store;

import java.util.List;

import lombok.Data;

@Data
public class StoreMenuDTO {
	Long id;
	String name;
	String addr;
	
	List<MenuDTO> menus;
	
}
