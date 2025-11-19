package com.study.spring.board.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.board.entity.Board;
import com.study.spring.board.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/api")
	public String root() {
		return "HI~~";
	}
	
	//전체리스트
	@GetMapping("/api/board")
	public List<Board> getBoadList(){
		return boardService.getBoardList();
	}

}
