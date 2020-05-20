package com.oussema.stage.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name="USERS_ROLES",
	joinColumns={@JoinColumn(name="user_id")},
	inverseJoinColumns={@JoinColumn(name="role_id")})
	private Set<Role> roles = new HashSet<>();
	
	public User() {}
	public User(User users) {
		 this.roles = (Set<Role>) users.getRoles();
        this.username = users.getUsername();
        this.user_id = users.getUser_id();
        this.password = users.getPassword();
}
	

	public int getUser_id() {
		return user_id;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public void setId(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setLogin(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 public Set<Role> getRoles() {
	        return roles;
	    }
	 
	    public void setRoles(Set<Role> roles) {
	        this.roles = roles;
	    }

   /* public void setRoles(Set<Role> roles) {
        this.roles = (List<Role>) roles;
}*/
	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
	
