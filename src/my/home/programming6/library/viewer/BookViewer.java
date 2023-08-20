package my.home.programming6.library.viewer;

public class BookViewer implements Viewer {

	@Override
	public String getResult(String request) {
		String result ; 
		
		switch (request.split(";")[0]) {
		case "0":
			result = "done";
			break;

		case "1":
			result = "book is not found";
			break;

		case "2":
			result = "error";
			break;
		
		case "3":
			result = "the book has been added";
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
