package test01;

public class FuncPersion1 {
    public static void main(String[] args) {
        Person P = new Person();
        P.name = "한성용";
        P.age  = 20;
       
        System.out.println(P.toString());    // 16진수 좌표  
        System.out.println(P.name);
        System.out.println(P.age);

        Person P1 = new Person("한성용2", 22);
        System.out.println(P1.name);
        System.out.println(P1.age);

        P1.name = "가나다";
        P1.age  = 20;
        // Person("가나다",10);
        System.out.println(P1.name);
        System.out.println(P1.age);

    }
}
