package com.tnt.bourse.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tnt.bourse.entities.Users;
import com.tnt.bourse.services.UsersService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Configuration
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


	@Autowired
	private UsersService usersService;
	@Value("${jwt.signing-key}")
	private String key;
	@Value("${jwt.prefix-token}")
	private String prefix;
	@Value("${jwt.header}")
	private String header;
	@Value("${jwt.exp-time}")
	private long expirationTime;
	private ObjectMapper mapper = new ObjectMapper();

	@Autowired
	@Override
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
	
		super.setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		Users user = null;
		try {
			user = mapper.readValue(request.getInputStream(), Users.class);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getAuthenticationManager()
				.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authResult.getAuthorities().forEach(role ->

		{

			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		});
		
	
		
		
		//user.setEmail(userDe);
		String token = Jwts.builder().setSubject(authResult.getName())
				.claim("roles", authorities)
			
				
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + expirationTime)) // in milliseconds
				.signWith(SignatureAlgorithm.HS512, key.getBytes()).compact();

		response.addHeader(header, prefix + token);

	}
}
