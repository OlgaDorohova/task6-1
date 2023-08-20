package my.home.programming6.library.except;

public class DaoException extends Exception{

	private static final long serialVersionUID = -5266442738835670627L;

public DaoException() {
	super();
}
public DaoException(String message) {
	super(message);
}

public DaoException(String message, Exception cause) {
	super(message, cause);
}
}
