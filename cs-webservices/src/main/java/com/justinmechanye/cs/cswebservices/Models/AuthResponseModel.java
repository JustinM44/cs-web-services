package com.justinmechanye.cs.cswebservices.Models;




public class AuthResponseModel {
	private String JWT;
	private String role;
	private String username;
	private Integer userId;
	
	public String getJWT() {
		return JWT;
	}
	public void setJWT(String jWT) {
		JWT = jWT;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
