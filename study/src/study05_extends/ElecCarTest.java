package study05_extends;

public class ElecCarTest {

	public static void main(String[] args) {
		ElecCar obj = new ElecCar(10,"테스트",100);
		
//		obj.speed = 10;
		System.out.println(obj);
		
		obj.charge(10);
		System.out.println(obj.toString());
		
		obj.setSpeed(20);
		System.out.println(obj);
		
		obj.name = "햄스터";
		System.out.println(obj);
		
		FuelCar car1 = new FuelCar(20, "쏘렌토","디젤");
		System.out.println(car1);
		car1.setSpeed(30);
		System.out.println(car1);
		

	}

}
