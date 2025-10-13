public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        //정수 => 실수
        //실수 => 정수

        //정수 : long(8) > int(4) > short(2) > byte(1)
        //실수 : double(8) > float(4)

        //double * int  => double
        //long * int => long

        int num = 10;
        float floatNum = num;

        System.out.println(floatNum); // 묵시적형병환 10
        System.out.println((int)floatNum); // 명시적형변환 10.0

        short sNum = 200;
        System.out.println(sNum); //200
        byte byteNum = (byte)sNum;
        System.out.println(byteNum); // -56

        char myChar = 'A';
        System.out.println(myChar);
        System.out.println((int)myChar);

        char myChar1 = (char)42;
        System.out.println(myChar1);

        String txt = "안녕하세요";
        System.out.println(txt);
       

    }
}


