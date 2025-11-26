package com.study.spring.hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HospitalSumController {

	@Autowired
	HospitalSumService HSservice;
	
	@GetMapping("/HS")
	public String HStest() {
		return "HS TEST!!!";
	}
	
	//-------------------------------------------------//
	// 병원리뷰건수, 평점평균 반올림                          // 
	//-------------------------------------------------//
	// 출력값 : 병원코드, 병원명, 병원리뷰건수, 병원평점평균	 	   //
	//-------------------------------------------------//
	// ORDER BY : 병원리뷰건수, 병원평점평균 				   //
	//-------------------------------------------------//
	@GetMapping("/HS1")
	public ResponseEntity<List<HospitalSumDTO>> getHospitalSum1(){
		List<HospitalSumDTO> summaries = HSservice.getHospitalSum1();
		if (summaries.isEmpty()) {
			return ResponseEntity.noContent().build(); // 결과가 없을 경우 204 No Content 반환
	    }
	        
	    return ResponseEntity.ok(summaries); // 결과가 있을 경우 200 OK와 데이터 반환
	}
	//-------------------------------------------------//
	// 병원리뷰건수, 평점평균 반올림, 코멘트갯수                 // 
	//-------------------------------------------------//
	// 출력값 : 병원코드, 병원명, 병원리뷰건수, 병원평점평균	,코멘트수 //
	//-------------------------------------------------//
	// ORDER BY : 병원리뷰건수, 병원평점평균, 코멘트수		   //
	//-------------------------------------------------//
	@GetMapping("/HS2")
	public ResponseEntity<List<HospitalSumDTO>> getHospitalSum2(){
		List<HospitalSumDTO> summaries = HSservice.getHospitalSum2();
		if (summaries.isEmpty()) {
			return ResponseEntity.noContent().build(); // 결과가 없을 경우 204 No Content 반환
	    }
	        
	    return ResponseEntity.ok(summaries); // 결과가 있을 경우 200 OK와 데이터 반환
	}
	
}
