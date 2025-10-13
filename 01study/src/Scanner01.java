import java.util.Scanner;

public class Scanner01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //System.out.println("문자열을 입력하세요");
        
        // String strInput = scan.nextLine();
        // String strInput1 = scan.nextLine();
        // System.out.println("입력된값 : " + strInput + ","  + strInput1);
        // scan.close();
        System.out.println("숫자를 입력하세요");
        String strInput1 = scan.nextLine();
        int num1 = Integer.parseInt(strInput1);
        int num2 = 5;
        
        System.out.println("입력값 :" + num1 + "," + num2 );
        System.out.println(num1 + num2);
    }
   
    
}
