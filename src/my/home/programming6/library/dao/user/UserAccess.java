package my.home.programming6.library.dao.user;

import java.util.List;

import my.home.programming6.library.bean.entity.User;
import my.home.programming6.library.except.DaoException;

public interface UserAccess {
public boolean saveUser(User user) throws DaoException;
public User getUser(String login, String password)throws DaoException;
public boolean deleteUser(User user)throws DaoException;
public User findUser(String login) throws DaoException;
public List<User> getAll() throws DaoException;

}
