package test01;

import java.util.Scanner;

public class Scan03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("1.콜라 ,2.사이다, 3.커피");
        System.out.print("음료번호를 입력하세요 : ");

        int menu = scan.nextInt();
        
        if (menu == 1){
            System.out.println("1. 콜라는 2000원 입니다.");
        }
        else if (menu == 2){
            System.out.println("2. 사이다는 2000원 입니다.");
        }
        else if (menu == 3){
            System.out.println("3. 커피는 2000원 입니다.");
        }
        else {
            System.out.println("올바른 메뉴를 입력하세요.!!");
        }

    }
}
