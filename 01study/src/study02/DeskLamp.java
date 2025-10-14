package study02;

public class DeskLamp {
	private boolean isOn; //초기값 FALSE
	String color;
	
	public DeskLamp() {}  // default 생성자(초기값)

	public void turnOn() {
		isOn = true;
		color = "YELLOW";
	}

	public void turnOFF() {
		isOn = false;
		color = "NONE";
	}
	
//	@Override 
//	public String toString() {
//		return "DeskLamp [isOn=" + isOn + ", color=" + color + "]";
//	}
	
	public String toString() {
		return "DeskLamp [isOn=" + isOn + ", color=" + color + "]";
		//return (isOn ==true) 
	}

	
}
