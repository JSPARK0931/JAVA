package com.study.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.study.spring.bbs.config.WebCorsConfig;
import com.study.spring.board.dto.BoardListDto;
import com.study.spring.board.entity.Board;
import com.study.spring.board.repository.BoardRepository;

@Service
public class BoardService {

    
	@Autowired
	BoardRepository boardRepository;

    
	public List<Board> getBoardList() {

		return boardRepository.findAllOrderByIdDEsc();
	}

	public Page<Board> getBoardPageList(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);

		return boardRepository.findAllWithPage(pageable);
	}

	public List<BoardListDto> getBoardDto() {
		return boardRepository.findAllListDto();
	}

	public Board getBoard(Long id) {
		return boardRepository.findBoard(id).orElseThrow(
				() -> new RuntimeException("게시글이 없습니다.")
				);
	}
}
