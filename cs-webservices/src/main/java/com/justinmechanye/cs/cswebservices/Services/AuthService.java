package com.justinmechanye.cs.cswebservices.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.justinmechanye.cs.cswebservices.Interfaces.IAuthService;
import com.justinmechanye.cs.cswebservices.Models.AuthResponseModel;
import com.justinmechanye.cs.cswebservices.Models.User;
import com.justinmechanye.cs.cswebservices.Repositories.UserRepository;


@Component
public class AuthService implements IAuthService {
	
	@Autowired
	UserRepository userRepository;
	
	
	public AuthService() {
		// This does nothing!!!!
	}
	
	@Override
	public ResponseEntity<AuthResponseModel> login(String userName, String password) {
		User user = this.userRepository.findByUsername(userName);
		AuthResponseModel arm = new AuthResponseModel();
		
		if(!password.equals(user.getPassword())) {
			return new ResponseEntity<AuthResponseModel>(arm, HttpStatus.UNAUTHORIZED);
		} else {
			//createJWT(user.getId(), "reviewStateAuth", "loggedin", 25000, user.getRole());
			arm.setJWT("JWT");
			arm.setRole(user.getRole());
			arm.setUsername(user.getUsername());
		}
		return new ResponseEntity<AuthResponseModel>(arm, HttpStatus.OK);
	}

	@Override
	public void Authorize(String token) {
		// TODO implement jwt authorization, may need new class.
	}
	
	private String createJWT(Integer id, String issuer, String subject, long ttlMillis, String userRole) {
		return "";
	}

}
