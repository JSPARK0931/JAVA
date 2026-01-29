package com.study.spring.Cnsl.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.study.spring.user.entity.User;

import jakarta.persistence.Column;
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
@Table(name = "cnsl_review")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cnsl_Review {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer review_id;
	
	// 1. 상담 신청자 (User와 N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false)
    private User user;
    
    // 2. 상담사 (User와 N:1, 작성자와 별개로 상담사 역할을 하는 유저)
    // 상담사 ID의경우 Cnsl_reg의 cnslr_id를 사용하면되므로 삭제함 
    
	private String title;
	private String content;
	private Integer eval_pt;

	@CreationTimestamp
	private LocalDateTime created_at;
	
	@UpdateTimestamp
    private LocalDateTime updated_at;
}
