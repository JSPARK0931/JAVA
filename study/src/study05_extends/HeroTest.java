package study05_extends;

public class HeroTest {

	public static void main(String[] args) {
		IronMan ironLee = new IronMan("이순신", "슈트", 80, 90);
		ironLee.showHeroInfo();

		Hulk hulkHong = new Hulk("홍길동","펀치", 100, 150);
		hulkHong.showHeroInfo();
		
		Thor thorKim = new Thor("김토르", "번개", 120, 50);
		thorKim.showHeroInfo();
	}

}
