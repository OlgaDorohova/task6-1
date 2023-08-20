package my.home.programming6.library.controler.command;

import my.home.programming6.library.bean.entity.Book;
import my.home.programming6.library.bean.entity.Type;
import my.home.programming6.library.service.UserServ;
import my.home.programming6.library.service.UserServiceProvider;

public class OfferBookCommand implements Command {

	@Override
	public String execute(String[] params) {
		UserServiceProvider provider = UserServiceProvider.getInstance();
		UserServ userServ = provider.getUserServ();

		String title = params[0].split("=")[1];
		String author = params[1].split("=")[1];
		int year = Integer.parseInt(params[2].split("=")[1]);
		Type type = Type.parseType(params[3].split("=")[1]);

		try {

			boolean isDone = userServ.offerBook(new Book(title, author, year, type));

			return (isDone) ? "0" : "2";

		} catch (Exception e) {
			return "2";
		}

	}

}
