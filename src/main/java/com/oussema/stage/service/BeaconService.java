package com.oussema.stage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import com.oussema.stage.model.Beacon;
import com.oussema.stage.model.Emplacement;
import com.oussema.stage.repository.BeaconRepository;

@Service
@Primary
public class BeaconService {
	
	@Autowired
	private BeaconRepository BeaconRepositry;
	
	public List<Beacon> getAll() {
		return BeaconRepositry.findAll();
}
	public Beacon add(Beacon beacon) {
		return BeaconRepositry.save(beacon);
	}
	public Optional<Beacon> getOne(int id)
	{
		return BeaconRepositry.findById(id);
	}
	public void update(int id,Beacon beacon)
	{
		BeaconRepositry.save(beacon);
	}
	public void delete(int ref)
	{
		BeaconRepositry.deleteById(ref);
	}
	public Beacon getBeacon(String nom)
	{
		return BeaconRepositry.findByName(nom);
	}
	public Emplacement getEmp(int id)
	{
		return BeaconRepositry.findByBeacon(id);
	}
	public int nombre( ) {
		return (int) BeaconRepositry.count();
	}
}
