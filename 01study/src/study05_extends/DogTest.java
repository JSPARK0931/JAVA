package study05_extends;

public class DogTest {

	public static void main(String[] args) {
		Dog myfat = new Dog("퍼피",5);
		Cat mycat = new Cat("나비",3);

		//Animal 변수에 Dog이라는 참조데이터를 넣었다.
		//부모타입으로 들어가는것 UPCASTING
		Animal myfat1 = new Dog("코코",3);
		Animal mycat1 = new Cat("타코",5);
		myfat.foot = 4;
		
		//부모형으로 썼을때는 자식의 Override된 메쏘는 사용가능
		//부모형으로 받을때는 자식의 멤버변수는 사용불가 foot불가
		myfat1.makeSound();
	//	myfat1.dogSkill();
		
		Animal tigerMan = new Tiger("타거",5);
		tigerMan.makeSound();
		
		//Animal을 Dog으로 형변환
		Dog myfat2 = (Dog)myfat1;
		myfat2.foot = 10;
		
		
//		myfat.name = "퍼피";
//		System.out.println(myfat.name);
		myfat.showInfo();	
		System.out.println(myfat.toString());
		myfat.makeSound();
		
		System.out.println(mycat.toString());
		mycat.makeSound();

	}

}
