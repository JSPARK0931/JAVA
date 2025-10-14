package study08_abstract;

public abstract class Computer {
	int ram;
	int cpu;
	
	// 추상화는 구현제가 없다.
	public abstract void display();
	
	public abstract void turnOn();
	
	public abstract void turnOff();
	


//	public void turnOn() {
//		System.out.println("전원을 켭니다.");
//	}
	
//	public void turnOff() {
//		System.out.println("전원을 끕니다.");
//	}
//	
}
