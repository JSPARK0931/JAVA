package study05_extends;
//import study04.UserInfo; //다른 package에 있을때 import 사용

public class Car {
	int speed;
	String name;
	
	
	public Car(int speed,String name) {
		this.speed = speed;
		this.name = name;
	}
	

	public void setSpeed(int speed) {
		this.speed = speed;
		
	}

}
