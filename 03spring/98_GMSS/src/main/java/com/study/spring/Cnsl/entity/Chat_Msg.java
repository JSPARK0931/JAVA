package com.study.spring.Cnsl.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "chat_msg")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chat_Msg {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
	private Integer chat_id;
	
	@Column(nullable = false)
	private Integer cnsl_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cnsler_id")
	private User cnsler;
	
	@Column(nullable = false)
	private String role;
	
	@Column(nullable = false)
	private String content;
	
	@CreationTimestamp
	private LocalDateTime created_at;
}
