package study04;

public class UserInfo {
	
	// default 제어자는 자신의 패키지
	// public은 전체접근
	// private 클래스안에서만 사용
	private String userId;
	public String userPassword;
	public String userName;
	public String userEmail;
	public String userPhone;
	
	public UserInfo() {}

	public UserInfo(String userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}

//	public UserInfo(String userId, String userName, String userEmail) {
//		this.userId = userId;
//		this.userName = userName;
//		this.userEmail = userEmail;
//	}

	public UserInfo(String userId, String userName, String userEmail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
	}
	
//	public String getUserId(String userId) {
//		return userId;
//	}
//	public String setUserId(String userId) {
//		this.userId = userId;
//}
	public String getUserId() {
		return userId;
	}
	

	

	@Override //
	public String toString() {
		return "UserInfo [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", userPhone=" + userPhone + "]";
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String ShowInfo() {
		return "고객ID:" + userId + "이고, 등록된이름은 " + userName + "입니다.";
	}
	
	
}
