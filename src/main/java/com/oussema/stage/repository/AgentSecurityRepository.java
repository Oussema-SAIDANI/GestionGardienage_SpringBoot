package com.oussema.stage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oussema.stage.model.AgentSecurity;

@Repository
public interface AgentSecurityRepository extends JpaRepository<AgentSecurity,Integer> {
	

	@Query("select a from AgentSecurity a ,Trajectoire b where b.id =:id and a.trajectoire.id=b.id")
	List<AgentSecurity> findByTrajec(@Param("id")int id);

}
