package com.wjc.jcapp.data;

/**
 * ClassName: com.wjc.jcapp.data
 * Description:
 * JcChen on 2020.06.21.6:52 PM
 */
public class User {
	private String name;
	private String password;

	public User() {
	}

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
