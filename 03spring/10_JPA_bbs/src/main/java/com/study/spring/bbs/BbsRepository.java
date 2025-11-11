package com.study.spring.bbs;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.SQLSelect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BbsRepository extends JpaRepository<Bbs, Long> {

	List<Bbs> findAllByOrderByIdDesc();
	List<Bbs> findAllByOrderByNameDesc();
	
	Optional<Bbs> findByName(String name);
	
}
