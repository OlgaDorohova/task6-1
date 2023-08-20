package my.home.programming6.library.except;

public class ServiceException extends Exception{

	private static final long serialVersionUID = 4978039381053751417L;

public ServiceException() {
	super();
}
public ServiceException(String message) {
	super(message);
}

public ServiceException(Exception cause) {
	super(cause);
}

public ServiceException(String message, Exception cause) {
	super(message, cause);
}
}