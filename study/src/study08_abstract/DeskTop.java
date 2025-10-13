package study08_abstract;

public class DeskTop extends Computer{

	@Override
	public void display() {
		System.out.println("Desktop Display");
	}

	@Override
	public void turnOff() {
		System.out.println("DeskTop을 끕니다.");
	}

	@Override
	public void turnOn() {
		System.out.println("DeskTop을 켭니다.");		
	}
	
	public void fn_test() {
		System.out.println("function Test");	
	}

}
