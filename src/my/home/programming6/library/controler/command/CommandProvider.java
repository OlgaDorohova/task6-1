package my.home.programming6.library.controler.command;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
	private Map<String, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put("logIn", new LogUserCommand());
		commands.put("registr", new RegUserCommand());

		commands.put("deleteUser", new DeleteUserCommand());
		commands.put("getAllUsers", new GetAllUsersCommand());

		commands.put("getAllBooks", new GetAllBooksCommand());
		commands.put("addBook", new AddBookCommand());
		commands.put("deleteBook", new DeleteBookCommand());
		commands.put("changeAdminParams", new ChangeAdminParameters());
		
		commands.put("offerBook", new OfferBookCommand());
		commands.put("findBook", new FindBookCommand());
	}

	public Command getCommand(String commName) {
		return commands.get(commName);
	}
}
