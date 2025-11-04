package com.study.spring.store;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IStoreDAO {
	
	@Select("SELECT * FROM store ORDER BY id DESC")
	List<StoreDTO> findAll();

}
