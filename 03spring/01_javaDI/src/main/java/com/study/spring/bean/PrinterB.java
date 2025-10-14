package com.study.spring.bean;

import org.springframework.stereotype.Component;


public class PrinterB implements Printer{

	@Override
	public void print(String message) {
		System.out.println("printer B:" + message);
		
	}

}
