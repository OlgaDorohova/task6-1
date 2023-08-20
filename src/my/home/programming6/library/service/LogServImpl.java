package my.home.programming6.library.service;

import my.home.programming6.library.bean.entity.User;
import my.home.programming6.library.dao.user.UserAccess;
import my.home.programming6.library.dao.user.UserAccessProvider;
import my.home.programming6.library.except.ServiceException;

public class LogServImpl implements LogServ {

	UserAccessProvider userProvider = UserAccessProvider.getInstance();
	UserAccess userAcc = userProvider.getUserAccess();

	@Override
	public User logIn(String loggin, String password) throws ServiceException {
		User user = null;

		try {
			user = userAcc.getUser(loggin, password);
			if(user != null) {
				user.setLogged(true);
			}
			

		} catch (Exception e) {
			throw new ServiceException(e);
		}

		return user;

	}

	@Override
	public User reg(String loggin, String password, String email) throws ServiceException {
		User user = null;

		try {
			user = userAcc.findUser(loggin) ;
			if(user == null) {
				user = new User(loggin, password, email);
				userAcc.saveUser(user);
				user.setLogged(true);

				
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		}

		return user;
	}

	@Override
	public User logOut(User user) {
		user.setLogged(false);
		return user;

	}

}
