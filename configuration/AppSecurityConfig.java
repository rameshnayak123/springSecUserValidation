package com.winner.spsec.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.winner.spsec.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class AppSecurityConfig {
	
	@Bean
	public PasswordEncoder encoder()
	{
		return new  BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService()
	{
		return new CustomUserDetailsService();
	}
	
	@Bean
	public AuthenticationProvider authServiceProvider()
	{
		DaoAuthenticationProvider dap = new DaoAuthenticationProvider();
		dap.setPasswordEncoder(encoder());
		dap.setUserDetailsService(userDetailsService());
		return dap;
	}
	
//	@Bean
//	public UserDetailsService userDetailsService(PasswordEncoder encoder)
//	{
//		UserDetails user = User.withUsername("Ramesh")
//				.password(encoder.encode("Ramesh@123"))
//				.roles("USER")
//				.build();
//		
//		UserDetails admin = User.withUsername("Ram")
//				.password(encoder.encode("Ram@123"))
//				.roles("ADMIN")
//				.build();
//		return new InMemoryUserDetailsManager(admin,user);
//		
//	}
	

	
	@Bean

	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception

	{

		return http.csrf().disable().authorizeHttpRequests().requestMatchers("/employee/id","/users").permitAll().and().

		authorizeHttpRequests().requestMatchers("/employee/**").authenticated().and().httpBasic().and().build();	

	}

}
