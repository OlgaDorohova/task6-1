package my.home.programming6.library.viewer;

public class ViewerBookProvider {
private static final ViewerBookProvider instance = new ViewerBookProvider();
private ViewerBookProvider() {}

private final BookViewer bookViewer = new BookViewer();

public static ViewerBookProvider getInstance() {
	return instance;
}

public BookViewer getBookViewer() {
	return bookViewer;
}
}
