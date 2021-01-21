package com.justinmechanye.cs.cswebservices.Interfaces;

import org.springframework.http.ResponseEntity;

import com.justinmechanye.cs.cswebservices.Models.AuthResponseModel;
import com.justinmechanye.cs.cswebservices.Models.LoginModel;

public interface IAuthService {
	// TODO change return type to JWT token;
	public ResponseEntity<AuthResponseModel> login(LoginModel userRequest);
	
	// TODO input should be jwt token.
	public void Authorize(String token);
}
