package com.study.spring.Bbs.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "cmt_like")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cmt_Like {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clike_id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cmt_id", nullable = false)
	private Bbs_Comment cmt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id",nullable = false)
	private User user;

	private boolean is_like;

	@CreationTimestamp
	private LocalDateTime createdAt;
}
