package com.cynapsys.controllers;

import java.util.ArrayList;
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
import com.cynapsys.entities.Admin;
import com.cynapsys.entities.AssuranceUser;
import com.cynapsys.repositories.AdminRepository;
import com.cynapsys.repositories.AssureRepository;

@RestController
@RequestMapping(value="/assure")
@CrossOrigin("*")
public class AssureController {

	@Autowired
	private AssureRepository ar;
	private List<Assure> laf;
@GetMapping(value="/all")
public List<Assure> getAll() {
	List<Assure> la = ar.findAll();
	List<Assure> laf = new ArrayList<Assure>();
		 if (la.size() != 0) {
			for(int i=0; i<la.size(); i++) {
				if (la.get(i).isActive())
				{
					laf.add(la.get(i));
				}
			}
			return laf;
		}
	return null;
}

@GetMapping(value="/history/{cin}")
public List<Assure> getHistory(@PathVariable Long cin) {
	return ar.findByCin(cin);
	
}

@GetMapping(value="/get/{cin}")
public Assure getAssure(@PathVariable Long cin) {
	List<Assure> la = ar.findByCin(cin);
	for (int i=0; i<la.size(); i++) {
		if (la.get(i).isActive()) {
			return la.get(i);
		}
	}
	return null;
}

@PostMapping(value="/create")
public void createAssure(@RequestBody Assure a) {
	ar.save(a);
}

@PutMapping(value="/update/{cin}")
public void updateAssure(@RequestBody Assure ae, @PathVariable Long cin) {
	Assure a = getAssure(cin);
	if (a!= null)
		{
		a.setActive(false);
		ae.setActive(true);
		ar.save(a);
		ae.setCin(cin);
		ar.save(ae);
		}
}

@DeleteMapping(value="/delete/{cin}")
public void deleteAssure(@PathVariable Long cin) {
	Assure a = getAssure(cin);
	if (a != null) {	
		a.setActive(false);
		ar.save(a);
	}
}

}
