package com.milinddev.expensetrackerapi.entity;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserModal {
	
	@NotNull(message="User name should not be empty")
	private String name;
	@Email(message="email is not proper format")
	private String email;
	@NotNull(message="password is not empty")
	@Size(min=3,message="password range more than 3")
	private String password;

	private Long age = 0L;

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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	
	
}
