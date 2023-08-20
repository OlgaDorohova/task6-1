package my.home.programming6.library.controler.command;

import my.home.programming6.library.bean.entity.User;
import my.home.programming6.library.except.ServiceException;
import my.home.programming6.library.service.LogServ;
import my.home.programming6.library.service.LogServiceProvider;

public class LogUserCommand implements Command {

	@Override
	public String execute(String[] params) {
		LogServiceProvider provider = LogServiceProvider.getInstance();
		LogServ logServ = provider.getLogServ();

		String login = params[0].split("=")[1];
		String password = params[1].split("=")[1];

		try {
			User user;
			user = logServ.logIn(login, password);

			if (user == null) {
				return "1";
			}

			return "0" + ";" + user.isAdmin();
		} catch (ServiceException e) {
			return "3";
		}

	}

}
