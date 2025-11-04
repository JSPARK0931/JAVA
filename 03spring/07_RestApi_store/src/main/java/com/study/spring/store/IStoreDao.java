package com.study.spring.store;

import java.util.List;

import org.apache.ibatis.annotations.*;
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Many;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Result;
//import org.apache.ibatis.annotations.Results;
//import org.apache.ibatis.annotations.Select;

@Mapper
public interface IStoreDao {

	@Select("SELECT * FROM store ORDER BY id DESC")
	List<storeDto> findAll();

	@Select("SELECT * FROM menu ORDER BY id DESC")
	List<menuDto> findMenuAll();

	@Select("SELECT * FROM store WHERE id =#{id}") 
	storeDto storeView(Long id);

	@Insert("INSERT INTO store (name, addr) VALUES (#{name}, #{addr})")
	void createStore(storeDto request);

	@Select("SELECT * FROM menu WHERE id =#{id}")
	menuDto menuView(Long id);
	
	@Insert("INSERT INTO menu (name, price, store_id) VALUES (#{name}, #{price}, #{store_id})")
	void createMenu(menuDto request);
	
	@Select("SELECT * FROM menu WHERE store_id=#{store_id} ORDER BY id DESC")
	List<menuDto> findMenuByStoreId(Long store_id);

	//[{store},{menu}] 1:다 property : dto, column :db값
	@Select("SELECT * FROM store ORDER BY id DESC")
	@Results({
		@Result(property="id", column="id"),
		@Result(property="name", column="name"),
		@Result(property="addr", column="addr"),
		@Result(property="menus", column="id",
				many = @Many(select="findMenuByStoreId" )
				),
		
	})
	List<StoreMenuDto> storeAndMenuALL();
	
	@Select("SELECT * FROM menu ORDER BY id DESC")
	@Results({
		@Result(property="id", column="id"),
		@Result(property="name", column="name"),
		@Result(property="price", column="price"),
		@Result(property="store_id", column="store_id"),
		@Result(property="store", column="store_id",
				one = @One(select="storeView")	
					),
	})
	List<MenuStoreNameDto> menuStoreName();
	

}
