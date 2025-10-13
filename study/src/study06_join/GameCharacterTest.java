package study06_join;

public class GameCharacterTest {

	public static void main(String[] args) {
		// 레퍼런스 자료형을 부모형으로 등록한다. 
		GameCharacter c1 = new Warrior("전사", 100, 200, "장검");
		c1.showInfo();
		c1.attack();
		
				
		GameCharacter c2 = new Mage("법사", 50, 100, "원거리");
		c2.showInfo();
		c2.attack();
		
		GameCharacter c3 = new Archer("궁수", 60, 120, "불화살");
		c3.showInfo();
		c3.attack();
		
		System.out.println("============================");
		// 형변환으로 되면 자식의 메쏘드 및 부모의 메쏘드를 사용할 수 있다.
		Warrior w1 = (Warrior) c1;
		w1.showInfo();
		w1.attack();
		w1.defend();
		System.out.println("----------------------------");
		Mage m1 = (Mage) c2;
		w1.showInfo();
		w1.attack();
		m1.teleport();
		System.out.println("----------------------------");
		Archer a1 = (Archer) c3;
		w1.showInfo();
		w1.attack();
		a1.hide();
	}

}
