package study09_interface;

public interface Calc1 {
	// public static final이 숨겨진 상태임 -> interface 클래스로 만들때 생성됨 new로 생성불가
	// public static final double PI = 3.14;
	// double PI = 3.14;
	
	double PI = 3.14;
	abstract int add();
	
}

