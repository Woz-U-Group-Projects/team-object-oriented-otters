package com.plateit.project.security;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.*;


import com.plateit.project.auth.JWTAuthenticationFilter;
import com.plateit.project.auth.JWTAuthorizationFilter;
import com.plateit.project.servicess.LoginDetailsService;
import com.plateit.project.auth.AuthConstants;



@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private LoginDetailsService userDetailsService;

	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
         .userDetailsService(userDetailsService)
         .passwordEncoder(passwordEncoder());
		
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
//		http
//			.authorizeRequests()
//			.antMatchers("/register").permitAll()
//			.anyRequest()
//			.authenticated()
//			.and()
//			.httpBasic()
//			.authenticationEntryPoint(authenticationEntryPoint);
		
	    http.cors()
	      .and()
	      .csrf().disable()
	      .authorizeRequests().antMatchers(AuthConstants.SIGN_UP_URL,AuthConstants.LOGIN_URL).permitAll()
	      .anyRequest().authenticated()
	      .and()
	      .addFilter(new JWTAuthenticationFilter(authenticationManager()))
	      .addFilter(new JWTAuthorizationFilter(authenticationManager()))
	      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	    
//	    http.cors()
//	      .and()
//	      .csrf().disable()
//	      .authorizeRequests().antMatchers(HttpMethod.POST, AuthConstants.LOGIN_URL).permitAll()
//	      .anyRequest().authenticated()
//	      .and()
//	      .addFilter(new JWTAuthenticationFilter(authenticationManager()))
//	      .addFilter(new JWTAuthorizationFilter(authenticationManager()))
//	      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}
	
	  @Bean
	  CorsConfigurationSource corsConfigurationSource() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration corsConfig = new CorsConfiguration();
	    corsConfig.applyPermitDefaultValues();
	    corsConfig.setExposedHeaders(Arrays.asList("Authorization"));
	    source.registerCorsConfiguration("/**", corsConfig);
	    return source;
	  }

}
