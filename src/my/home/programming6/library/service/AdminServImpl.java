package my.home.programming6.library.service;

import java.util.List;

import my.home.programming6.library.bean.entity.Book;
import my.home.programming6.library.bean.entity.User;
import my.home.programming6.library.dao.book.BookAccess;
import my.home.programming6.library.dao.book.BookAccessProvider;
import my.home.programming6.library.dao.user.UserAccess;
import my.home.programming6.library.dao.user.UserAccessImpl;
import my.home.programming6.library.dao.user.UserAccessProvider;
import my.home.programming6.library.except.ServiceException;

public class AdminServImpl implements AdminServ {

	@Override
	public boolean addBook(Book book) throws ServiceException {
		BookAccessProvider bookProvider = BookAccessProvider.getInstance();
		BookAccess bookAccess = bookProvider.getBookAccess();
		try {
		return	bookAccess.saveBook(book);

		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public boolean deleteBook(Book book) throws ServiceException {
		BookAccessProvider bookProvider = BookAccessProvider.getInstance();
		BookAccess bookAccess = bookProvider.getBookAccess();
		try {
			bookAccess.deleteBook(book);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return true;
	}

	@Override
	public boolean deleteUser(String login) throws ServiceException {
		UserAccessProvider userProvider = UserAccessProvider.getInstance();
		UserAccess userAccess = userProvider.getUserAccess();
		try {
			if (userAccess.findUser(login) == null) {
				return false;
			}
			if (!userAccess.findUser(login).isAdmin()) {
				return userAccess.deleteUser(userAccess.findUser(login));
			}
			return false;

		} catch (Exception e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public List<Book> getAllBooks() throws ServiceException {
		BookAccessProvider provider = BookAccessProvider.getInstance();
		BookAccess access = provider.getBookAccess();

		try {
			return access.getAll();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<User> getAllUsers() throws ServiceException {
		UserAccessProvider userProvider = UserAccessProvider.getInstance();
		UserAccess userAccess = userProvider.getUserAccess();

		try {
			return userAccess.getAll();
		} catch (Exception e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public boolean changeAdminParams(String paramName, String oldParam, String newParam) throws ServiceException {
		
		UserAccessImpl userAccess = new UserAccessImpl();

		
		try {
			for(User user: userAccess.getAll()) {
				if(user.isAdmin()) {
					String info = user.toString();
					int index = info.indexOf(oldParam);
							String newAdminParamString = info.substring(0,index) + newParam
									+ info.substring(index+oldParam.length());

								userAccess.deleteUser(user);
								userAccess.saveUser(userAccess.parseUserString(newAdminParamString));
								return true;
						
					}
					
				}
				
			return false;	
			
			
		} catch (Exception e) {
		throw new ServiceException(e);
		}
		
	}

}
