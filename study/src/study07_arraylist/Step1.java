package study07_arraylist;

import java.util.ArrayList;

public class Step1 {

	public static void main(String[] args) {
		//generic : 어떤타입이라도 올수있다. reference type : 원시타입 : int X, Integer O, double X, Double O
		ArrayList<String> fruits = new ArrayList<>();

//		ArrayList<> name = new ArrayList<>();	
		//String[] data = new String[5]; // 배열 
		
		//값추가
		fruits.add("사과");
		fruits.add("바나나");
		fruits.add("딸기");
		
		//print
		System.out.println(fruits);
		System.out.println("------------------------------------");		
		//get index
		System.out.println(fruits.get(0));
		System.out.println("------------------------------------");		
		//count
		System.out.println(fruits.size());
		System.out.println("------------------------------------");		
		//set value : modify
		System.out.println(fruits.set(1, "자두"));
		System.out.println(fruits.get(1));
		System.out.println("------------------------------------");							
		//remove
		System.out.println(fruits.remove(0));
		System.out.println(fruits);
		
		System.out.println("------------------------------------");
		for(int i=0; i < fruits.size(); i++) {
			System.out.println(i +"번째 과일은 "+ fruits.get(i));
		}
		//forEach
		for (String item:fruits) {
			System.out.println("과일:" + item);
		}
		System.out.println("=====================================");
		ArrayList<Integer> num = new ArrayList<Integer>();
		num.add(10);
		num.add(20);
		num.add(30);
		num.add(40);
		
		System.out.println(num);
		int sum = 0;
		for(int number:num) {
			sum += number;
		}
		System.out.println("합계 : " + sum);
		
		
	}

}
