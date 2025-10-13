package study02;

public class DeskLampTest {

	public static void main(String[] args) {
		DeskLamp myLamp = new DeskLamp();
		//myLamp.isOn = true; // private 이므로 사용목함
		
		myLamp.turnOn();
//		System.out.println(myLamp); // 좌표값
		System.out.println(myLamp.toString());
//		myLamp.turnOFF();
		
		myLamp.turnOFF();
		System.out.println(myLamp.toString());
				
	}

}
