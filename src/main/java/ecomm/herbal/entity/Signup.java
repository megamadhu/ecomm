package ecomm.herbal.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "signup")
public class Signup {

	@Id
	@Embedded
	private SignupKey signupKey;

	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;

	public SignupKey getSignupKey() {
		return signupKey;
	}

	public void setSignupKey(SignupKey signupKey) {
		this.signupKey = signupKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Signup() {
	}

	public Signup(SignupKey signupKey, String name, String email) {
		super();
		this.signupKey = signupKey;
		this.name = name;
		this.email = email;
	}

}
