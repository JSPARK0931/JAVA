package com.study.spring.hospital.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="hospital_s")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Hospital_s {
	@Id
	private String h_code;
	
	private String h_mon_s;
	private String h_mon_c;
	private String h_tue_s;
	private String h_tue_c;
	private String h_wed_s;
	private String h_wed_c;
	private String h_tur_s;
	private String h_tur_c;
	private String h_fri_s;
	private String h_fri_c;
	private String h_sat_s;
	private String h_sat_c;
	private String h_sun_s;
	private String h_sun_c;
	private String h_hol_s;
	private String h_hol_c;
	private String h_lun_s;
	private String h_lun_c;
	private LocalDateTime createdAt;
	
	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDateTime.now();
	}
}
