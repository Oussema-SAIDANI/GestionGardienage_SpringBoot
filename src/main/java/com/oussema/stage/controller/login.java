package com.oussema.stage.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
import javax.ws.rs.Consumes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oussema.stage.model.Role;
import com.oussema.stage.model.RoleName;
import com.oussema.stage.model.User;
import com.oussema.stage.repository.RoleRepository;
import com.oussema.stage.repository.UserRepository;
import com.oussema.stage.security.JwtProvider;
import com.oussema.stage.service.CustomUserDetailsService;

import antlr.collections.List;
import message.JwtResponse;
import message.LoginForm;
import message.ResponseMessage;
import message.SignUpForm;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class login {
	@Autowired
	CustomUserDetailsService userService ; 
	 
	  @Autowired
	  AuthenticationManager authenticationManager;
	 
	  @Autowired
	  UserRepository userRepository;
	 
	  @Autowired
	  RoleRepository roleRepository;
	 
	  @Autowired
	  PasswordEncoder encoder;
	 
	  @Autowired
	  JwtProvider jwtProvider;
	
  /* @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured")
    public String securedHello() {
        return "Secured Hello";
    }*/
   
	  @PostMapping("/signin")
	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest)
	  {
		  Authentication authentication = authenticationManager.authenticate(
			        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
			 
			    SecurityContextHolder.getContext().setAuthentication(authentication);
			 
			    String jwt = jwtProvider.generateJwtToken(authentication);
			    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			 
			    return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
		  
	  }
	  
	  @PostMapping("/signup")
	  public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
	    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
	      return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
	          HttpStatus.BAD_REQUEST);
	    }
	 	 
	    // Creating user's account
	    User user = new User(signUpRequest.getUsername(),
	        encoder.encode(signUpRequest.getPassword()));
	 
	    Set<String> strRoles = signUpRequest.getRole();
	    Set<Role> roles = new HashSet<>();
	 
	    strRoles.forEach(role -> {
	      switch (role) {
	      case "admin":
	        Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
	            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	        roles.add(adminRole);
	 
	        break;
	      default:
	        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
	            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	        roles.add(userRole);
	        
	        
	      }
	    });
	 
	    user.setRoles(roles);
	    userRepository.save(user);
	 
	    return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	  }
	  
   @Consumes("application/json")
   @RequestMapping(value="/verifierUser", method = RequestMethod.POST)
   public User verifierUser(@RequestBody User u)
	{
		return userService.getUserUpdate(u.getUsername(),u.getPassword()); 
	}

   
}
