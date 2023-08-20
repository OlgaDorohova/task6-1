package my.home.programming6.library.controler.command;

import my.home.programming6.library.bean.entity.Book;
import my.home.programming6.library.bean.entity.Type;
import my.home.programming6.library.dao.book.BookAccess;
import my.home.programming6.library.dao.book.BookAccessProvider;

public class DeleteBookCommand implements Command {

	@Override
	public String execute(String[] params) {
		BookAccessProvider provider = BookAccessProvider.getInstance();
		BookAccess bookAccess = provider.getBookAccess();

		String title = params[0].split("=")[1];
		String author = params[1].split("=")[1];
		int year = Integer.parseInt(params[2].split("=")[1]);
		Type type = Type.parseType(params[3].split("=")[1]);

		try {
			boolean isDone = bookAccess.deleteBook(new Book(title, author, year, type));

			return (isDone) ? "0" : "1";

		} catch (Exception e) {
			return "2";
		}

	}

}
