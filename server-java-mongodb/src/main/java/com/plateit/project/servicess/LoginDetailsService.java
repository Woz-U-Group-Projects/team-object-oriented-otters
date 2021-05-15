package com.plateit.project.servicess;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.plateit.project.models.LoginRepository;
import com.plateit.project.models.Login;

@Service
public class LoginDetailsService implements UserDetailsService{
	
	@Autowired
	private LoginRepository userRepository;

	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) {
		
		
		Login user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user.getRoles()));
	}

	public UserDetails Save(Login newUser) {
	
		newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
		Login savedUser = userRepository.save(newUser);
		return new org.springframework.security.core.userdetails.User(savedUser.getUsername(), savedUser.getPassword(), getAuthorities(savedUser.getRoles()));
	}

	private List<SimpleGrantedAuthority> getAuthorities(List<String> roles) {

		List<SimpleGrantedAuthority> authList = new ArrayList<>();
//		roles.forEach(v ->{
//			authList.add(new SimpleGrantedAuthority(v));
//		});
		authList.add(new SimpleGrantedAuthority("ROLE_USER"));

		return authList;
	}

}
