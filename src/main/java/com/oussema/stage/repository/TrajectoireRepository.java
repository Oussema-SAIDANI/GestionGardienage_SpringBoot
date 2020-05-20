package com.oussema.stage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oussema.stage.model.Trajectoire;

@Repository
public interface TrajectoireRepository extends JpaRepository<Trajectoire,Integer> {


	@Query("select t from Trajectoire t where t.nom=:nom")
	Trajectoire findByName(@Param("nom")String nom);
	
}
