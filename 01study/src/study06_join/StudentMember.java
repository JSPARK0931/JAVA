package study06_join;

public class StudentMember extends Member {
	String school;
	
	public StudentMember(String name, int age, String school) {
		super(name, age );
		this.school = school;
	}
	

	@Override
	public void join() {
//		super.join();
		System.out.println("[학생회원]" + name +"님 힉교(" + school + ")정보와 함께가입되었습니다.");
	}
	
	public void study() {
		//System.out.println("학교명:" + school +",이름:" + name + ",나이:" + age);
		System.out.println(name + "님이 공부를 시작합니다.");
	}
}
