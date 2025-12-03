package com.study.spring.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.study.spring.hospital.dto.HospitalSumInfoDTO;
import com.study.spring.hospital.entity.Hospital;

@Repository
public interface  HospitalSumInfoRepository extends JpaRepository<Hospital, String>{
	 
	 @Query(value = """
		 		SELECT H.h_code AS h_code, 
		 			H.h_name AS h_name, 
		 			MAX(H.h_bigo) AS h_bigo,
		 			MAX(H.h_content) AS h_content,
		 			MAX(H.h_smpl_dgm) AS h_smpl_dgm,
		 			MAX(H.h_addr) AS h_addr,
					MAX(H.h_tel1) As h_tel1,
					MAX(H.h_long) As h_long,
					MAX(H.h_lat) As h_lat,
					MAX(CASE WHEN H.h_park_yn = 'Y' THEN '주차가능' ELSE '주차불가'END ) AS h_park_yn,
					MAX(H.h_bigo) AS h_bigo,
					MAX(S.h_mon_s) AS h_mon_s,
					MAX(S.h_mon_c) AS h_mon_c,
					MAX(S.h_tue_s) AS h_tue_s,
					MAX(S.h_tue_c) AS h_tue_c, 
		 			COUNT(DISTINCT R.r_id) AS review_cnt, 
		 			ROUND(AVG(COALESCE(R.r_eval_pt,0)),1) AS avg_eval_pt, 
		 			COUNT(DISTINCT C.c_id) AS comment_cnt,
		 			COUNT(DISTINCT L.l_id) AS like_cnt
	 			FROM hospital H
	 			JOIN hospital_s S ON H.h_code = S.h_code
	 			LEFT JOIN h_review R ON H.h_code = R.h_code
	 			LEFT JOIN h_comment C ON R.r_id = C.r_id
	 			LEFT JOIN h_like L ON R.r_id = L.r_id
	 			WHERE COALESCE(R.r_del_yn,'N') = 'N'
	 			AND COALESCE(C.c_del_yn,'N') = 'N' 
	 			GROUP BY H.h_code, H.h_name
	 			""", // SQL 위치 지정자 사용 가능
	             nativeQuery = true) // <-- 네이티브 쿼리 활성화
	 List<HospitalSumInfoDTO> findHospitalSumInfo();
}
