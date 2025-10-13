package test01;

public class FuncTest01 {

    public static void sayHello(String arg_name, int arg_year){
        System.out.println(arg_name + "님 안녕하세요!!" + arg_year );
    }
    
    public static int add(int a, int b){
        return a + b;
    }

    public static String text(String a){
        return a;
    }
    

    public static void main(String[] args) {
        sayHello("홍길동",21);
        sayHello("강남길",22);
        sayHello("김길리",23);
        sayHello("철수  ",23);
        sayHello("영희  ",23);

        int result = add(10,20);
        System.out.println("합은 :" + result);

        String result1 = text("반갑습니다.");
        System.out.println(result1);
    }
}
