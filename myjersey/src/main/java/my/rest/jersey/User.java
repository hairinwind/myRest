package my.rest.jersey;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.ToStringBuilder;

@XmlRootElement
public class User {
	private Long id;
	private String userName;
	private String userPasswd;
	private String email;

	public User(String userName, String userPasswd, String email) {
		this.userName = userName;
		this.userPasswd = userPasswd;
		this.email = email;
	}

	public User() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPasswd() {
		return userPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
