package com.cynapsys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cynapsys.entities.Assure;
import com.cynapsys.entities.AssuranceUser;
import com.cynapsys.repositories.AssureRepository;

@RestController
@RequestMapping(value="/employe")
@CrossOrigin("*")
public class AssureController {

	@Autowired
	private AssureRepository ar;
	
@GetMapping(value="/all")
public List<Assure> getAll() {
	return ar.findAll();
}

@GetMapping(value="/get/{id}")
public Assure getAssuranceEmploye(@PathVariable Long id) {
	return ar.findOne(id);
}

@PostMapping(value="/create")
public void createAssuranceEmploye(@RequestBody Assure a) {
	ar.save(a);
}

@PutMapping(value="/update/{id}")
public void updateAssuranceEmploye(@RequestBody Assure ae, @PathVariable Long id) {
	Assure a = ar.findOne(id);
	if (a!= null)
		{
		ae.setId(id);
		ar.save(ae);
		}
}

@DeleteMapping(value="/delete/{id}")
public void deleteAssuranceEmploye(@PathVariable Long id) {
	Assure a = ar.findOne(id);
	ar.delete(a);
}

@GetMapping(value="chercher/{motcle}")
public List<Assure> chercherAssuranceEmploye(@PathVariable String motcle) {
	return ar.chercher(motcle);
	
}

}