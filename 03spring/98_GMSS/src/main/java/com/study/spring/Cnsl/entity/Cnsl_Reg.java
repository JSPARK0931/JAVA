package com.study.spring.Cnsl.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
@Table(name="cnsl_reg")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Cnsl_Reg {
	@Id
	@Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cnsl_id; // 상담 고유 ID (PK)
	
	// 상담 신청자 (User와 N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    // 상담사 (User와 N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cnsler_id")
    private User cnsler;
    
	private String cnsl_tp; // 상담 유형 (Code 테이블 'cnsl_tp' 매핑)
	private String cnsl_cate; // 상담 카테고리 (Code 테이블 'cnsl_cate' 매핑)
	private LocalDate cnsl_dt; // 상담일자
	private LocalTime cnsl_start_time; // 상담시작시간
	private LocalTime cnsl_end_time; // 상담종료시간
	private String cnsl_stat; // 상담상태
	private String cnsl_title; // 상담제목
	private String cnsl_content; // 상담신청내용
	
	private String cnsl_todo_yn; // 상담진행여부
	
	@CreationTimestamp
	private LocalDateTime created_At;
	
	@UpdateTimestamp
    private LocalDateTime updated_at;
}
