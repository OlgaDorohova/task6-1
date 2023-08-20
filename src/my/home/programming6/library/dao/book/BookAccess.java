package my.home.programming6.library.dao.book;

import java.util.List;

import my.home.programming6.library.bean.entity.Book;
import my.home.programming6.library.except.DaoException;

public interface BookAccess {
	
public boolean saveBook(Book book) throws DaoException;
public boolean deleteBook(Book book) throws DaoException;
public List<Book> getBook(String criterion) throws DaoException;
public List<Book> getAll() throws DaoException;
	
}
