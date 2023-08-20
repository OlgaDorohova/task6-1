package my.home.programming6.library.controler.command;

import java.util.List;
import my.home.programming6.library.bean.entity.Book;
import my.home.programming6.library.service.AdminServ;
import my.home.programming6.library.service.AdminServProvider;


public class GetAllBooksCommand implements Command {

	@Override
	public String execute(String[] params) {
		AdminServProvider provider = AdminServProvider.getInstance();
		AdminServ servImpl = provider.getAdminService();
		
		StringBuffer sBuffer = new StringBuffer(); 
		try {
			List<Book> books = servImpl.getAllBooks();
			if(books.isEmpty()) {
				return "2";
			}
			for(Book book: books) {
				sBuffer.append(book.toString()+"\n");
				
			}
			return "5" + ";" +sBuffer;
			
		}catch (Exception e) {
			return "2";
		}
		
	}

}
