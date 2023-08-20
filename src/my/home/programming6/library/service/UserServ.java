package my.home.programming6.library.service;

import java.util.HashSet;
import java.util.Set;

import my.home.programming6.library.bean.entity.Book;
import my.home.programming6.library.dao.book.BookAccess;
import my.home.programming6.library.dao.book.BookAccessProvider;
import my.home.programming6.library.except.ServiceException;

public interface UserServ {

	public boolean offerBook(Book book) throws ServiceException;

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

}
