package com.oussema.stage.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oussema.stage.model.User;



public class UserPrinciple implements UserDetails {
	  private static final long serialVersionUID = 1L;
	  
	  private int user_id;
	    private String username;
	 
	    @JsonIgnore
	    private String password;
	    private Collection<? extends GrantedAuthority> authorities;
	    public UserPrinciple(int user_id, 
	              String username, String password, 
	              Collection<? extends GrantedAuthority> authorities) {
	        this.user_id = user_id;
	        this.username = username;
	        this.password = password;
	        this.authorities = authorities;
	    }
	    public static UserPrinciple build(User user) {
	        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
	                new SimpleGrantedAuthority(role.getRole().name())
	        ).collect(Collectors.toList());
	 
	        return new UserPrinciple(
	                user.getUser_id(),
	                user.getUsername(),
	                user.getPassword(),
	                authorities
	        );
	    }
	    public int getId() {
	        return user_id;
	    }
	 
	    @Override
	    public String getUsername() {
	        return username;
	    }
	 
	    @Override
	    public String getPassword() {
	        return password;
	    }
	 
	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return authorities;
	    }
	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }
	 
	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }
	 
	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }
	 
	    @Override
	    public boolean isEnabled() {
	        return true;
	    }
	 
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        
	        UserPrinciple user = (UserPrinciple) o;
	        return Objects.equals(user_id, user.user_id);
	    }
	 
}
