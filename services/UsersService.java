package com.winner.spsec.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winner.spsec.entity.Users;
import com.winner.spsec.respository.UsersRepository;

@Service
public class UsersService {
	
	
	@Autowired
	UsersRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Transactional(readOnly=true)
	public Users getById(int uid)
	{
		Optional<Users> u = userRepository.findById(uid);
		if(u.isPresent()) return u.get();
		return null;
	}
	
	@Transactional(readOnly=true)
	public Users getByusername(String username)
	{
		Optional<Users> u = userRepository.findByUsername(username);
		if(u.isPresent()) return u.get();
		return null;
	}
	
	@Transactional(readOnly=true)
	public Optional<Users> getByUserAndPassword(String username,String password)
	{
		return userRepository.findByUsernameAndPassword(username, password);
	}
	
	
	@Transactional
	public boolean adduser(Users u)
	{
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return userRepository.save(u) !=null;
	}
	

}
