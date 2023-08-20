package my.home.programming6.library.dao.user;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import my.home.programming6.library.bean.entity.Admin;
import my.home.programming6.library.bean.entity.User;
import my.home.programming6.library.except.DaoException;

public class UserAccessImpl implements UserAccess {

	private String pathString = "libraryData//users.txt";

	private List<String> userStrings;

	@Override
	public boolean saveUser(User user) throws DaoException {

		try {
			userStrings = Files.readAllLines(Paths.get(pathString));

			if (!userStrings.isEmpty()) {

				for (String s : userStrings) {
					if (s.contains("login=:=" + user.getLogin())) {
						return false;
					}
				}
			}
			Files.writeString(Paths.get(pathString), userInfo(user) + "\n", StandardOpenOption.APPEND);
		} catch (Exception e) {
			throw new DaoException(pathString, e);
		}
		return true;
	}

	@Override
	public boolean deleteUser(User user) throws DaoException {
		try {
			userStrings = Files.readAllLines(Paths.get(pathString));

			if (userStrings.isEmpty() || !userStrings.contains(userInfo(user))) {
				return false;
			}

			Files.writeString(Paths.get(pathString), "", StandardOpenOption.TRUNCATE_EXISTING);

			for (String s : userStrings) {
				if (s.equals(userInfo(user)) || s.isBlank()) {
					continue;
				}
				Files.writeString(Paths.get(pathString), s + "\n", StandardOpenOption.APPEND);

			}
		} catch (Exception e) {
			throw new DaoException(pathString, e);
		}
		return true;

	}

	@Override
	public User getUser(String login, String password) throws DaoException {
		try {
			userStrings = Files.readAllLines(Paths.get(pathString));

			for (String s : userStrings) {
				if (s.contains("login=:=" + login)) {
					User user = parseUserString(s);
					if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
						return user;
					}

				}
			}
		} catch (Exception e) {
			throw new DaoException(pathString, e);
		}
		return null;
	}

	public User parseUserString(String str) {

		String[] temp = str.split(",");
		String loginString = "";
		String passwordString = "";
		String emailString = "";
		for (String s : temp) {
			String[] temp2;
			if (s.contains("=:=")) {
				temp2 = s.split("=:=");
			} else {
				temp2 = s.split("=");
			}

			if (temp2[0].contains("login")) {
				loginString = temp2[1];
			}
			if (temp2[0].contains("password")) {
				passwordString = decode(temp2[1], loginString);
			}
			if (temp2[0].contains("email")) {
				emailString = temp2[1];
			}

			if (temp2[0].contains("isAdmin") && temp2[1].contains("true")) {
				return new Admin(loginString, passwordString, emailString);
			}

		}
		return new User(loginString, passwordString, emailString);
	}

	private String encode(User user) {
		byte[] bytes = user.getPassword().getBytes();
		byte[] result = new byte[bytes.length];
		int key = user.getLogin().length();
		for (int i = 0; i < bytes.length; i++) {
			result[i] = (byte) (bytes[i] ^ key);
		}
		return new String(result);
	}

	private String decode(String password, String keyString) {
		byte[] bytes = password.getBytes();
		byte[] result = new byte[bytes.length];
		int key = keyString.length();
		for (int i = 0; i < bytes.length; i++) {
			result[i] = (byte) (bytes[i] ^ key);
		}
		return new String(result);
	}

	public String userInfo(User user) {
		return "login=:=" + user.getLogin() + ",password=:=" + encode(user) + ",email=:=" + user.getEmail()
				+ ",isAdmin=:=" + user.isAdmin();
	}

	@Override
	public User findUser(String login) throws DaoException {
		try {
			userStrings = Files.readAllLines(Paths.get(pathString));

			for (String s : userStrings) {
				if (s.contains("login=:=" + login)) {
					return parseUserString(s);
				}

			}

		} catch (Exception e) {
			throw new DaoException(pathString, e);
		}
		return null;
	}

	public String getAdminEmail() throws IOException {
		try {
			userStrings = Files.readAllLines(Paths.get(pathString));

			for (String s : userStrings) {
				if (s.contains("isAdmin=:=true")) {

					return parseUserString(s).getEmail();
				}

			}

		} catch (Exception e) {
			throw new FileNotFoundException(pathString);
		}
		return null;
	}

	@Override
	public List<User> getAll() throws DaoException {
		List<User> userList = new ArrayList<>();
		try {
			userStrings = Files.readAllLines(Paths.get(pathString));

			for (String s : userStrings) {
				userList.add(parseUserString(s));
			}
		} catch (Exception e) {
			throw new DaoException(pathString, e);
		}
		return userList;

	}

}
