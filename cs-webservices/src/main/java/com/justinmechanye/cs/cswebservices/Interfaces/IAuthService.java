package com.justinmechanye.cs.cswebservices.Interfaces;

import org.springframework.http.ResponseEntity;

import com.justinmechanye.cs.cswebservices.Models.AuthResponseModel;

public interface IAuthService {
	// TODO change return type to JWT token;
	public ResponseEntity<AuthResponseModel> login(String userName, String password);
	
	// TODO input should be jwt token.
	public void Authorize(String token);
}
