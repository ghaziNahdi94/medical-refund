package com.cynapsys.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
=======
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
>>>>>>> 81c511dbf5eee0af600592798bff3fef6f53ce9b
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cynapsys.email.SimpleMail;
import com.cynapsys.entities.Admin;
import com.cynapsys.entities.Assure;
import com.cynapsys.entities.User;
import com.cynapsys.repositories.AdminRepository;

@RestController
@RequestMapping(value="/admin")
@CrossOrigin("*")
public class AdminController {

	@Autowired
	private AdminRepository ar;
	
	private List<Admin> laf;
<<<<<<< HEAD
	 @Autowired
	    private JavaMailSender mailSender;
	@RequestMapping("/sendmail/{cin}")
 public void sendSimpleMail(@PathVariable Long cin) {
 	Admin g = getAdmin(cin);
 	if (g != null)
 	{
 	SimpleMail mail =  new SimpleMail(g.getEmail());
 	SimpleMailMessage message = new SimpleMailMessage();
 	message.setSubject("Mot de passe");
 	message.setTo(mail.getTo());
     String a= "Bonjour,\n";
 	String msg =a+  " Vous êtes inscrit sur la plateforme en tant qu'admin. Votre mot de passe pour se connecter sur la plateforme de remboursement médical de Cynapsys BY GFI est: " + g.getPassword();
 	message.setText(msg);
     mailSender.send(message);
 }
 	}
=======
	
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
>>>>>>> 81c511dbf5eee0af600592798bff3fef6f53ce9b
	
	
@GetMapping(value="/all")
public List<Admin> getAll() {
	List<Admin> la = ar.findAll();
	List<Admin> laf = new ArrayList<Admin>();
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
public List<Admin> getHistory(@PathVariable Long cin) {
	List<Admin> la = ar.findByCin(cin);
	List<Admin> laf = new ArrayList<Admin>();
	for (int i=0; i<la.size(); i++) {
		if (la.get(i).getDateDerniereModif() != null)
		{laf.add(la.get(i));}
	}
return laf;	
}

@GetMapping(value="/get/{cin}")
public Admin getAdmin(@PathVariable Long cin) {
	List<Admin> la = ar.findByCin(cin);
	for (int i=0; i<la.size(); i++) {
		if (la.get(i).isActive()) {
			return la.get(i);
		}
	}
	return null;
}

@PostMapping(value="/create")
public void createAdmin(@RequestBody Admin a) {
	a.setPassword(passwordEncoder.encode(a.getPassword()));
	ar.save(a);
}

@PutMapping(value="/updateadmin/{cin}")
public void updateAdmin(@PathVariable Long cin, @RequestBody Admin ae) {
	Admin a = getAdmin(cin);
	if (a!= null)
		{ 
		a.setActive(false);
		ar.save(a);
		ae.setId(null);
		ae.setActive(true);
		ae.setDateDerniereModif(new Date());
		ar.save(ae);
		}
}





@DeleteMapping(value="/delete/{cin}")
public void deleteAdmin(@PathVariable Long cin) {
	Admin a = getAdmin(cin);
	if (a != null) {	
		a.setActive(false);
		ar.save(a);
	}
}



@GetMapping("/get/auth/{email}/{password}")
public Admin getByEmail(@PathVariable String email, @PathVariable String password) {
	
	Admin a = ar.findByEmail(email);
	
	if (a != null) {
	
		
		if(passwordEncoder.matches(password, a.getPassword())) {
			
		return a;	
			
		}		
	}
	
	return null;
}



}


