package com.oussema.stage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oussema.stage.model.Beacon;
import com.oussema.stage.model.Emplacement;
import com.oussema.stage.service.BeaconService;

@RestController
@CrossOrigin
@RequestMapping("/beacon")
public class BeaconController {
	
	@Autowired
	BeaconService BeaconService;
	
	@GetMapping("/all")
	public List<Beacon> getAll() {
		return BeaconService.getAll();
	}
	
	@PostMapping("/add")
	public Beacon add(@RequestBody Beacon agent)
	{
		return BeaconService.add(agent);
	}
	@GetMapping("/{nom}")
	public Beacon find(@PathVariable String nom)
	{
		return BeaconService.getBeacon(nom);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
	public void delete(@PathVariable int id)
	{
		BeaconService.delete(id);
	}
	@GetMapping("/emplacement/{id}")
	public Emplacement findByBeacon(@PathVariable int id)
	{
		return BeaconService.getEmp(id);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
	public void update(@RequestBody Beacon beacon, @PathVariable int id)
	{
		BeaconService.update(id, beacon);
	}
	@RequestMapping(method=RequestMethod.GET, value="/number")
	public int nombre( ) {
		return BeaconService.nombre();
	}
}
