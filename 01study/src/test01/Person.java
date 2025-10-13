package test01;

public class Person {
   
    String name;
    int    age;

    public Person(){}  // 디펄트 생성자

     //생성자 , 초기값
    public Person(String name, int age){
        this.name = name;       // this. 생성자의 name
        this.age  = age;
    }
}

