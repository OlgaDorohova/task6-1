package my.home.programming6.library.dao.user;

public final class UserAccessProvider {

	private static final UserAccessProvider instance = new UserAccessProvider();
	
	private UserAccessProvider(){}
	
	public static UserAccessProvider getInstance() {
		return instance;
	}
	
	private final UserAccess userAccess = new UserAccessImpl();
	
	public UserAccess getUserAccess() {
		return userAccess;
	}
}
