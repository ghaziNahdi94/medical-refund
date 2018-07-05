package com.cynapsys.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cynapsys.entities.AssuranceEmploye;
import com.cynapsys.entities.AssuranceUser;
import com.cynapsys.entities.Role;
import com.cynapsys.entities.Situation;
import com.cynapsys.entities.Societe;
import com.cynapsys.repositories.AssuranceEmployeRepository;
import com.cynapsys.repositories.RoleRepository;
import com.cynapsys.repositories.SocieteRepository;

@RestController
public class AssuranceUserController {
	
	
	
@Autowired
	private AssuranceEmployeRepository aer;

@Autowired
private SocieteRepository sr;
	
@Autowired
private RoleRepository rr;



	@GetMapping("test")
	public String test() {
		
		
		Role r = new Role("ingenieur",5000l);
		
		
		
		
		Societe s = new Societe("cynapsys","aaaaa",(long) 98332911);
	
		AssuranceEmploye employe = new AssuranceEmploye(12345678l, 12345678l,"nahdi","ghazi",Situation.Célibataire,"","adresse",new Date(),"email","cnamsector","cnamaffiliation","urlFile",new Date(),"password",55.3f,true,new Date());
		
		ArrayList<AssuranceEmploye> em = new ArrayList<>();
		em.add(employe);
		ArrayList<AssuranceEmploye> rl = new ArrayList<>();
		rl.add(employe);
		s.setAssuranceEmployes(em);
		r.setAssuranceEmployes(rl);
		
		
		sr.save(s);
		rr.save(r);
		
		
		
		employe.setSociete(s);
		employe.setRole(r);
		
		
		aer.save(employe);
		
		
		return "hahaha";
		
		
		
	}

	
	
	
	@GetMapping("s")
	public Societe s() {
		
		ArrayList<AssuranceEmploye> aa = new ArrayList<>();
		
		Societe s = sr.getOne(1l);
		
		if(s.getAssuranceEmployes() != null)
		for(AssuranceEmploye e : s.getAssuranceEmployes())
		{
			aa.add(e);
		}
		else
			System.out.println("errooooor");
		
		
		return s;
	}

	
	
	@GetMapping(value="chercher/{motcle}")
	public List<AssuranceEmploye> chercherAssuranceEmploye(@PathVariable String motcle) {
		return aer.chercher(motcle);
		
	}
	
}
