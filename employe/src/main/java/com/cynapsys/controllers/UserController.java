package com.cynapsys.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cynapsys.entities.Admin;
import com.cynapsys.entities.AssuranceUser;
import com.cynapsys.entities.Assure;
import com.cynapsys.entities.Gestionnaire;
import com.cynapsys.entities.Role;
import com.cynapsys.entities.User;
import com.cynapsys.repositories.AdminRepository;
import com.cynapsys.repositories.AssureRepository;
import com.cynapsys.repositories.GestionnaireRepository;

@RestController
@RequestMapping(value="/user")
@CrossOrigin("*")
public class UserController {
@Autowired
 private AdminRepository adr;
@Autowired
private GestionnaireRepository gr;
@Autowired
private AssureRepository asr;

private List<User> users;
private List<User> fin;
private int i;
	@GetMapping(value="/all")
	public List<User> getAll() {
		List<Admin> l = adr.findAll();
		List<Gestionnaire> g = gr.findAll();
		List<Assure> a = asr.findAll();
		List<User> users = new ArrayList<User>();
		for (i=0; i < a.size() ; i++) {
			if (a.get(i).isActive()) {
				User assu= new User();
			assu.setCin(a.get(i).getCin());
			assu.setNom(a.get(i).getNom());
			assu.setPrenom(a.get(i).getPrenom());
			assu.setDateInscription(a.get(i).getDateInscription());
			assu.setRole(Role.Assuré);
			users.add(assu);
			}
		}	
		
		for (i=0; i < l.size() ; i++) {
			if (l.get(i).isActive()) {
				User assu= new User();
			assu.setCin(l.get(i).getCin());
			assu.setNom(l.get(i).getNom());
			assu.setPrenom(l.get(i).getPrenom());
			assu.setDateInscription(l.get(i).getDateInscription());
			assu.setRole(Role.Admin);
			users.add(assu);
			}
		}
		
		for (i=0; i < g.size() ; i++) {
			if (g.get(i).isActive()) {
				User assu= new User();
			assu.setCin(g.get(i).getCin());
			assu.setNom(g.get(i).getNom());
			assu.setPrenom(g.get(i).getPrenom());
			assu.setDateInscription(g.get(i).getDateInscription());
			assu.setRole(Role.Gestionnaire);
			users.add(assu);
			}
		}	
		return users;
	}
	
}
