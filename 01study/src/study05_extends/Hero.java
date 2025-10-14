package study05_extends;

//import java.util.Arrays; // 배열데이터출력

public class Hero {
	String name;
	String power;
	int attack;
	int defense;
	String rank; //위의 값으로 rank 조정 메쏘드
	
	public Hero(String name, String power, int attack, int defense) {
		super();
		this.name = name;
		this.power = power;
		this.attack = attack;
		this.defense = defense;
		this.rank = calculateRank();
	}
	

	public String calculateRank() {
		// S, A B, C 등 등급 return
		int score = attack + defense ;
		
		if (score >= 180) {
			return "S";
		}
		else if (score >= 140 ){
			return "A";
		}
		else if (score >= 100 ){
			return "B";
		}
		else {
			return "C";
		}
		
	}
	
	public void showHeroInfo() {
		System.out.println("------------------------------");
		System.out.println("히어로이름  :" + name);
		System.out.println("히어로파워  :" + power);
		System.out.println("히어로공격력 :" + attack);
		System.out.println("히어로방어력 :" + defense);
		System.out.println("히어로등급 :" + rank);
		
//		if(skills.length > 0) {
//			//System.out.println("보유기술  : " + Arrays.toString(skills));
//			System.out.println("보유기술  : " + Arrays.toString(skills));
//		}
//		else {
//			System.out.println("보유기술  : 없음");
//		}
		System.out.println("------------------------------");
	}
	
	
	
	
}
