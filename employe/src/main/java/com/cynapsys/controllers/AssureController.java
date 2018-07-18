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
<<<<<<< HEAD
import com.cynapsys.entities.Admin;
=======
import com.cynapsys.entities.BulletinSoin;
>>>>>>> e0371131a3d4ac1bf02611614b9ca7e95ee40f85
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

<<<<<<< HEAD
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
=======
@GetMapping(value="/getByCIN/{cin}")
public Assure getAssureByCIN(@PathVariable Long cin) {
	
	return ar.getByCin(cin);
}

@GetMapping(value="/get/{id}")
public Assure getAssuranceEmploye(@PathVariable Long id) {
	
	return  ar.getById(id);
>>>>>>> e0371131a3d4ac1bf02611614b9ca7e95ee40f85
}

@PostMapping(value="/create")
public void createAssure(@RequestBody Assure a) {
	ar.save(a);
}

<<<<<<< HEAD
@PutMapping(value="/update/{cin}")
public void updateAssure(@RequestBody Assure ae, @PathVariable Long cin) {
	Assure a = getAssure(cin);
=======
@PutMapping(value="/update/{id}")
public void updateAssuranceEmploye(@RequestBody Assure ae, @PathVariable Long id) {
	Assure a = ar.getById(id);
>>>>>>> e0371131a3d4ac1bf02611614b9ca7e95ee40f85
	if (a!= null)
		{
		a.setActive(false);
		ae.setActive(true);
		ar.save(a);
		ae.setCin(cin);
		ar.save(ae);
		}
}

<<<<<<< HEAD
@DeleteMapping(value="/delete/{cin}")
public void deleteAssure(@PathVariable Long cin) {
	Assure a = getAssure(cin);
	if (a != null) {	
		a.setActive(false);
		ar.save(a);
	}
=======
@DeleteMapping(value="/delete/{id}")
public void deleteAssuranceEmploye(@PathVariable Long id) {
	Assure a = ar.findById(id).orElse(null);
	ar.delete(a);
}


@GetMapping(value="/bulletin/{id}")
public Assure getAsureByBulletinId(@PathVariable Long id) {
	
	Assure as = null;
	
	List<Assure> list = ar.findAll();
	
	for(Assure a : list) {
		
		for(BulletinSoin b : a.getBulletinSoins()) {
			System.out.println(b.getId()+"/"+id);
			System.out.println(b.getId().equals(id));
			if(b.getId().equals(id))
				as = a;
			
		}
		
	}
	
	return as;
>>>>>>> e0371131a3d4ac1bf02611614b9ca7e95ee40f85
}



}
