package my.home.programming6.library.service;


import my.home.programming6.library.bean.entity.User;
import my.home.programming6.library.except.ServiceException;

public interface LogServ {

	public User logIn(String loggin, String password) throws ServiceException;

	public User reg(String loggin, String password, String email) throws ServiceException;

	public User logOut(User user);

}
