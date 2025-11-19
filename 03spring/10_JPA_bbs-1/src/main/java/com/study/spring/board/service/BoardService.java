package com.study.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.spring.board.entity.Board;
import com.study.spring.board.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	BoardRepository boardRepository;

	public List<Board> getBoardList() {

		return boardRepository.findAllOrderByIdDEsc();
	}
}
