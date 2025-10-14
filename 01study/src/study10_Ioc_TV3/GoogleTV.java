package study10_Ioc_TV3;

public class GoogleTV implements TV{
	public GoogleTV() {
		System.out.println("====> GoogleTV 생성"); 
	}
	
	public void powerOn() {
		System.out.println("GoogleTV --- 전원 켠다.");
	}
	
	public void powerOff() {
		System.out.println("GoogleTV --- 전원 끈다.");
	}
	public void volumeUp() {
		System.out.println("GoogleTV --- 소리 올림.");
	}
	
	public void volumeDown() {
		System.out.println("GoogleTV --- 소리 내림.");
	}

}

