package com.study.spring.testboard;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.spring.board.entity.Board;
import com.study.spring.board.entity.Image;
import com.study.spring.board.repository.BoardRepository;
import com.study.spring.board.repository.ImageRepository;
import com.study.spring.member.entity.Member;
import com.study.spring.member.repository.MemberRepository;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class TestBoard {
	
	@Autowired
	public MemberRepository memberRepo;

	@Autowired
	public BoardRepository boardRepo;

	@Autowired
	public ImageRepository imageRepo;

	// TestBoard.java run as => jnuit test 실행
//	@Test
//	public void insertBoard() {
//		// 단일데이터 Optional 사용해도됨
//		// Insert 위해 Member에서 id = 1 찾음
//		//Longtype id = 1
//		Member member = memberRepo.findById(1L)
//					.orElseThrow(()-> new IllegalArgumentException("멤버가 없습니다."));
//		
////		Board board = new Board();
////			board.setTitle("안녕하세요2");
////			board.setContent("만나서반갑습니다2");
////			board.setName("김구라");
////			board.setMember(member);
//		Board board = Board.builder()
//			.title("안녕2")
//			.content("내용2")
//			.name("김구라")
//			.member(member)
//			.build();
//			
//		Board saveBoard = boardRepo.save(board);
//		log.info("글작성 " + saveBoard );
//		log.info("아이디 " + member);
//		
//	}

//	// 이미지 저장
//	@Test
//	public void insertImage() {
//		Board board = boardRepo.findById(14L)
//				.orElseThrow(() -> new IllegalArgumentException("데이터가 없습니다."));
//
//		Image img1 = Image.builder().originalFileName("cat2.jpg")
//				.fileName("cat2_.jpg")
//				.board(board)
//				.build();
//		
//		Image saveImage = imageRepo.save(img1);
//		
//		log.info("글보기" + board);
//		log.info("저장 :" + saveImage);
//		
//		log.info("저장된 이미지 id ={} ",saveImage.getId() );
//		log.info("저장된 이미지 {} ",saveImage.getOriginalFileName() );
//	}
	
	@Test
	public void getImageList() {
		Board board = boardRepo.findById(14L)
		.orElseThrow(() -> new IllegalArgumentException("데이터가 없습니다."));
		
		System.out.println("=======게시물정보=========");
		System.out.println("id    :" + board.getId());
		System.out.println("title : "+ board.getTitle());
		System.out.println("=======이미지=========");
		
		board.getImages().forEach(img -> {
			System.out.println("이미지 id :" + img.getId());
			System.out.println("파일명    :" + img.getOriginalFileName());
			System.out.println("순서     :" + img.getImageOrder() );
			System.out.println("====================");
		});
		
	}
}
