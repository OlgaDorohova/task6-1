package my.home.programming6.library.controler;

//request format 
//"command_name,login=login,password=password"
//"command_name,title= title,author=author,year=year,type=type"

public interface Controller {
	public String action(String request);
}
