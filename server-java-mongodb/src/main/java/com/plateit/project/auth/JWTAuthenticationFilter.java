package com.plateit.project.auth;


import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.plateit.project.auth.AuthConstants.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
  private AuthenticationManager authenticationManager;
  
  public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
    
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
    try {
      com.plateit.project.models.Login creds = new ObjectMapper()
        .readValue(req.getInputStream(), com.plateit.project.models.Login.class);
      return authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
          creds.getUsername(),
          creds.getPassword(),
          new ArrayList<>())
        
      );
    } catch (IOException e) {
    	System.out.println("error: new "+e.getMessage());
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException, ServletException {
    String token = JWT.create()
      .withSubject(((User) auth.getPrincipal()).getUsername())
      .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
      .sign(HMAC512(SECRET.getBytes()));
    System.out.println("token: "+ token);
    res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
  }

  @Override
  protected  void unsuccessfulAuthentication(HttpServletRequest req, HttpServletResponse res, AuthenticationException failed) throws IOException, ServletException {
	  System.out.println("\n\nUnsuccessfull error\n\n\n"+ failed.getMessage());
	  String message = failed.getMessage();
	  String response = String.format("{'message':'%s'}", message);
	  PrintWriter writer = new PrintWriter(res.getWriter());
	  writer.write(response);
	  
	  //super.unsuccessfulAuthentication(req, res, failed);
  }
}

