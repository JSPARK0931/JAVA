package study08_abstract;

public class ComputerTest {

	public static void main(String[] args) {
		
		Computer mycom1 = new DeskTop();
		
		Computer mycom2 = new Notebook();
		
		
		mycom1.display();
		
	//	mycom1.fn_test();
		mycom2.display();
		
	//	NoteBook name = new NoteBook();
		
		//부모는 메쏘드이름만 선언, 자식은 메쏘드를 구현
	//	mycom.display();s
		

	}

}
