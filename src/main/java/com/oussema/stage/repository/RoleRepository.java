package com.oussema.stage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oussema.stage.model.Role;
import com.oussema.stage.model.RoleName;
import com.oussema.stage.model.User;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(RoleName roleName);

}
