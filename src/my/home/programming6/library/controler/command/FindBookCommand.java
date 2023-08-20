package my.home.programming6.library.controler.command;

import java.util.Set;

import my.home.programming6.library.bean.entity.Book;
import my.home.programming6.library.service.UserServ;
import my.home.programming6.library.service.UserServiceProvider;

public class FindBookCommand implements Command {

	@Override
	public String execute(String[] params) {
		UserServiceProvider provider = UserServiceProvider.getInstance();
		UserServ userServ = provider.getUserServ();
		StringBuffer sBuffer = new StringBuffer();

		try {
			Set<Book> books = userServ.findBook(params[0]);

			if (books.isEmpty()) {
				return "1";
			}

			for (Book book : books) {
				sBuffer.append(book + "\n");
			}

			return "5" +";" + sBuffer;
		} catch (Exception e) {
			return "2";
		}

	}

}
