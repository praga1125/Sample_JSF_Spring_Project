package com.example.student.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_authentication")
public class SD_Details {
	
	public SD_Details() {
		
	}
	
	@Id
	@Column(name="phone")
	private int phone;

	@Column(name="username")
	private String username;
	
	@Column(name="password")
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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	

}
