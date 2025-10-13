package study02;

public class StudentTest {

	public static void main(String[] args) {
		Student lee = new Student();
		lee.studentName = "이순신";
		lee.address = "서울";
		
		Student han = new Student();
		han.studentName = "한석봉";
		han.address = "부산";
		
		System.out.println(lee.studentName);
		
		//메쏘드 실행
		lee.showInfo();
		han.showInfo();
		
	
		//좌표값 (hip memory)
		System.out.println(lee);
		System.out.println(han);

	}

}
