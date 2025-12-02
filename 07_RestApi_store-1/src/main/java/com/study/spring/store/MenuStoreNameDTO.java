package com.study.spring.store;

import lombok.Data;

@Data
public class MenuStoreNameDTO {
	Long id;
	String name;
	int price;
	Long store_id;
	StoreDTO store; //object
}
