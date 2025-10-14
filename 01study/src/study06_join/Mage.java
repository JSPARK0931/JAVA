package study06_join;

public class Mage extends GameCharacter {
	
	String element;
	public Mage(String name, int level, int hp, String element) {
		super(name, level, hp);
		this.element = element;
	}

	public void teleport() {
		System.out.println(name + "님이 공간이동을 시작합니다.");
	}

	@Override
	public void attack() {
//		super.attack();
		System.out.println(name + "님이 " + element + "공격을 시작합니다.");
	}
	

	
}
