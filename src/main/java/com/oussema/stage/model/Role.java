package com.oussema.stage.model;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "role")
public class Role {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int role_id;
	
	@Enumerated(EnumType.STRING)
    @NaturalId
    @Column(name ="name", length = 60)
    private RoleName name;


	public Role() {
    }


 

    public Role(RoleName name) {
		super();
		this.name = name;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public RoleName getRole() {
        return name;
    }

    public void setRole(RoleName role) {
        this.name = role;
}


    
    
}
