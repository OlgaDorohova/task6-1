package my.home.programming6.library.controler.command;

import java.util.List;

import my.home.programming6.library.bean.entity.User;
import my.home.programming6.library.service.AdminServ;
import my.home.programming6.library.service.AdminServProvider;

public class GetAllUsersCommand implements Command {

	@Override
	public String execute(String[] params) {
		AdminServProvider provider = AdminServProvider.getInstance();
		AdminServ servImpl = provider.getAdminService();
		
		StringBuffer sBuffer = new StringBuffer(); 
		try {
			List<User> users = servImpl.getAllUsers();
			if(users.isEmpty()) {
				return "2";
			}
			for(User user:users) {
				sBuffer.append(user + "\n");
			}
			return "5" + ";" +sBuffer;
			
		}catch (Exception e) {
			return "2";
		}
	}

}
