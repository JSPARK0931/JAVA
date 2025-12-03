package com.study.spring.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.hospital.dto.HospitalSumDTO;
import com.study.spring.hospital.dto.HospitalSumInfoDTO;
import com.study.spring.hospital.entity.Hospital;
import com.study.spring.hospital.service.HospitalSumInfoService;

@RestController
public class HospitalSumInfoController {

	@Autowired
	HospitalSumInfoService HSInfoService;
	
	@GetMapping("/api/hs_info")
	public ResponseEntity<List<HospitalSumInfoDTO>> getHospitalSumInfo(){
		List<HospitalSumInfoDTO> sumInfo = HSInfoService.getHospitalSumInfo();
		if (sumInfo.isEmpty()) {
			return ResponseEntity.noContent().build(); // 결과가 없을 경우 204 No Content 반환
	    }
	        
	    return ResponseEntity.ok(sumInfo); // 결과가 있을 경우 200 OK와 데이터 반환
	}
	
}
