package study09_interface;

public class CalculatorTest {
	public static void main(String[] args) {
		Calc cTest = new CompleteCalc(); //upcasting
		CompleteCalc cTest3 = new CompleteCalc();
	    // Calculator cTest4 = new Calcuator(); // 처리불가, interface inplement된 class는 생성자 불가
		Calculator cTest5 = new CompleteCalc();
		
		int num1 = 10;
		int num2 = 2;

		System.out.println("cTest ---- Calc -> CompleteCalc");
		System.out.println(cTest.add(num1, num2));
		System.out.println(cTest.substract(num1, num2));
		System.out.println(cTest.times(num1, num2));
		System.out.println(cTest.divide(num1, num2));
		//System.out.println(cTest.showInfo()); //showInfo는 CompleteCalc에 선언되어있으므로, 형변환이 필요함 
		
		System.out.println("------------------------------");
		
		//downCasting
		System.out.println("cTest1 ---- Calc -> CompleteCalc -> CompleteCalc 형변환");
		CompleteCalc cTest1 = (CompleteCalc)cTest;
		System.out.println(cTest1.add(num1, num2));
		System.out.println(cTest1.substract(num1, num2));
		System.out.println(cTest1.times(num1, num2));
		System.out.println(cTest1.divide(num1, num2));
		System.out.println(cTest1.showInfo());
		
		System.out.println("------------------------------");
		
		//downCasting
		System.out.println("cTest3 ---- CompleteCalc -> CompleteCalc");
		System.out.println(cTest3.add(num1, num2));
		System.out.println(cTest3.substract(num1, num2));
		System.out.println(cTest3.times(num1, num2));
		System.out.println(cTest3.divide(num1, num2));
		System.out.println(cTest3.showInfo());
		
		System.out.println("------------------------------");
		
		//downCasting
		System.out.println("cTest5 ---- Calculator -> CompleteCalc");
		System.out.println(cTest5.add(num1, num2));
		System.out.println(cTest5.substract(num1, num2));
		System.out.println(cTest5.times(num1, num2));
		System.out.println(cTest5.divide(num1, num2));
		//System.out.println(cTest5.showInfo());		//처리불가  
		//cTest.
		//cTest1.
		
	}

}
