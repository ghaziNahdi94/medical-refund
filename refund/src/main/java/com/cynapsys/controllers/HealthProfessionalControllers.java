package com.cynapsys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cynapsys.Repositories.HealthProfessionalRepository;
import com.cynapsys.entities.HealthProfessionnal;

@RestController
public class HealthProfessionalControllers {

	@Autowired
	private HealthProfessionalRepository hpr;
	
    @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addHealthProfessional")
	public HealthProfessionnal addHealthProfessional(@RequestBody HealthProfessionnal hp) {
		
		
		hpr.save(hp);
		
		
		return hp;
	}
	
	
	
}
