package com.study.spring.hospital.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hospital")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Hospital {
	@Id
	private String h_code;
	
	@OneToOne @MapsId // hospital.h_code와 연결될 hospital_s를 지정 (같은 primary key를 사용하도록 설정)
	private Hospital_s hospital_s;
	
//	@OneToMany(mappedBy = "hospital") // 하나의 병원에 등록된 모든 예약을 불러야와야 함
//	private List<H_appm> h_appms = new ArrayList<>();
	
//	@OneToMany(mappedBy = "hospital") // 하나의 병원에 등록된 모든 리뷰를 불러와야 하기 때문에
//	private List<H_review> h_reviews = new ArrayList<>();
	
		
	@Column
	private String h_name;
	private String h_addr;
	private String h_kind;
	private String h_bigo;
	private String h_content;
	private String h_smpl_dgm;
	private String h_tel1;
	private String h_tel2;
	private String h_long;
	private String h_lat;
	private String h_park_yn;
	
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
