package com.project.feedbacksystem.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// entity class for the spring security
@Entity
@Table(name= "feedback_user")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
	private long id;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String passwordHash;
	
	@Column(name = "role", nullable = false)
	private String role;
	
	@Column(name = "user_firstname", nullable = false)
	private String user_firstname;
	
	@Column(name = "user_lastname", nullable = false)
	private String user_lastname;
	
	@Column(name = "department", nullable = false)
	private String department;
	
	public User() {
		super();
	}

	public User(long id, String username, String passwordHash, String role, String user_firstname, String user_lastname,
			String department) {
		super();
		this.id = id;
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
		this.user_firstname = user_firstname;
		this.user_lastname = user_lastname;
		this.department = department;
	}

	public User(String username, String passwordHash, String role, String user_firstname, String user_lastname,
			String department) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
		this.user_firstname = user_firstname;
		this.user_lastname = user_lastname;
		this.department = department;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUser_firstname() {
		return user_firstname;
	}

	public void setUser_firstname(String user_firstname) {
		this.user_firstname = user_firstname;
	}

	public String getUser_lastname() {
		return user_lastname;
	}

	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwordHash=" + passwordHash + ", role=" + role
				+ ", user_firstname=" + user_firstname + ", user_lastname=" + user_lastname + ", department="
				+ department + "]";
	}

}
