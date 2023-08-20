package my.home.programming6.library.main;

import my.home.programming6.library.main.menu.Menu;
/*Задание 1: создать консольное приложение “Учет книг в домашней библиотеке”.
Общие требования к заданию:
• Система учитывает книги как в электронном, так и в бумажном варианте.
• Существующие роли: пользователь, администратор.
• Пользователь может просматривать книги в каталоге книг, осуществлять поиск
книг в каталоге.
• Администратор может модифицировать каталог.
• *При добавлении описания книги в каталог оповещение о ней рассылается на
e-mail всем пользователям
• **При просмотре каталога желательно реализовать постраничный просмотр
• ***Пользователь может предложить добавить книгу в библиотеку, переслав её
администратору на e-mail.
• Каталог книг хранится в текстовом файле.
• Данные аутентификации пользователей хранятся в текстовом файле. Пароль
не хранится в открытом виде

*/
public class Main {

	public static void main(String[] args) {
/* user data / book data
		User admin =  new Admin("admin", "MamaManana2015", "admin@site.com");
		
		List<User> users = new ArrayList(
		Arrays.asList(
				new User("1", "11342", "as@we.ewr"),
				new User("2", "123", "as.ewr"),
				new User("3", "234", "as.ewr"), new User("4", "423", "as.ewr"), new User("5", "546", "as.ewr"),
				new User("6", "456435", "as.ewr")));
	
		List<Book> books = new ArrayList(Arrays.asList(new Book("Head First Java", "Kathy Sierra", 2003, Type.PAPER),
				new Book("Java: A Beginner’s Guide", "Herbert Schildt", 2018, Type.PAPER),
				new Book("Java For Dummies", " Barry A. Burd", 2015, Type.EBOOK),
				new Book("Effective Java 3rd Edition", "Joshua Bloch", 2003, Type.PAPER),
				new Book("Head First Design Patterns", "Eric Freeman", 2021, Type.PAPER),
				new Book("Peter Pan", "J.M. Barrie", 2014, Type.PAPER),
				new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 2014, Type.EBOOK),
				new Book("Head First Java", "Kathy Sierra", 2005, Type.EBOOK),
				new Book("Head First Java", "Kathy Sierra", 2003, Type.PAPER)));
*/
		Menu.startMenu();

	}

}
