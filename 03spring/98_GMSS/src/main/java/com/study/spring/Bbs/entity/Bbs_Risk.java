package com.study.spring.Bbs.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.study.spring.user.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bbs_risk")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bbs_Risk {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String table_id; // 테이블명
	private String bbs_div; // 테이블분류
	private Integer bbs_id; // 게시물id
	private String content; // 게시물 내용

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id", nullable = false)
	private User user;

	private String action; // 조치내용

	@CreationTimestamp
	private Timestamp created_at;

	@UpdateTimestamp
	private LocalDateTime updated_at;
}
