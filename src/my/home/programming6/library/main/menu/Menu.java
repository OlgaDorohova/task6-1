package my.home.programming6.library.main.menu;

import java.util.Scanner;

import my.home.programming6.library.controler.Controller;
import my.home.programming6.library.controler.ControllerProvider;
import my.home.programming6.library.viewer.Viewer;
import my.home.programming6.library.viewer.ViewerBookProvider;
import my.home.programming6.library.viewer.ViewerUserProvider;

public class Menu {

	
	public static void startMenu() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String input = "";
		String result = "";
		Boolean isAdmin = false, isLogged = false;

		ControllerProvider providerController = ControllerProvider.getInstance();
		Controller controller = providerController.getController();
		
		ViewerUserProvider providerUser = ViewerUserProvider.getInstance();
		Viewer viewUser = providerUser.getViewer();

		ViewerBookProvider providerBook = ViewerBookProvider.getInstance();
		Viewer viewBook = providerBook.getBookViewer();

		while (!input.equalsIgnoreCase("q")) {
			System.out.println("press\n" + "1 - sign up\n" + "2 - log in\n" + "q - finish\n>>");
			input = scanner.nextLine();

			switch (input) {
			case "1": {

				result = controller.action(userInputConvert("registr"));
				System.out.println(viewUser.getResult(result));

				if (result.split(";")[0].equals("0")) {
					isAdmin = Boolean.parseBoolean(result.split(";")[1]);
					isLogged = true;
				}

			}

			case "2": {
				if (!isLogged) {
					result = controller.action(userInputConvertShort("logIn"));
					System.out.println(viewUser.getResult(result));
					if (result.split(";")[0].equals("0")) {
						isAdmin = Boolean.parseBoolean(result.split(";")[1]);
						isLogged = true;
					}

				}

				if (isLogged) {

					if (isAdmin) {
						while (!input.equalsIgnoreCase("q")) {
							System.out.println("press\n" + "1 - find book\n" + "2 - add book\n" + "3 - delete book\n"
									+ "4 - get all books\n" + "5 - delete user\n" + "6 - get all users\n"
									+"7 - change admin parameter\n"
									+ "8 - log out\n");

							input = scanner.nextLine();

							switch (input) {
							case "1": {
								result = controller.action(bookInputConvert("findBook"));
								System.out.println(viewBook.getResult(result));
								break;
							}

							case "2": {
								result = controller.action(bookInputConvert("addBook"));
								System.out.println(viewBook.getResult(result));
								break;
							}

							case "3": {
								result = controller.action(bookInputConvert("deleteBook"));
								System.out.println(viewBook.getResult(result));
								break;
							}

							case "4": {
								result = controller.action("getAllBooks");
								System.out.println(viewBook.getResult(result));
							}

							case "5": {
								result = controller.action("deleteUser");
								System.out.println(viewUser.getResult(result));
								break;
							}

							case "6": {
								result = controller.action("getAllUsers");
								System.out.println(viewUser.getResult(result));
								break;
							}
							
							case "7": {
								result = controller.action(adminChange("changeAdminParams"));
								System.out.println(viewUser.getResult(result));
								break;
							}
							
							case "8": {
								isLogged = false;
								System.out.println("done");
								break;
							}

							default:
								System.out.println("wrong choise");
								break;
							}
						}
					} else {
						while (!input.equalsIgnoreCase("q") && isLogged) {
							System.out.println("press\n" + "1 - find book\n" + "2 - offer book\n" + "3 - log out\n");

							input = scanner.nextLine();
							switch (input) {
							case "1": {
								result = controller.action(bookInputConvert("findBook"));
								System.out.println(viewBook.getResult(result));
								break;
							}

							case "2": {
								result = controller.action(bookInputConvert("offerBook"));
								System.out.println(viewBook.getResult(result));
								break;
							}

							case "3": {
								isLogged = false;
								break;
							}
							}
						}
					}
				}

				break;

			}
			default:
				System.out.println("wrong choise");
				break;
			}

		}

	}

	private static String userInputConvert(String commandName) {
		String request = commandName;
		String temp;
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("enter login\n>>");
		temp = scanner.nextLine();
		request += ";" + "login=" + temp;

		System.out.println("enter password\n>>");
		temp = scanner.nextLine();
		request += "," + "password=" + temp;

		do {
			System.out.println("enter your email\n>>");
			temp = scanner.nextLine();

		} while (temp.split("@").length != 2);
		request += "," + "email=" + temp;

		return request;
	}

	private static String userInputConvertShort(String commandName) {
		String request = commandName;
		String temp;
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("enter login\n>>");
		temp = scanner.nextLine();
		request += ";" + "login=" + temp;

		System.out.println("enter password\n>>");
		temp = scanner.nextLine();
		request += "," + "password=" + temp;

		return request;
	}

	private static String adminChange(String commandName) {
		String request = commandName;
		String temp;
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("what parameter do you ewant to change\n>>");
		temp = scanner.nextLine();
		request += ";parameter=" + temp;

		System.out.println("old value\n>>");
		temp = scanner.nextLine();
		request += ",oldValue=" + temp;

		System.out.println("new value\n>>");
		temp = scanner.nextLine();
		request += ",newValue="  + temp;

		return request;
	}

	private static String bookInputConvert(String commandName) {
		String request = commandName;
		String temp;

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("enter title\n>>");
		temp = scanner.nextLine();
		request += ";" + "title=" + temp;

		System.out.println("enter author\n>>");
		temp = scanner.nextLine();
		request += "," + "author=" + temp;

		System.out.println("enter year\n>>");
		temp = scanner.nextLine();
		request += "," + "year=" + temp;

		System.out.println("enter type (eBook or paper)\n>>");
		temp = scanner.nextLine();
		request += "," + "type=" + temp;

		return request;
	}

}
