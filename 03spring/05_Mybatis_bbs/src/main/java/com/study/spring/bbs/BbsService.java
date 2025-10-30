package com.study.spring.bbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbsService {
	@Autowired
	IbbsDao dao;
	
	public List<BbsDto> getList(){
		return dao.ListDao();
	}
	
	public int count() {
		return dao.countDao();
	}
}
