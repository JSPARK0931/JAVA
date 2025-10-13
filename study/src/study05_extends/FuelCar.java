package study05_extends;

public class FuelCar extends Car{
	String fuelType;
	
	public FuelCar(int speed, String name, String fuelType) {
		super(speed, name);
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return "FuelCar [fuelType=" + fuelType + ", speed=" + speed + ", name=" + name + "]";
	}

	

	
}

