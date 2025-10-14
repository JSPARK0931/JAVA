package study09_interface;

public interface Calc {
	// public static final이 숨겨진 상태임 -> interface 클래스로 만들때 생성됨 new로 생성불가
	// public static final double PI = 3.14;
	// double PI = 3.14;
	// interface는 abstract가 생략됨. interface가 아닌 class 컴파일할때는 abstract가 필요함
	double PI = 3.14;
	int add(int num1, int num2);
	int substract(int num1, int num2);
	int times(int num1, int num2);
	int divide(int num1, int num2);

}
