package com.winner.spsec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winner.spsec.entity.Users;
import com.winner.spsec.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UsersService userservice;
	
	
	@PostMapping(consumes="application/json")
	public HttpStatus adduser(@RequestBody Users u)
	{
		if(userservice.adduser(u)) return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	

}
