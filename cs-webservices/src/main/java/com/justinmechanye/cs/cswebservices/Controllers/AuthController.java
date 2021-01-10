package com.justinmechanye.cs.cswebservices.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justinmechanye.cs.cswebservices.Models.AuthResponseModel;
import com.justinmechanye.cs.cswebservices.Models.User;
import com.justinmechanye.cs.cswebservices.Repositories.UserRepository;
import com.justinmechanye.cs.cswebservices.Services.AuthService;

@RestController
public class AuthController {
	@Autowired
	AuthService authService;
	
	@PostMapping(value="/login")
	public ResponseEntity<AuthResponseModel> login() {
		return authService.login("userBeforeSalt", "password1");
	}
}
