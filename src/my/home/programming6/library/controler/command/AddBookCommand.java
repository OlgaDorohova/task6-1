package my.home.programming6.library.controler.command;

import my.home.programming6.library.bean.entity.Book;
import my.home.programming6.library.bean.entity.Type;
import my.home.programming6.library.service.AdminServ;
import my.home.programming6.library.service.AdminServProvider;

public class AddBookCommand implements Command {

//	params format
//	"command_name,title= title,author=author,year=year,type=type"

	@Override
	public String execute(String[] params) {
		AdminServProvider provider = AdminServProvider.getInstance();
		AdminServ servImpl = provider.getAdminService();

		String title = params[0].split("=")[1];
		String author = params[1].split("=")[1];
		int year = Integer.parseInt(params[2].split("=")[1]);
		Type type = Type.parseType(params[3].split("=")[1]);

		try {
			boolean isDone = servImpl.addBook(new Book(title, author, year, type));

			return (isDone) ? "0" : "3";

		} catch (Exception e) {
			return "2";
		}

	}

}
