package com.justinmechanye.cs.cswebservices.Services;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAuthFilter extends OncePerRequestFilter {
	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer";
	// TODO MOVE TO SECRETS.
	private final String SECRET = "testSecret";
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try { 
			if(checkToken(request, response)) {
				System.out.print("inside doFilter");
				Claims claims = validateToken(request);
				if(claims.get("userId") != null) {
					grantAuth(claims);
				} else {
					SecurityContextHolder.clearContext();
				}
			} else {
				SecurityContextHolder.clearContext();
			}
			filterChain.doFilter(request, response);
		} catch(Exception e) {
			System.out.print(e);
		}
		
	}

	private boolean checkToken(HttpServletRequest request, HttpServletResponse res) {
		String authHeader = request.getHeader(HEADER);
		return (authHeader != null && authHeader.startsWith(PREFIX));
	}
	
	private Claims validateToken(HttpServletRequest request) {
		String token = request.getHeader(HEADER).replace(PREFIX, "");
		return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(token).getBody();
	}
	
	private void grantAuth(Claims claims) {
		List<String> authorities = (List) claims.get("authorities");
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null, authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
}
