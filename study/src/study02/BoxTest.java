package study02;

public class BoxTest {

	public static void main(String[] args) {
		Box b = new Box();
		
		b.width = 20;
		b.height = 20;
		b.length = 20;
				
		double result = b.getVolume();
		System.out.println("가로 :" + b.width);
		System.out.println("세로 :" + b.length);
		System.out.println("높이 :" + b.height);
		System.out.println("상자의크기는 " + result);
				
		Box c = new Box(10,20,30);
		double result2 = c.getVolume();
		System.out.println("가로 :" + c.width);
		System.out.println("세로 :" + c.length);
		System.out.println("높이 :" + c.height);
		System.out.println("상자의크기는 " + result2);
		
	}

}
