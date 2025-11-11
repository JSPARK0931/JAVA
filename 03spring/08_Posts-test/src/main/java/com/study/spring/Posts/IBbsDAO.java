package com.study.spring.Posts;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface IBbsDAO {
	
	@Select("SELECT * FROM posts ORDER BY id DESC")
	List<BbsDTO> findALL();
	
	@Select("SELECT * FROM posts WHERE id =#{id}")
	BbsDTO findByID(Long id);
	
	@Insert("INSERT INTO posts (title, content, name) VALUES (#{title}, #{content}, #{name})")
	void createPost(BbsDTO request);

	@Update("UPDATE posts SET title=#{title}, name=#{name}, content=#{content} WHERE id=#{id}")
	int updatePost(BbsDTO request);

	@Delete("DELETE FROM posts WHERE id =#{id}")
	int deletePost(long id);
}
