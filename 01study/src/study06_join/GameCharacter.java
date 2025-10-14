package study06_join;

public class GameCharacter {
	String name;
	int level;
	int hp;
	
	public GameCharacter(String name, int level, int hp) {
		this.name = name;
		this.level = level;
		this.hp = hp;
	}
	
	public void showInfo() {
		System.out.println("이름 :" + name + ", 레벨:" + level + ", HP:" + hp);
	}
	
	public void attack() {
		System.out.println(name + " 공격을 시작했습니다.");
	}
	
}
