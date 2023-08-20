package my.home.programming6.library.service;

public final class LogServiceProvider {
private static final LogServiceProvider instance = new LogServiceProvider();
	
	private LogServiceProvider() {}
	
	private final LogServ logServ = new LogServImpl();
	
	public static LogServiceProvider getInstance() {
		return instance;
	}
	
	public LogServ getLogServ() {
		return logServ;
	}
	
}
