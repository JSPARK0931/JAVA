package com.study.spring.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class StoreController {
	
	@Autowired
	IStoreDAO dao;

	@GetMapping("/")
	public String root() {
		return "store";
	}

	@GetMapping("/api/store")
	public List<StoreDTO> listStore(){
		return dao.findStoredAll();
	}

	//api/store/view?id=1
	@GetMapping("/api/store/view")
	public StoreDTO viewStore(
			@RequestParam("id") Long id
			) {
		log.info("[store] view id:" + id);
		return dao.storeView(id);
	}
	
	@GetMapping("/api/menu")
	public List<MenuDTO> listMenu(){
		return dao.findMenuAll();
	}
	
	//api/menu/view?id=1
	@GetMapping("/api/menu/view")
	public MenuDTO viewMenu(
			@RequestParam("id") Long id
			) {
		log.info("[menu] view id:" + id);
		return dao.menuView(id);
	}
	
	@PostMapping("/api/store")
	public void createStore(
			@RequestBody StoreDTO request
			) {
		log.info("[store post] name:"+request.name + ",addr:" + request.addr );
		dao.createStore(request);
	}
	
	@PostMapping("/api/menu")
	public void createMenu(
			@RequestBody MenuDTO request
			) {
		log.info("[menu post] name:"+request.name +",price:" + request.price + ",store_id:" + request.store_id);
		dao.createMenu(request);
	}
	
	@GetMapping("/api/menuStore")
	public List<MenuDTO> menuStoreView(
			@RequestParam("store_id") Long store_id
			){
		return dao.findMenuByStoreId(store_id);
		
	}
	
	// like 는  문법이 다름
//	@GetMapping("/api/storeName")
//	public List<StoreDTO> storeNameSearchView(
//			@RequestParam("store_name") String store_name
//			){
//		return dao.findStoreName(store_name);
//	}
	
	@GetMapping("/api/storeMenu")
	public List<StoreMenuDTO> storeMenuList(){
		return dao.storeAndMenuALL();
	}
	
	@GetMapping("/api/menuStoreName")
	public List<MenuStoreNameDTO> menuStoreName(){
		return dao.menuStoreName();
	}
}
