package com.study.spring.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.spring.hospital.dto.HospitalSumInfoDTO;
import com.study.spring.hospital.repository.HospitalSumInfoRepository;

@Service
@Transactional(readOnly = true)
public class HospitalSumInfoService {
	HospitalSumInfoRepository hospitalSumInfoRepo;
	
	// 컨트롤러에서 호출할 메서드 -  
	public List<HospitalSumInfoDTO> getHospitalSumInfo() {
		// 네이티브 쿼리가 실행되고 결과가 DTO 인터페이스 리스트로 반환
		return hospitalSumInfoRepo.findHospitalSumInfo();
	}
}
