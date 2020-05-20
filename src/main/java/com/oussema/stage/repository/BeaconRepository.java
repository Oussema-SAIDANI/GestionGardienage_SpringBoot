package com.oussema.stage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oussema.stage.model.Beacon;
import com.oussema.stage.model.Emplacement;

@Repository
public interface BeaconRepository extends JpaRepository<Beacon, Integer> {

	@Query("select b from Beacon b where b.nom=:nom")
	Beacon findByName(@Param("nom")String nom);
	
	/*@Query("select a from Beacon a where a.reference=:id")
	Beacon findByID(@Param("id")String id);*/
	@Query("select e from Emplacement e where e.beacon.id=:id")
	Emplacement findByBeacon(@Param("id")int id);
}
