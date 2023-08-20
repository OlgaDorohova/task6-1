package my.home.programming6.library.service;

public class UserServiceProvider {
private static final UserServiceProvider instance = new UserServiceProvider();

private UserServiceProvider() {}

private final UserServ userServ = new UserServImpl();

public static UserServiceProvider getInstance() {
	return instance;
}

public UserServ getUserServ() {
	return userServ;
}
}
