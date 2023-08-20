package my.home.programming6.library.dao.book;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import my.home.programming6.library.bean.entity.Book;
import my.home.programming6.library.bean.entity.Type;
import my.home.programming6.library.except.DaoException;

public class BookAccessImpl implements BookAccess {

	private String path = "libraryData//books.txt";
	private List<String> books;

	@Override
	public boolean saveBook(Book book) throws DaoException {
		try {
			books = Files.readAllLines(Paths.get(path));
			if (!books.isEmpty() && books.contains(bookInfo(book))) {
				return false;
			}

			Files.writeString(Paths.get(path), bookInfo(book) + "\n", StandardOpenOption.APPEND);

		} catch (Exception e) {
			throw new DaoException(path, e);
		}

		return true;
	}

	@Override
	public boolean deleteBook(Book book) throws DaoException {
		try {
			books = Files.readAllLines(Paths.get(path));
			if (books.isEmpty() || !books.contains(bookInfo(book))) {
				return false;
			}
			Files.writeString(Paths.get(path), "", StandardOpenOption.TRUNCATE_EXISTING);
			for (String s : books) {
				if (s.equals(bookInfo(book))) {
					continue;
				}
				Files.writeString(Paths.get(path), s + "\n", StandardOpenOption.APPEND);
			}
		} catch (Exception e) {
			throw new DaoException(path,e);
		}
		return true;
	}

	@Override
	public List<Book> getBook(String criterion) throws DaoException {
		List<Book> booksList = new ArrayList<>();
		try {
			books = Files.readAllLines(Paths.get(path));
			for(String s: books) {
			if (s.toLowerCase().contains(criterion.toLowerCase())) {
				booksList.add(parseBook(s));
			}
			}
		} catch (Exception e) {
			throw new DaoException(path,e);
		}
		
		return booksList;
	}

	public Book parseBook(String bookInfoStr) {
		String[] temp = bookInfoStr.split(",");
		String title = "";
		String author = "";
		int year = 0;
		Type type = null;

		for (String s : temp) {
			String[] temp2 = s.split("=");
			if (temp2[0].equals("title")) {
				title = temp2[1];
			}

			if (temp2[0].equals("author")) {
				author = temp2[1];
			}

			if (temp2[0].equals("year")) {
				year = Integer.parseInt(temp2[1]);
			}

			if (temp2[0].equals("type")) {
				type = Type.parseType(temp2[1]);

			}
		}

		return new Book(title, author, year, type);
	}

	public String bookInfo(Book book) {
		return "title=" + book.getTitle() + ",author=" + book.getAuthor() + ",year=" + book.getYear() + ",type="
				+ book.getType().getTypeName();
	}

	@Override
	public List<Book> getAll() throws DaoException {
		List<Book> booksList = new ArrayList<>();
		try {
			books = Files.readAllLines(Paths.get(path));
			for(String s: books) {
			booksList.add(parseBook(s));
			}
		} catch (Exception e) {
			throw new DaoException(path,e);
		}
		
		return booksList;
		
	}

}
