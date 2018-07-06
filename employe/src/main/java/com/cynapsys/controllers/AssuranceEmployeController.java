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
import com.cynapsys.entities.AssuranceEmploye;
import com.cynapsys.entities.AssuranceUser;
import com.cynapsys.repositories.AssuranceEmployeRepository;

@RestController
@RequestMapping(value="/employe")
@CrossOrigin("*")
public class AssuranceEmployeController {

	@Autowired
	private AssuranceEmployeRepository aer;
	
@GetMapping(value="/all")
public List<AssuranceEmploye> getAll() {
	return aer.findAll();
}

@GetMapping(value="/get/{id}")
public AssuranceEmploye getAssuranceEmploye(@PathVariable Long id) {
	return aer.findOne(id);
}

@PostMapping(value="/create")
public void createAssuranceEmploye(@RequestBody AssuranceEmploye a) {
	aer.save(a);
}

@PutMapping(value="/update/{id}")
public void updateAssuranceEmploye(@RequestBody AssuranceEmploye ae, @PathVariable Long id) {
	AssuranceEmploye a = aer.findOne(id);
	if (a!= null)
		{ae.setIdAssuranceUser(id);
		aer.save(ae);
		}
}

@DeleteMapping(value="/delete/{id}")
public void deleteAssuranceEmploye(@PathVariable Long id) {
	AssuranceEmploye a = aer.findOne(id);
	aer.delete(a);
}

@GetMapping(value="chercher/{motcle}")
public List<AssuranceEmploye> chercherAssuranceEmploye(@PathVariable String motcle) {
	return aer.chercher(motcle);
	
}

}
