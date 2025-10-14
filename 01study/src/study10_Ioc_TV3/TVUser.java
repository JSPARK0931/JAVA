package study10_Ioc_TV3;

public class TVUser {

	public static void main(String[] args) {
		//interface를 사용하여 해결함
		//TV tv = new LgTV();
		BeanContainer container = new BeanContainer();
		
		TV tv = (TV)container.getBean(args[0]);
		//TV tv = (TV)container.getBean("lg");
		//TV tv = (TV)container.getBean("samsung");
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		

//		TV tv1 = new SamsungTV();
//		
//		tv1.powerOn();
//		tv1.powerOff();
//		tv1.volumeUp();
//		tv1.volumeDown();

	}

}
