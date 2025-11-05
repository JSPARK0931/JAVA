package com.study.spring.store;

import lombok.Data;

@Data
public class MenuDTO {
	Long id;
	String name;
	int price;
	Long store_id;

}
