package study03;

public class StudentTest {

	public static void main(String[] args) {
//		Student lee = new Student();
//		
//		lee.studentName = "이순신";
//		
//		System.out.println(lee.studentName);

		Student han = new Student(123, "한석봉", 3);
		Student ka = new Student(124, "가나다", 1);
		Student kim = new Student(125, "김영수");
		
//		System.out.println(han.studentName);
//		System.out.println(ka.studentName);
		
		System.out.println(han.showStudentInfo());
		System.out.println(kim.showStudentInfo());
		
		
		
	}

}
