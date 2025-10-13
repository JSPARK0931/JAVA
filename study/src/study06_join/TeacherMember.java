package study06_join;

public class TeacherMember extends Member{
	String subject;
	
	public TeacherMember(String name, int age, String subject) {
		super(name, age);
		this.subject = subject;
	}

	@Override
	public void join() {
		// TODO Auto-generated method stub
		//super.join();
		System.out.println("[교사회원]" + name +"님 과목(" + subject + ")정보와 함께가입되었습니다.");
	}
	
	public void teach() {
		//System.out.println("학교명:" + school +",이름:" + name + ",나이:" + age);
		System.out.println(name + "님이 과목을 시작합니다.");
	}
	
	
}
