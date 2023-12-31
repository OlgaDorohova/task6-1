package my.home.programming6.library.bean.entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable{

	private static final long serialVersionUID = 7034757580198836703L;
	
private String login;
private String password;
private String email;

protected boolean isAdmin = false;
private boolean isLogged;

public User() {
	isLogged = false;
}

public User(String login, String password, String email) {
	super();
	
	this.login = login;
	this.password = password;
	this.email = email;
}

public String getLogin() {
	return login;
}

public void setLogin(String login) {
	this.login = login;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public boolean isLogged() {
	return isLogged;
}

public void setLogged(boolean isLogged) {
	this.isLogged = isLogged;
}

public boolean isAdmin() {
	return isAdmin;
}



@Override
public int hashCode() {
	return Objects.hash(email, isAdmin, isLogged, login, password);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return Objects.equals(email, other.email) && isAdmin == other.isAdmin && isLogged == other.isLogged
			&& Objects.equals(login, other.login) && Objects.equals(password, other.password);
}

@Override
public String toString() {
	return "User [login=" + login + ", password=" + password + ", email=" + email + ", isAdmin=" + isAdmin
			+ ", isLogged=" + isLogged + "]";
}


}
