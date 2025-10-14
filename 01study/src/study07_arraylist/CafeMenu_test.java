package study07_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class CafeMenu_test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Menu> menuList = new ArrayList<>();
		
		boolean stat = true;
		while(stat) {
			//메뉴print
			System.out.println("======메뉴 관리======");
			System.out.println("1. 메뉴 추가");
			System.out.println("2. 메뉴 보기");
			System.out.println("3. 메뉴 수정");
			System.out.println("4. 메뉴 삭제");
			System.out.println("5. 종료");
		
			int choice = sc.nextInt();	//메뉴번호입력
			sc.nextLine(); // 버퍼삭제
			
			switch (choice){
				case 1:
					sc.nextLine();
					sc.nextInt();
					
					break;
				case 2:
					if (menuList.isEmpty()) {
						System.out.println("등록된메뉴가없습니다...");
					}
					else {
						for(int i=0;i<menuList.size();i++) {
							System.out.println((i+1) + ". " + menuList.get(i).toString());
						}
					}
				case 3:
				case 4:
				case 5:
					System.out.println("메뉴를 종료합니다.");
					stat = false;
					break;
				default:
					System.out.println("메뉴를 확인하세요....");
			}
		}
	}
	
	

}
