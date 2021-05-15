package com.plateit.project.auth;

public class AuthConstants {
	  public static final String SECRET = "SuperSecretKey";
	  public static final long EXPIRATION_TIME = 432_000_000; 
	  public static final String TOKEN_PREFIX = "Bearer ";
	  public static final String HEADER_STRING = "Authorization";
	  public static final String SIGN_UP_URL = "/api/register";
	  public static final String LOGIN_URL = "/login";
	  public static final String ERROR_URL = "/error";
	}

