package com.study.spring.hospital.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="h_appm")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class H_appm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement 설정
	private int a_id;

	@ManyToOne
	@JoinColumn(name="h_code")
	private Hospital hospital;
	
	private String a_date; // 수정 예정
	private String a_content;
	private UUID a_user_id; // 수정 예정
	private String a_del_yn;
	private String a_dia_name;
	private String a_dia_content;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
}
