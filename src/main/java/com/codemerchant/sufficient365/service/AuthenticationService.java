package com.codemerchant.sufficient365.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import static java.util.Collections.emptyList;

public class AuthenticationService {
	static final long EXPIRATIONTIME = 864_000_00;
	static final String SIGNINGKEY = "SecretKey";
	static final String PREFIX = "Bearer";

	// Adding token to the Auth header
	public static void addToken(HttpServletResponse response, String username) {
		String jwtToken = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS512, SIGNINGKEY).compact();

		response.addHeader("Authorization", PREFIX + " " + jwtToken);

		response.addHeader("Access-Control-Expose-Headers", "Authorization");
	}

	// getting token from auth header
	public static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");

		if (token != null) {
			String user = Jwts.parser()
					.setSigningKey(SIGNINGKEY)
					.parseClaimsJws(token.replace(PREFIX, ""))
					.getBody()
					.getSubject();
			
			if(user != null)
				return new UsernamePasswordAuthenticationToken(user, null, emptyList());
		}

		return null;
	}

}
