package com.justinmechanye.cs.cswebservices.Models;




public class AuthResponseModel {
	private String JWT;
	private String role;
	private String username;
	
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
}
