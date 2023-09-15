package com.winner.spsec.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.winner.spsec.entity.Users;


public class CustomerUserDetails implements UserDetails
{
	private String username;
	
	private String password;
	
	
	private List<SimpleGrantedAuthority> authourities;
	
	public CustomerUserDetails() {};
	
	public CustomerUserDetails(Users users) {
		
		username = users.getUsername();
		password = users.getPassword();
		
		authourities = Arrays.stream(users.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	};

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authourities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
