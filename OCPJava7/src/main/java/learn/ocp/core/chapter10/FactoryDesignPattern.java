package learn.ocp.core.chapter10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactoryDesignPattern {

	public static void main(String[] args) {
		Factory f1=new FactoryImpl();
		BookDao b1=f1.getBookDao();
		List<Book> books=new ArrayList<Book>();
		for(int i=0;i<5;i++){
			Book b=new Book("Shinobi"+i,"Itachi"+i,i);
			b1.addBook(b);
			books.add(b);
		}
		b1.read("Praveen", 1);
		b1.read("Sasori", 4);
		
	}

}

class FactoryImpl extends Factory{
	@Override
	public BookDao getBookDao() {
		return new BookDaoImpl();
	}
	
}

interface BookDao{
	Book getBook(int id);
	void read(String name,int id);
	void addBook(Book b);
	void removeBook(Book b);
}
class BookDaoImpl implements BookDao{
	private Map<Integer, Book> books;
	
	public BookDaoImpl() {
		books=new HashMap<Integer, Book>();
	}
	
	@Override
	public Book getBook(int id) {
		return books.get(id);
	}
	@Override
	public void read(String name,int id) {
		System.out.println(name+" is reading the book "+books.get(id).getTitle());
	}

	@Override
	public void addBook(Book b) {
		books.put(b.getId(), b);
	}

	@Override
	public void removeBook(Book b){
		books.remove(b.getId());
	}
}

class Book{
	private String title;
	private String author;
	private int id;
	
	public Book() {
	}
	public Book(String t,String a,int i) {
		title=t;author=a;id=i;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}