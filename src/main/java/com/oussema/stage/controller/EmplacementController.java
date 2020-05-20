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
import com.oussema.stage.model.Emplacement;
import com.oussema.stage.service.EmplacementService;

@RestController
@CrossOrigin
@RequestMapping("/emplacement")
public class EmplacementController {

	@Autowired
	EmplacementService EmplacementService;
	
	@GetMapping("/all")
	public List<Emplacement> getAll() {
		return EmplacementService.getAll();
	}
	
	@GetMapping("/{nom}")
	public Emplacement getById(@PathVariable String nom)
	{
	return 	EmplacementService.findByName(nom);
	}
	@PostMapping("/add")
	public Emplacement add(@RequestBody Emplacement emplacement)
	{
		return EmplacementService.add(emplacement);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
	public void delete(@PathVariable int id)
	{
		EmplacementService.delete(id);
	}
		@RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
		public void update(@RequestBody Emplacement emplacement, @PathVariable int id)
		{
			EmplacementService.update(id, emplacement);
		}
		@RequestMapping(method=RequestMethod.GET, value="/number")
		public int nombre( ) {
			return EmplacementService.nombre();
		}
}
