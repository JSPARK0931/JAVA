package study03;

public class Book {
	private String bookName; //은닉화
	private String author;	 //은닉화
	
			
	public Book(String bookName, String author) {
		super();
		this.bookName = bookName;
		this.author = author;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return author;
	}

	public String getAuthor() {
		return author;
	}

	//source -generate getter & setter
	public void setAuthor(String author) {
		this.author = author;
	}

	
}
