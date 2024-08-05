package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public UserDetailsService users() {
		UserDetails user1 = User.builder()
			.username("user1")
			.password("{noop}user1")
			.roles("USER")
			.build();
		
		UserDetails user2 = User.builder()
			.username("user2")
			.password("{noop}user2")
			.roles("ADMIN")
			.build();
		return new InMemoryUserDetailsManager(user1, user2);
	}
}
