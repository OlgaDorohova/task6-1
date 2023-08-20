package my.home.programming6.library.viewer;

public class UserViewer implements Viewer {

	@Override
	public String getResult(String request) {
		String result;

		switch (request.split(";")[0]) {
		case "0":
			result = "done";
			break;

		case "1":
			result = "wrong login or password";
			break;

		case "2":
			result = "this login already exists";
			break;

		case "3":
			result = "error";
			break;
			
		case "4":
			result = "user is not found";
			break;
		
		case "5":
			result = request.split(";")[1];
			break;
		
		default:
			result = "unknown answer" ;
			break;
		}

		return result;
	}

}
