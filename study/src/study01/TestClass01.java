package study01;

import java.util.Iterator;

public class TestClass01 {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30 };
		System.out.println(arr.length);

		String[] str = new String[] { "서울", "부산", "대구" };
		int[] num = { 2, 1, 3, 4, 5, 30 };

		System.out.println(str.length);

		for (int i = 0; i < str.length; i++) {
			System.out.println("지역 [" + i + "] : " + str[i]);
		}

		// foreach
		for (String city : str) {
			System.out.println(city);

		}

		for (int item : num) {
			System.out.println(item);
		}
		
		// sum값
		int sum = 0;
		for (int i : num) {
			sum = sum + i;
		}
		double avg = (double) sum / num.length; // 45/6 = 7.5 : double로 형변환
		//int avg = (double) sum / num.length; // 45/6 = 7 : 정수값으로 계산되므로 int값나옴
		System.out.println("합계는 " + sum + "입니다.");
		System.out.println("평균은 " + avg + "입니다.");
		
		//최소값, 최대값
		int min = num[0];
		for(int n:num) { //{ 2, 1, 3, 4, 5, 30 };
			//최소값
			if (n < min) {
				min = n;
			}
			//최대값
//			if (n > min) {
//				min = n;
//			}
		}
		System.out.println("최소값:" + min);
		
//		for(int i;name) {
//			System.out.println(i);
//		}

	}

}
