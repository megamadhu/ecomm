package ecomm.herbal.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.lang.NonNull;

@Embeddable
public class SignupKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NonNull
	@Column(name = "username")
	private String username;
	@NonNull
	@Column(name = "password")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
