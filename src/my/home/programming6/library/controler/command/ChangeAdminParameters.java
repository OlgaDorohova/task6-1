package my.home.programming6.library.controler.command;

import my.home.programming6.library.except.ServiceException;
import my.home.programming6.library.service.AdminServ;
import my.home.programming6.library.service.AdminServProvider;

public class ChangeAdminParameters implements Command {

	@Override
	public String execute(String[] params) {

		AdminServProvider provider = AdminServProvider.getInstance();
		AdminServ adminServ = provider.getAdminService();

		String paramName = params[0].split("=")[1];
		String oldParam = params[1].split("=")[1];
		String newParam = params[2].split("=")[1];

		try {
			boolean isDone;
			isDone = adminServ.changeAdminParams(paramName, oldParam, newParam);

			return (isDone) ? "0" : "2";

		} catch (ServiceException e) {
			return "3";
		}
	}

}
