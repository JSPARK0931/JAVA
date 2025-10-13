package study04;

public class UserInfoTest {

	public static void main(String[] args) {
		UserInfo userLee = new UserInfo();
	//	userLee.userId   = "00011";
		userLee.userName = "홍길동";
		
		System.out.println(userLee.userName);
		System.out.println(userLee.userEmail);
		
		// constructor 함수 오버로딩, 디펄트 함수 필요함.
		UserInfo userHan = new UserInfo("00011", "한석봉");
		UserInfo userHan1= new UserInfo("00012", "한철수", "test@test.com");
	
		System.out.println(userHan.ShowInfo());
		System.out.println(userHan1.ShowInfo());
		
		System.out.println(userHan.getUserId());
		
//		userHan.userHan = "00013"; // userId private이므로 접근불가
		
		System.out.println(userHan.toString());
	}
	
}
