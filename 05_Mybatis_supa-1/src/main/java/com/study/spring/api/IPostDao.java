package com.study.spring.api;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IPostDao {
	@Select("SELECT * FROM POSTS ORDER BY ID DESC")
	public List<PostDto> listDao();
}
