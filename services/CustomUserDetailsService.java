package com.winner.spsec.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.winner.spsec.entity.Users;
import com.winner.spsec.model.CustomerUserDetails;
import com.winner.spsec.respository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService
{

	@Autowired
	UsersRepository usersrepository;


	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		
		Optional<Users> ou = usersrepository.findByUsername(username);
		return ou.map(CustomerUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("user does not exist"));
	}

}
