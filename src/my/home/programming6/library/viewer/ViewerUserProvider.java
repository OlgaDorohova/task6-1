package my.home.programming6.library.viewer;

public class ViewerUserProvider {
	private static final ViewerUserProvider instance = new ViewerUserProvider();

	private ViewerUserProvider() {
	}

	private final Viewer viewer = new UserViewer();

	public static ViewerUserProvider getInstance() {
		return instance;
	}

	public Viewer getViewer() {
		return viewer;
	}
}
