package my.home.programming6.library.controler.command;

import my.home.programming6.library.except.ServiceException;
import my.home.programming6.library.service.AdminServ;
import my.home.programming6.library.service.AdminServProvider;

public class DeleteUserCommand implements Command {

	@Override
	public String execute(String[] params) {
		AdminServProvider provider = AdminServProvider.getInstance();
		AdminServ adminServ = provider.getAdminService();

		String login = params[0].split("=")[1];

		try {

			boolean isDone = adminServ.deleteUser(login);

			return (isDone) ? "0" : "4";

		} catch (ServiceException e) {
			return "3";
		}

	}

}
