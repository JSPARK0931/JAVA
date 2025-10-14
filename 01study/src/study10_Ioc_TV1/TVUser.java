package study10_Ioc_TV1;

public class TVUser {

	public static void main(String[] args) {

		SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		// LgTv로 constructor를 변환시 별도생성자로 method를 일일히 변경해야함
		LgTV tv2 = new LgTV();
		tv2.turnOn();
		tv2.turnOff();
		tv2.soundUp();
		tv2.soundDown();
		
		//interface를 사용하여 해결함

	}

}
