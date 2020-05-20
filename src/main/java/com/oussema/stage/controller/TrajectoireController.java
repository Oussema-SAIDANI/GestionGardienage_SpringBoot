package com.oussema.stage.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oussema.stage.service.TrajectoireService;
import com.oussema.stage.service.EmplacementService;
import com.oussema.stage.model.Emplacement;
import com.oussema.stage.model.Trajectoire;

@RestController
@CrossOrigin
@RequestMapping("/trajectoire")
public class TrajectoireController {

	@Autowired
	TrajectoireService trajectoireService;
	
	@Autowired
	EmplacementService EmplacementService;
	
	@GetMapping("/all")
	public List<Trajectoire> getAll()
	{
		return trajectoireService.getAll();
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
	public void delete(@PathVariable int id)
	{
		trajectoireService.delete(id);
	}
	
	@PostMapping("/add")
	public Trajectoire add(@RequestBody Trajectoire trajectoire)
	{
		//, @RequestBody Emplacement emplacement
		//,@RequestBody List<Emplacement> emplacements
	//	trajectoire.setEmplacements(Arrays.asList(emplacement));
		//trajectoire.setEmplacements(emplacements);
		return trajectoireService.add(trajectoire);
	}
	
	/*@PutMapping("/{id}")
	public void update(@PathVariable int id , @RequestBody Trajectoire trajectoire)
	{
		
		 trajectoireService.update(id, trajectoire);
		
	}*/
	@GetMapping("/{nom}")
	public Trajectoire getTrajec(@PathVariable String nom) {
		return trajectoireService.getTrajec(nom);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
	public void update(@RequestBody Trajectoire trajectoire, @PathVariable int id)
	{
		trajectoireService.update(id, trajectoire);
	}
	@RequestMapping(method=RequestMethod.GET, value="/number")
	public int nombre( ) {
		return trajectoireService.nombre();
	}
}
