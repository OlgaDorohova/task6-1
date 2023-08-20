package my.home.programming6.library.controler.command;

import my.home.programming6.library.bean.entity.User;
import my.home.programming6.library.except.ServiceException;
import my.home.programming6.library.service.LogServ;
import my.home.programming6.library.service.LogServiceProvider;


public class RegUserCommand implements Command{
	@Override
	public String execute(String [] params){
		LogServiceProvider provider = LogServiceProvider.getInstance();
		LogServ logServ = provider.getLogServ();
		
		String login = params[0].split("=")[1];
		String password = params[1].split("=")[1];
		String email = params[2].split("=")[1]; 
		
		try { 
			User user;
			user = logServ.reg(login, password, email);
			if(user==null) {
				return "2";
			}
			user.setLogged(true);
			user.isAdmin();
			return "0" +";" + user;
		} catch (ServiceException e) {
//			e.printStackTrace();
			return "3";
		}
		
		
	}
}
