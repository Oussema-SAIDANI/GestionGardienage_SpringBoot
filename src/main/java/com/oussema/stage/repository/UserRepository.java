package com.oussema.stage.repository;

import org.springframework.stereotype.Repository;

import com.oussema.stage.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	    Optional<User> findByUsername(String username);
	    Boolean existsByUsername(String username);
	    
	    @Query("select o from User o where o.username=:username and o.password=:password")
	    User findUser(@Param("username")String username, @Param("password")String password);
	
}