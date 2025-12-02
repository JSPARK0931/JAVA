package com.study.spring.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.study.spring.Application;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class StoreController {

    private final Application application;
	
	@Autowired
	IStoreDao dao;


    StoreController(Application application) {
        this.application = application;
    }

	
	@GetMapping("/")
	public String root() {
		return "store";
	}
	
	@GetMapping("/api/store")
	public List<storeDto> listStore(){
		return dao.findAll();
	}
	//api/store/view?id=1
	@GetMapping("/api/store/view")
	public storeDto viewStore(
			@RequestParam("id") Long id
			) {
		log.info("view id :" + id);
		return dao.storeView(id);
//		return null;
	}
	
	@PostMapping("/api/store")
	public void createStore(
			@RequestBody storeDto request
			) {
		log.info("post : name - " +request.name + ", addr :" + request.addr);
		dao.createStore(request);
	}
	
	//api/store/menu?id=1
	@GetMapping("/api/menu/view")
	public menuDto viewMenu(
			@RequestParam("id") Long id
			) {
		log.info("menu id :"  + id);
		return dao.menuView(id);
	}
	
	@PostMapping("/api/menu")
	public void createMenu(
			@RequestBody menuDto request
			) {
		log.info("post name :" + request.name + ", price :" + request.price + ", store_id :" + request.Store_id );
		dao.createMenu(request);
	}
		
	
	@GetMapping("/api/menu")
	public List<menuDto> listMenu(){
		return dao.findMenuAll();
	}
	
	//api/menuStoreId?id=1
	@GetMapping("/api/menuStore")
	public List<menuDto> menuStoreView(
			@RequestParam("store_id") Long store_id
			) {
		return dao.findMenuByStoreId(store_id);
	}
	
	@GetMapping("/api/storeMenu")
	public List<StoreMenuDto> storeMenuList(){
		return dao.storeAndMenuALL();
	}
	
	@GetMapping("/api/menuStoreName")
	public List<MenuStoreNameDto> menuStoreName(){
		return dao.menuStoreName();
	}

}
