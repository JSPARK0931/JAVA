package study05_extends;

public class ElecCar extends Car {
	int battery;

	public ElecCar(int speed, String name, int battery) {
		super(speed, name); //상속받는 생성자를 쓸때 사용
		this.battery = battery;
		
	}
	
	public void charge(int amount) {
		battery += amount;
	}

	@Override
	public String toString() {
		return "ElecCar [battery=" + battery + ", speed=" + speed + ", name=" + name + "]";
	}



	// override : 부모에 있는것을 사용함
//	@Override 
//	public String toString() {
//		return "ElecCar [battery=" + battery + ", speed=" + speed + ", name=" + name + ", getClass()=" + getClass()
//				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
//	}
	
	
	
}
