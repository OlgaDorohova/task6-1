package my.home.programming6.library.dao.book;

public final class BookAccessProvider {

	private static final BookAccessProvider instance = new BookAccessProvider();
	
	private BookAccessProvider() {}
	
	private final BookAccess bookAccess = new BookAccessImpl();
	
	public static BookAccessProvider getInstance() {
		return instance;
	}
	
	public BookAccess getBookAccess() {
		return bookAccess;
	}
	
}
