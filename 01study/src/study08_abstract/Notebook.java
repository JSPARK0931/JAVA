package study08_abstract;

public class Notebook extends Computer {

	@Override
	public void display() {
		System.out.println("Notebook display");
	}

	@Override
	public void turnOn() {
		System.out.println("Notebook turnOn");
	}

	@Override
	public void turnOff() {
		System.out.println("Notebook turnOff");
	}
	
	public void fn_notebook() {
		System.out.println("fn_notebook function!!");
		
	}
}
