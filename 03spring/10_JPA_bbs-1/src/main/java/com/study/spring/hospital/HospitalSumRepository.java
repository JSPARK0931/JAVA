package com.study.spring.hospital;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalSumRepository extends JpaRepository<Hospital, String>{

//	@Query("""
//			SELECT new com.example.dto.HospitalSumDTO(
//				H.h_code, 
//				H.h_name, 
//				COUNT(R), ROUND(AVG(R.r_eval_pt),1) )
//		 	FROM Hospital H JOIN H.H_review R
//		 	GROUP BY H.h_code, H.h_name 
//		 	ORDER BY COUNT(R), ROUND(AVG(R.r_eval_pt),1)
//			""")
//	 @Query(value = "SELECT H.h_code AS h_code, " +
//             "       H.h_name AS h_name, " +
//             "       COUNT(*) AS comment_cnt, " +
//             "       ROUND(AVG(R.r_eval_pt), 1) AS avg_eval_pt " +
//             "FROM hospital H " +
//             "JOIN h_review R ON H.h_code = R.h_code " +
//             "GROUP BY H.h_code, H.h_name " +
//             "ORDER BY comment_cnt desc, avg_eval_pt desc", // SQL 위치 지정자 사용 가능
//             nativeQuery = true) // <-- 네이티브 쿼리 활성화
	 @Query(value = """
	 		SELECT H.h_code AS h_code,
                    H.h_name AS h_name,
                    COUNT(*) AS review_cnt,
                    ROUND(AVG(R.r_eval_pt), 1) AS avg_eval_pt
             FROM hospital H
             JOIN h_review R ON H.h_code = R.h_code
             WHERE COALESCE(R.r_del_yn,'N') = 'N'
             GROUP BY H.h_code, H.h_name
             ORDER BY review_cnt desc, avg_eval_pt desc
             """, // SQL 위치 지정자 사용 가능
             nativeQuery = true) // <-- 네이티브 쿼리 활성화
	 List<HospitalSumDTO> findHospitalSum1();
	 //List<HospitalSumDTO> findHospitalSum1();
	 
	 @Query(value = """
		 		SELECT H.h_code, 
		 			H.h_name, 
		 			COUNT(DISTINCT R.r_id) REVIEW_CNT, 
		 			ROUND(AVG(R.r_eval_pt),1) AVG_EVAL_PT, 
		 			COUNT(DISTINCT C.c_id) COMMENT_CNT
	 			FROM hospital H
	 			JOIN h_review R ON H.h_code = R.h_code
	 			LEFT JOIN h_comment C ON R.r_id = C.r_id
	 			WHERE COALESCE(R.r_del_yn,'N') = 'N'
	 			AND COALESCE(C.c_del_yn,'N') = 'N' 
	 			GROUP BY H.h_code, H.h_name
	 			ORDER BY REVIEW_CNT DESC,AVG_EVAL_PT DESC, COMMENT_CNT DESC
	             """, // SQL 위치 지정자 사용 가능
	             nativeQuery = true) // <-- 네이티브 쿼리 활성화
	 List<HospitalSumDTO> findHospitalSum2();
	 
	 @Query(value = """
		 		SELECT H.h_code, 
		 			H.h_name, 
		 			COUNT(DISTINCT R.r_id) REVIEW_CNT, 
		 			ROUND(AVG(COALESCE(R.r_eval_pt,0)),1) AVG_EVAL_PT, 
		 			COUNT(DISTINCT C.c_id) COMMENT_CNT
	 			FROM hospital H
	 			JOIN h_review R ON H.h_code = R.h_code
	 			LEFT JOIN h_comment C ON R.r_id = C.r_id
	 			WHERE COALESCE(R.r_del_yn,'N') = 'N'
	 			AND COALESCE(C.c_del_yn,'N') = 'N' 
	 			GROUP BY H.h_code, H.h_name
	 			ORDER BY REVIEW_CNT DESC,AVG_EVAL_PT DESC, COMMENT_CNT DESC
	             """, // SQL 위치 지정자 사용 가능
	             nativeQuery = true) // <-- 네이티브 쿼리 활성화
	 List<HospitalSumDTO> findHospitalSumByReviewCnt();
	 
	 @Query(value = """
		 		SELECT H.h_code, 
		 			H.h_name, 
		 			COUNT(DISTINCT R.r_id) REVIEW_CNT, 
		 			ROUND(AVG(R.r_eval_pt),1) AVG_EVAL_PT, 
		 			COUNT(DISTINCT C.c_id) COMMENT_CNT
	 			FROM hospital H
	 			JOIN h_review R ON H.h_code = R.h_code
	 			LEFT JOIN h_comment C ON R.r_id = C.r_id
	 			WHERE COALESCE(R.r_del_yn,'N') = 'N'
	 			AND COALESCE(C.c_del_yn,'N') = 'N' 
	 			GROUP BY H.h_code, H.h_name
	 			ORDER BY AVG_EVAL_PT DESC, REVIEW_CNT DESC, COMMENT_CNT DESC
	             """, // SQL 위치 지정자 사용 가능
	             nativeQuery = true) // <-- 네이티브 쿼리 활성화
	 List<HospitalSumDTO> findHospitalSumByEvalPt();
	 
	 @Query(value = """
		 		SELECT H.h_code, 
		 			H.h_name, 
		 			COUNT(DISTINCT R.r_id) REVIEW_CNT, 
		 			ROUND(AVG(R.r_eval_pt),1) AVG_EVAL_PT, 
		 			COUNT(DISTINCT C.c_id) COMMENT_CNT
	 			FROM hospital H
	 			JOIN h_review R ON H.h_code = R.h_code
	 			LEFT JOIN h_comment C ON R.r_id = C.r_id
	 			WHERE COALESCE(R.r_del_yn,'N') = 'N'
	 			AND COALESCE(C.c_del_yn,'N') = 'N' 
	 			GROUP BY H.h_code, H.h_name
	 			ORDER BY COMMENT_CNT DESC, AVG_EVAL_PT DESC, REVIEW_CNT DESC 
	             """, // SQL 위치 지정자 사용 가능
	             nativeQuery = true) // <-- 네이티브 쿼리 활성화
	 List<HospitalSumDTO> findHospitalSumByCommentCnt();
	 
	 @Query(value = """
		 		SELECT H.h_code, 
		 			H.h_name, 
		 			COUNT(DISTINCT R.r_id) REVIEW_CNT, 
		 			ROUND(AVG(R.r_eval_pt),1) AVG_EVAL_PT, 
		 			COUNT(DISTINCT C.c_id) COMMENT_CNT
	 			FROM hospital H
	 			JOIN h_review R ON H.h_code = R.h_code
	 			LEFT JOIN h_comment C ON R.r_id = C.r_id
	 			WHERE COALESCE(R.r_del_yn,'N') = 'N'
	 			AND COALESCE(C.c_del_yn,'N') = 'N' 
	 			GROUP BY H.h_code, H.h_name
	 			ORDER BY AVG_EVAL_PT DESC, REVIEW_CNT DESC, COMMENT_CNT DESC
	 			LIMIT 3
	             """, // SQL 위치 지정자 사용 가능
	             nativeQuery = true) // <-- 네이티브 쿼리 활성화
	 List<HospitalSumDTO> findHospitalSumByTopList();
}
