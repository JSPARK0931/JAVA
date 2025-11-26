package com.study.spring.hospital;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface HospitalSumDTO {
	String getH_code();
	String getH_name();
	Long getReview_cnt();
	Double getAvg_eval_pt();
	Long getComment_cnt();
	
//	 JQPL에서 호출할 생성자
//	public HospitalSumDTO(String h_code, String h_name, Long comment_cnt, Double avg_eval_pt) {
//        this.h_code = h_code;
//        this.h_name = h_name;
//        this.comment_cnt = comment_cnt;
//        this.avg_eval_pt = avg_eval_pt;
//	}
}
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class HospitalSumDTO {
//	private String h_code;
//	private String h_name;
//	private Long comment_cnt;
//	private Double avg_eval_pt;
	
	// JQPL에서 호출할 생성자
//	public HospitalSumDTO(String h_code, String h_name, Long comment_cnt, Double avg_eval_pt) {
//        this.h_code = h_code;
//        this.h_name = h_name;
//        this.comment_cnt = comment_cnt;
//        this.avg_eval_pt = avg_eval_pt;
//	}
//}
