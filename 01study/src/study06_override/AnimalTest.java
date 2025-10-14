package study06_override;

public class AnimalTest {

	public static void main(String[] args) {

		// Animal타입으로 하위클래스를 선언하면 하위클래스의 메쏘드를 쓰기위해 형변환을 하면 된다.
        // Stack(임시) = Heap (오래)
		Animal mydog1 = new Dog("코코",3);
		Animal mycat1 = new Cat("나비",5);
		
		mydog1.makeSound();
		mydog1.showInfo();
		
		//형변환 wagTail 을 위해
		Dog mydog2 = (Dog) mydog1;
		mydog2.wagTail();
		
		System.out.println("===========================");
		
		mycat1.makeSound();
		mycat1.showInfo();
		Cat mycat2 = (Cat) mycat1;
		mycat2.scratch();
	}

}
