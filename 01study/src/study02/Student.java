package study02;

public class Student {
	// 멤버변수를 생성
	private int studentId; //은닉화
	String studentName;
	String address;
	
	//생성자 (default)
	public Student() {}
	
	//메쏘드 (hip memory)
	public void showInfo() {
		System.out.println(studentName +", " + address);
	}
	
	
	
}
