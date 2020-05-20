package com.oussema.stage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oussema.stage.model.Emplacement;

@Repository 
public interface EmplacementRepository extends JpaRepository<Emplacement, Integer> {
	
	@Query("select e from Emplacement e where e.nom =:nom")
	Emplacement findByName(String nom);

	@Query("select e from Emplacement e where e.id=:id")
	Emplacement findByAng(int id);
}
