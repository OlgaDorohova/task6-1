package my.home.programming6.library.bean.entity;

import java.util.Objects;

public final class Admin extends User {

	private static final long serialVersionUID = -3923343438114269137L;
	private boolean isAdmin = true;

	public Admin(String login, String password, String email) {
		super(login, password, email);

	}

	@Override
	public boolean isAdmin() {
		return this.isAdmin;
	}

	@Override
	public String getEmail() {
		return super.getEmail();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(isAdmin);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return isAdmin == other.isAdmin;
	}

	@Override
	public String toString() {
		return "Admin [login=" + this.getLogin() + ", password=" + this.getPassword() + ", email=" + this.getEmail()
				+ ", isLogged=" + this.isLogged() + ", isAdmin=" + this.isAdmin() + "]";
	}

}
