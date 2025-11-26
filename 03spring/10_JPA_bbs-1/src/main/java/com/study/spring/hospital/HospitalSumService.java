package com.study.spring.hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class HospitalSumService {
	
	@Autowired
	HospitalSumRepository hospitalSumRepo;

//    private final HospitalRepository hospitalRepository;
//
//    @Autowired
//    public HospitalSumService(HospitalRepository hospitalRepository) {
//        this.hospitalRepository = hospitalRepository;
//    }

	// 컨트롤러에서 호출할 메서드
	public List<HospitalSumDTO> getHospitalSum1() {
		// 네이티브 쿼리가 실행되고 결과가 DTO 인터페이스 리스트로 반환
		return hospitalSumRepo.findHospitalSum1();
	}

	// 컨트롤러에서 호출할 메써드
	public List<HospitalSumDTO> getHospitalSum2() {
		// 네이티브 쿼리가 실행되고 결과가 DTO 인터페이스 리스트로 반환
		return hospitalSumRepo.findHospitalSum2();
	}

}
