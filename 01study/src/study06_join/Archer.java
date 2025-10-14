package study06_join;

public class Archer extends GameCharacter{

	String bowType;

	public Archer(String name, int level, int hp, String bowType) {
		super(name, level, hp);
		this.bowType = bowType;
	}
	
	public void hide() {
		System.out.println(name + "님이 은신활공격을 시작합니다.");
	}

	@Override
	public void attack() {
		//super.attack();
		System.out.println(name +"님이" + bowType +"공격을 시작합니다.");
	}
	
	
	
}
