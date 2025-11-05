package com.study.spring.store;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IStoreDAO {
	
	@Select("SELECT * FROM store ORDER BY id DESC")
	List<StoreDTO> findStoredAll();

	@Select("SELECT * FROM store WHERE id = #{id}")
	StoreDTO storeView(Long id);

	@Select("SELECT * FROM menu ORDER BY id DESC")
	List<MenuDTO> findMenuAll();

	@Select("SELECT * FROM menu WHERE id =#{id}")
	MenuDTO menuView(Long id);

	@Insert("INSERT INTO store (name, addr) VALUES (#{name}, #{addr})")
	void createStore(StoreDTO request);
	
	@Insert("INSERT INTO menu (name, price, store_id) VALUES (#{name}, #{price}, #{store_id})")
	void createMenu(MenuDTO request);

	@Select("SELECT * FROM menu WHERE store_id=#{store_id} ORDER BY id DESC")
	List<MenuDTO> findMenuByStoreId(Long store_id);

//	@Select("SELECT * FROM store WHERE name LIKE #{store_name} ORDER BY id DESC")
//	List<StoreDTO> findStoreName(String store_name);

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
	List<StoreMenuDTO> storeAndMenuALL();
	
	
}
