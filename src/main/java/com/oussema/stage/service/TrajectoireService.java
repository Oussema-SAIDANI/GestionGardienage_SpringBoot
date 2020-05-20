package com.oussema.stage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oussema.stage.repository.TrajectoireRepository;
import com.oussema.stage.model.Emplacement;
import com.oussema.stage.model.Trajectoire;

@Service
public class TrajectoireService {

	@Autowired
	private TrajectoireRepository TrajectoireRepository;
	
	public List<Trajectoire> getAll()
	{
		return TrajectoireRepository.findAll();
	}
	
	public Trajectoire add(Trajectoire trajectoire)
	{
		return TrajectoireRepository.save(trajectoire);
	}
	
	public void update(int id,Trajectoire trajectoire)
	{
		TrajectoireRepository.save(trajectoire);
	}
	
	public void delete(int id)
	{
		TrajectoireRepository.deleteById(id);
	}
	
	public Optional<Trajectoire> find(int id)
	{
		return TrajectoireRepository.findById(id);
		
	}
	public Trajectoire getTrajec(String nom)
	{
		return TrajectoireRepository.findByName(nom);
	}
	public int nombre( ) {
		return (int) TrajectoireRepository.count();
	}
}
