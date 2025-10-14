package study02;

public class Box {
	int width;
	int length;
	int height;
	
	public Box() {} // 생성자 있을경우 기본값을 반드시 SETTING 해야함
	
	public Box(int w, int l, int h) { //생성자를 사용하여 Class멤버변수 SET
		this.width = w;
		this.height = l;
		this.length = h;
	}

	public double getVolume() {
		return (double) width * height * length;  
	}
}
