package com.oussema.stage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.oussema.stage.model.Beacon;
import com.oussema.stage.model.Emplacement;
import com.oussema.stage.repository.EmplacementRepository;
import com.oussema.stage.repository.BeaconRepository;

@Service
@Primary
public class EmplacementService {
	
	@Autowired
	private EmplacementRepository EmplacementRepository;
	
	@Autowired
	private BeaconRepository BeaconRepository;
	
	public List<Emplacement> getAll() {
		return EmplacementRepository.findAll();
}
	public Emplacement add(Emplacement Emplacement) {
		return EmplacementRepository.save(Emplacement);
	}
	
	public void update(int id,Emplacement emplacement)
	{
		EmplacementRepository.save(emplacement);
	}
	public void delete(int id)
	{
		EmplacementRepository.deleteById(id);
	}
public Emplacement findByName(String nom) {
	return EmplacementRepository.findByName(nom);
}
public Optional<Emplacement> findById(int id)
{
	return EmplacementRepository.findById(id);
}
public int nombre( ) {
	return (int) EmplacementRepository.count();
}
}
