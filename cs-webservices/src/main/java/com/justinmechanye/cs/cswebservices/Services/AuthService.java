package com.justinmechanye.cs.cswebservices.Services;



import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.justinmechanye.cs.cswebservices.Interfaces.IAuthService;
import com.justinmechanye.cs.cswebservices.Models.AuthResponseModel;
import com.justinmechanye.cs.cswebservices.Models.LoginModel;
import com.justinmechanye.cs.cswebservices.Models.UserModels.User;
import com.justinmechanye.cs.cswebservices.Repositories.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class AuthService implements IAuthService {
	
	@Autowired
	UserRepository userRepository;
	
	
	public AuthService() {
		// This does nothing!!!!
	}
	
	@Override
	public ResponseEntity<AuthResponseModel> login(LoginModel userRequest) {
		AuthResponseModel arm = new AuthResponseModel();
		try {
			User user = this.userRepository.findByUsername(userRequest.getUsername());
			// TODO set up hashing for input password and check that hashed pwds are the same.
			if(!user.getHash().equals(userRequest.getPassword())) {
				return new ResponseEntity<AuthResponseModel>(arm, HttpStatus.UNAUTHORIZED);
			} else {
				createJWT(user.getId(), user.getUsername(), user.getRole());
				arm.setJWT(createJWT(user.getId(), user.getUsername(), user.getRole()));
				arm.setRole(user.getRole());
				arm.setUsername(user.getUsername());
				arm.setUserId(user.getId());
			}
			return new ResponseEntity<AuthResponseModel>(arm, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<AuthResponseModel>(arm, HttpStatus.UNAUTHORIZED);
		}
		
	}

	@Override
	public void Authorize(String token) {
		// TODO implement jwt authorization, may need new class.
	}
	
	private String createJWT(Integer id, String username, String userRole) {
		//TODO use secret manager. 
		String secretKey ="testSecret";
		
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(userRole);
		
		String token = Jwts.builder().setId("myJwtToken").setSubject(username)
						.claim("userId", id)
						.claim("userName", username)
						.claim("role", userRole)
						.claim("authorities",
								grantedAuthorities.stream()
										.map(GrantedAuthority::getAuthority)
										.collect(Collectors.toList())).setIssuedAt(new Date(System.currentTimeMillis()))
						.setExpiration(new Date(System.currentTimeMillis() + 604800000))
						.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
		return token;
	}
}
