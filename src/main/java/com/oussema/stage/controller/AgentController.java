package com.oussema.stage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.oussema.stage.model.AgentSecurity;
import com.oussema.stage.service.AgentSecurityService;

@RestController
//@CrossOrigin("*")
@CrossOrigin
@RequestMapping("/api")
public class AgentController {

	@Autowired
	 AgentSecurityService AgentSecurityService;
	
	@GetMapping("/all")
	public List<AgentSecurity> getAll()
	{
		return AgentSecurityService.getAll();
	}
	@RequestMapping("/{id}")
	public Optional<AgentSecurity> AgentSecurity(@PathVariable int id)
	{
		return AgentSecurityService.getOne(id);
	}
	@PostMapping("/add")
	public AgentSecurity add(@RequestBody AgentSecurity agent)
	{
		return AgentSecurityService.add(agent);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
	public void delete(@PathVariable int id)
	{
		AgentSecurityService.delete(id);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
	public void update(@RequestBody AgentSecurity agent, @PathVariable int id)
	{
		AgentSecurityService.update(id, agent);
	}

@GetMapping("/get/{id}")
public List<AgentSecurity> getAgentAll(@PathVariable int id){
	return AgentSecurityService.get(id);
}
@RequestMapping(method=RequestMethod.GET, value="/number")
public int nombre( ) {
	return AgentSecurityService.nombre();
}
}
