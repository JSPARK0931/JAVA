package study06_join;

public class Warrior extends GameCharacter {
	String weapon;

	public Warrior(String name, int level, int hp, String weapon) {
		super(name, level, hp);
		this.weapon = weapon;
	}
	
	public void defend() {
		System.out.println(name + "님이 방어를 시작합니다.");
	}

	@Override
	public void attack() {
//		super.attack();
		System.out.println(name + "님이 " + weapon + "공격을 시작합니다.");
	}
	
}
