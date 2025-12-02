package com.study.spring.board.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String originalFileName;
	private String fileName;
	private Integer imageOrder; // int 는 null 없음 Integer 사용
	
	//private String boardId;
	@ManyToOne
	@JoinColumn(name="board_id")
	private Board board;
	
	private LocalDateTime createdAt;
	
	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDateTime.now();
		if (imageOrder== null) imageOrder = 0;
	}
	

}
