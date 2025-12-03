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

	// 컨트롤러에서 호출할 메서드 -  
	public List<HospitalSumDTO> getHospitalSum1() {
		// 네이티브 쿼리가 실행되고 결과가 DTO 인터페이스 리스트로 반환
		return hospitalSumRepo.findHospitalSum1();
	}

	// 컨트롤러에서 호출할 메써드
	public List<HospitalSumDTO> getHospitalSum2() {
		// 네이티브 쿼리가 실행되고 결과가 DTO 인터페이스 리스트로 반환
		return hospitalSumRepo.findHospitalSum2();
	}
	
	
	// 리뷰카운트 순
	public List<HospitalSumDTO> getHospitalSumByReviewCnt() {
		// 네이티브 쿼리가 실행되고 결과가 DTO 인터페이스 리스트로 반환
		return hospitalSumRepo.findHospitalSumByReviewCnt();
	}
	
	// 평가평점 순
	public List<HospitalSumDTO> getHospitalSumByEvalPt() {
		// 네이티브 쿼리가 실행되고 결과가 DTO 인터페이스 리스트로 반환
		return hospitalSumRepo.findHospitalSumByEvalPt();
	}
	
	// 코멘트건수 순
	public List<HospitalSumDTO> getHospitalSumByCommentCnt() {
		// 네이티브 쿼리가 실행되고 결과가 DTO 인터페이스 리스트로 반환
		return hospitalSumRepo.findHospitalSumByCommentCnt();
	}

	// 병원평점 TOP LIST
	public List<HospitalSumDTO> getHospitalSumByTopList() {
		// TODO Auto-generated method stub
		return hospitalSumRepo.findHospitalSumByTopList();
	}



	

}
