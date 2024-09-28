package com.sellopy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfig {

	//FOr Encrypt your password
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	// FOr creatimg username and password 
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails adminUser = User.builder()
					.username("admin")
					.password(passwordEncoder().encode("admin"))
					.roles("ADMIN")
					.build();
		
		
		UserDetails normalUser = User.builder()
				.username("user")
				.password(passwordEncoder().encode("user"))
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(adminUser,normalUser);// For saving your admin and user password and user details
		
		
	}
	
	
	// For Taking Authentication 
	
	public AuthenticationManager authenticationMangaer(AuthenticationConfiguration configuration) throws Exception {
		
		
		return configuration.getAuthenticationManager();
	}
}
