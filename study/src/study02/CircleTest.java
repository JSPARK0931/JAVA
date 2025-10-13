package study02;

public class CircleTest {

	public static void main(String[] args) {
		Circle obj = new Circle();
		
		obj.radius = 100; //객체의 필드 접근
		obj.color = "blue"; 
		obj.radius = 1000;
		
		obj.getArea();
		
//		System.out.println(obj);
//		System.out.println(obj.radius + ", " + obj.color);
//		
//		System.out.println(obj.getArea1());
		
		int area = (int) obj.getArea1();
		System.out.println("1.원의면적은 " + area);
		
		double area2 = obj.getArea1();
		System.out.println("2.원의면적은 " + area2);

	}

}
