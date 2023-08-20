package my.home.programming6.library.controler;

import my.home.programming6.library.controler.command.CommandProvider;

public class ControllerImpl implements Controller {

	//request "command_name, login=login,password=password,email="
	@Override
	public String action(String request) {
		String commandName;
		String [] parameters = request.split("\\;s*");
		
		String result;
		
		commandName = parameters[0];
		CommandProvider provider = new CommandProvider();
		
		if(parameters.length <= 1) {
			 result = provider.getCommand(commandName).execute(parameters);

		} else {
					result = provider.getCommand(commandName).execute(parameters[1].split("\\s*,\\s*"));
		}
		
		
		
		return result;
	}

}
