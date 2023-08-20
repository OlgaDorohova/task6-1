package my.home.programming6.library.service;

import my.home.programming6.library.bean.entity.Book;

import my.home.programming6.library.dao.user.UserAccessImpl;
import my.home.programming6.library.except.ServiceException;

public class UserServImpl implements UserServ {

	@Override
	public boolean offerBook(Book book) throws ServiceException {
		try {
			String email = new UserAccessImpl().getAdminEmail();
		if (!email.isBlank()) {
			return true;
		} else {
			return false;
		}
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}
	
	

}
