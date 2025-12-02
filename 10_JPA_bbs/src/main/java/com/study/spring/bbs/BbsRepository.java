package com.study.spring.bbs;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.SQLSelect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BbsRepository extends JpaRepository<Bbs, Long> {

	List<Bbs> findAllByOrderByIdDesc();
	List<Bbs> findAllByOrderByNameDesc();
	
	Optional<Bbs> findByName(String name);
	
	Page<Bbs> findAll(Pageable pageable);
	Page<Bbs> findByTitleContaining(String title, Pageable pageable);
	Page<Bbs> findByTitleContainingOrNameContaining(String title, String name, Pageable pageable);
	
}
