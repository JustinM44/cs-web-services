package com.justinmechanye.cs.cswebservices.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justinmechanye.cs.cswebservices.Models.AuthResponseModel;
import com.justinmechanye.cs.cswebservices.Models.LoginModel;
import com.justinmechanye.cs.cswebservices.Services.AuthService;

@RestController
@RequestMapping("/api/authservices")
public class AuthController {
	@Autowired
	AuthService authService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/login")
	public ResponseEntity<AuthResponseModel> login(@RequestBody LoginModel request) {
		System.out.print("InController");
		return authService.login(request);
	}
}
