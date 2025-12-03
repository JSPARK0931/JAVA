package com.study.spring.board.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.spring.board.dto.BoardListDto;
import com.study.spring.board.dto.BoardListMemberDto;
import com.study.spring.board.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{ // entity Type, entity @id Type

	@Query("""
			select b 
			  from Board b 
			 order by b.id desc	
			""")  
	List<Board> findAllOrderByIdDesc();
	
	@Query("""
			select new com.study.spring.board.dto.BoardListDto(
				b.id, 
				b.title, 
				b.name, 
				b.createdAt
			) 
			  from Board b
			 order by b.id desc
			""")
	List<BoardListDto> findAllListDto();
	
	@Query("select b from Board b where b.id = :id")
	Optional<Board> findBoard(@Param("id") Long id);

	@Query("select b from Board b order by b.id desc")
	Page<Board> findAllWithPage(Pageable pageable);

	@Query("""
			SELECT new com.study.spring.board.dto.BoardListMemberDto(
				b.id,
				b.title,
				b.content,
				m.name,
				m.email,
				b.createdAt
			)
			 FROM Board b
			 JOIN b.member m			  
		    ORDER BY b.id DESC
			""")
	List<BoardListMemberDto> findWithMemberById();

// JOIN FETCH	
//	@Query("""
//			select distinct b
//			from Board b
//			left join fetch b.images i
//			join fetch b.member m
//			order by b.id desc
//			""")
//	List<Board> findWithImage();
	
	@EntityGraph(attributePaths ="images")
	@Query("""
			SELECT distinct b 
			  FROM Board b 
			  LEFT JOIN FETCH b.images
			  JOIN FETCH b.member
			  ORDER BY b.id DESC
			""")
	List<Board> findWithImage();

	
	@Query("""
			SELECT distinct b
			  FROM Board b
			  LEFT JOIN FETCH b.images
			  JOIN FETCH b.member
			  ORDER BY b.id DESC
			""")
	Page<Board> findWithImagePage(Pageable pageable);

	@Query("""
			SELECT b 
			FROM Board b 
			LEFT JOIN FETCH b.images 
			WHERE b.id = :id
			""")
	Board findWithImageById(@Param("id") Long id);
	
	
	// 			 JOIN b.member m OR JOIN Member m
}
