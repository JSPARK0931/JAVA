package com.study.spring.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.study.spring.board.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{
	// entity Type, entity @id Type
	
	@Query("""
			SELECT b
			  FROM Board b
			 ORDER BY b.id DESC
			""")
	List<Board> findAllOrderByIdDEsc();
	

}
