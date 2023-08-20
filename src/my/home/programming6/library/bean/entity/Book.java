package my.home.programming6.library.bean.entity;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {

	private static final long serialVersionUID = 1329184031490892637L;

	private String title;
	private String author;
	private int year;
	private Type type;

	public Book() {
		super();

	}

	public Book(String title, String author, int year, Type type) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.type = type;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getYear() {
		return year;
	}

	public Type getType() {
		return type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, title, type, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(title, other.title) && type == other.type
				&& year == other.year;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + year + ", type=" + type + "]";
	}
	
	

}
