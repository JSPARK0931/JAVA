package study09_interface;

// interface로 지정한 객체는 implements를 사용해야함 ( cf) 상속시 extends)
// 추상화가되었는 add, substract, times, divide가 있으므로 abstract를 해야함
public abstract class Calculator implements Calc{

	@Override
	public int add(int num1, int num2) {
		
		return num1 + num2;
	}
	
	@Override
	public int substract(int num1, int num2) {
		
		return num1 - num2;		
	}
	
}
