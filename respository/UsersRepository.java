package com.winner.spsec.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.winner.spsec.entity.Users;

public interface UsersRepository extends JpaRepository<Users,Integer>
{
	Optional<Users> findByUsernameAndPassword(String username,String password);

	Optional<Users> findByUsername(String username);

	
	
}
