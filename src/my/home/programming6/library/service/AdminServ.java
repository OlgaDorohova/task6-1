package my.home.programming6.library.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import my.home.programming6.library.bean.entity.Book;
import my.home.programming6.library.bean.entity.User;
import my.home.programming6.library.dao.book.BookAccess;
import my.home.programming6.library.dao.book.BookAccessProvider;
import my.home.programming6.library.except.ServiceException;

public interface AdminServ {

	public boolean addBook(Book book) throws ServiceException;

	public boolean deleteBook(Book book) throws ServiceException;

	public List<Book> getAllBooks() throws ServiceException;

	public List<User> getAllUsers() throws ServiceException;

	public default Set<Book> findBook(String s) throws ServiceException {
		BookAccessProvider provider = BookAccessProvider.getInstance();
		BookAccess bookAccess = provider.getBookAccess();
		Set<Book> booksList = new HashSet<Book>();
		try {
			if (s.contains(" ")) {
				String[] nameList = s.split(" ");

				for (String string : nameList) {
					booksList.addAll(bookAccess.getBook(string));
				}
			} else
				booksList.addAll(bookAccess.getBook(s));
		} catch (Exception e) {
			throw new ServiceException(e);
		}

		return booksList;
	}

	public boolean deleteUser(String login) throws ServiceException;

	public boolean changeAdminParams(String paramName, String oldParam, String newParam) throws ServiceException;
}