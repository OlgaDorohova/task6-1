package my.home.programming6.library.service;

public class AdminServProvider {
private static final AdminServProvider instance = new AdminServProvider();
private AdminServProvider() {}
private final AdminServ adminServ = new AdminServImpl();

public static AdminServProvider getInstance() {
	return instance;
}

public AdminServ  getAdminService(){
	return adminServ;
}
}
