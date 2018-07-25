package com.cynapsys.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cynapsys.Repositories.BordereauRepository;
import com.cynapsys.entities.Bordereau;

@RestController
@RequestMapping("/bordereau")
@CrossOrigin("*")
public class BordereauController {

	
	@Autowired
	private BordereauRepository br;
	
	@GetMapping("/history")
	public List<Bordereau> getHistory(){
		
		return br.findAll().stream().filter(b -> b.getDateEnvoi() != null).collect(Collectors.toList());
		
	}
	
	
	
	
	
	
}
