package com.oussema.stage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oussema.stage.model.CustomUserDetails;
import com.oussema.stage.model.User;
import com.oussema.stage.repository.UserRepository;

import java.util.Optional;


@Service
@Primary
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	User user = userRepository.findByUsername(username).orElseThrow(
    	        () -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
        /*return optionalUsers
                .map(CustomUserDetails::new).get();*/
         return UserPrinciple.build(user);
    }
    
	public User getUserUpdate(String username, String password) {
		// TODO Auto-generated method stub
		return userRepository.findUser(username, password);
	}

    
}