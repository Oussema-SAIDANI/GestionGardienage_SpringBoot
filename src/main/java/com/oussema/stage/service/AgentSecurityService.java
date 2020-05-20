package com.oussema.stage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.oussema.stage.model.AgentSecurity;
import com.oussema.stage.model.Trajectoire;
import com.oussema.stage.repository.AgentSecurityRepository;
import com.oussema.stage.repository.TrajectoireRepository;

@Service
@Primary
public class AgentSecurityService {

	@Autowired
	private AgentSecurityRepository AgentSecurityRepository;
	
	@Autowired
	private TrajectoireRepository TrajectoireRepository;
	
	public List<AgentSecurity> getAll() {
		return AgentSecurityRepository.findAll();
}
	public AgentSecurity add(AgentSecurity agent) {
		return AgentSecurityRepository.save(agent);
	}
	public Optional<AgentSecurity> getOne(int id)
	{
		return AgentSecurityRepository.findById(id);
	}
	public void update(int id,AgentSecurity agent)
	{
		AgentSecurityRepository.save(agent);
	}
	public void delete(int id)
	{
		 AgentSecurityRepository.deleteById(id);
	}

	public List<AgentSecurity> get(int id)
	{
		return AgentSecurityRepository.findByTrajec(id);
	}
	public int nombre( ) {
		return (int) AgentSecurityRepository.count();
	}
}
