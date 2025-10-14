package study07_arraylist;

import java.util.ArrayList; // ArrayList
import java.util.Scanner; //문자넣을때 사용

public class CafeMenu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> menu = new ArrayList<>();
		
		while(true) {
			System.out.println("====== 카페메뉴 관리프로그램 ======");
			System.out.println("1.메뉴추가");
			System.out.println("2.메뉴보기");
			System.out.println("3.메뉴수정");
			System.out.println("4.메뉴삭제");
			System.out.println("5.종료");
			System.out.print("번호를 선택하세요 :");
			
			int choice = sc.nextInt();
			sc.nextLine(); //버퍼지우기
			
			System.out.println("-----------------------------");
			
			switch(choice) {
				case 1:
					System.out.println("추가할 메뉴이름 :");
					String newMenu = sc.nextLine();
					menu.add(newMenu);
					System.out.println(newMenu + "가 추가되었습니다.");
					break;
				case 2:
					//if (menu.isEmpty() == true) {
					if (menu.isEmpty()) {
						System.out.println("등록된 메뉴가 없습니다.");
					}
					else {
						System.out.println("카페메뉴 : ");
						for(int i= 0;i < menu.size(); i++) {
							System.out.println((i+1)  + ". " + menu.get(i));	
						}
					}	
					break;
				case 3:
					System.out.println("수정할 메뉴번호를 입력하세요.");
					int updateIndex = sc.nextInt()-1;
					sc.nextLine();
					//if (updateIndex < 0 && updateIndex < menu.size())
					if (updateIndex >= 0 && updateIndex < menu.size()) {
						System.out.println("새로운 메뉴 이름:" );
						String updateName = sc.nextLine();
						System.out.println(menu.get(updateIndex) + "->" + updateName +"으로 변경중입니다..");
						menu.set(updateIndex, updateName);
						System.out.println("메뉴가 수정되었습니다.");

					}
					else {
						System.out.println("잘못된 번호입니다.");
					}
					
//					String delMenu = sc.nextLine();
//					for (int i;i<menu.size();i++) {
//						if (delMenu == menu.get(i)) {
//							menu.remove(i);
//						}
//					}
					break;
				case 4:
					System.out.println("삭제할 메뉴번호를 입력하세요.");
					int deleteIndex = sc.nextInt() -1;
					sc.nextLine();
					
					if (deleteIndex >= 0 && deleteIndex < menu.size()) {
						String removed = menu.remove(deleteIndex);
						System.out.println(removed + "메뉴가 삭제되었습니다.");
					}
					else {
						System.out.println("잘못된 번호입니다.");
					}
					
					break;
				case 5:
					System.out.println("프로그램을 종료합니다.");
					return; // 프로그램 종료
				default :
					System.out.println("선택번호를 확인하세요.");
					break;	
			
			}
		}
	}

}
