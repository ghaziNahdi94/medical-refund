package com.cynapsys.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
import com.cynapsys.entities.Gestionnaire;
import com.cynapsys.repositories.AdminRepository;
import com.cynapsys.repositories.AssureRepository;
import com.cynapsys.repositories.GestionnaireRepository;

@RestController
@RequestMapping(value="/gestionnaire")
@CrossOrigin("*")
public class GestionnaireController {


	@Autowired
	private GestionnaireRepository ar;
	private List<Gestionnaire> laf;
	 @Autowired
	    private JavaMailSender mailSender;
	    // Use it to send Simple text emails
	 
	    @RequestMapping("/sendmail/{cin}")
	    public void sendSimpleMail(@PathVariable Long cin) {
	    	Gestionnaire g = getGestionnaire(cin);
	    	if (g != null)
	    	{
	    	SimpleMail mail =  new SimpleMail(g.getEmail());
	    	SimpleMailMessage message = new SimpleMailMessage();
	    	message.setSubject("Mot de passe");
	    	message.setTo(mail.getTo());
	        String a= "Bonjour,\n";
	    	String msg =a+  " Vous êtes inscrit sur la plateforme en tant que gestionnaire. Votre mot de passe pour se connecter sur la plateforme de remboursement médical de Cynapsys BY GFI est: " + g.getPassword();
	    	message.setText(msg);

	        mailSender.send(message);
	    }
	    	}

	
@GetMapping(value="/all")
public List<Gestionnaire> getAll() {
	List<Gestionnaire> la = ar.findAll();
	List<Gestionnaire> laf = new ArrayList<Gestionnaire>();
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
public List<Gestionnaire> getHistory(@PathVariable Long cin) {
	List<Gestionnaire> la = ar.findByCin(cin);
	List<Gestionnaire> laf = new ArrayList<Gestionnaire>();
	for (int i=0; i<la.size(); i++) {
		if (la.get(i).getDateDerniereModif() != null)
		{laf.add(la.get(i));}
	}
return laf;	
	
}
@GetMapping(value="/get/{cin}")
public Gestionnaire getGestionnaire(@PathVariable Long cin) {
	List<Gestionnaire> la = ar.findByCin(cin);
	for (int i=0; i<la.size(); i++) {
		if (la.get(i).isActive()) {
			return la.get(i);
		}
	}
	return null;
}

@PostMapping(value="/create")
public void createGestionnaire(@RequestBody Gestionnaire a) {
	ar.save(a);
}

@PutMapping(value="/update/{cin}")
public void updateGestionnaire(@RequestBody Gestionnaire ae, @PathVariable Long cin) {
	Gestionnaire a = getGestionnaire(cin);
	if (a!= null)
		{
		a.setActive(false);
		ae.setActive(true);
		ae.setId(null);
		ar.save(a);
		ae.setCin(cin);
		ar.save(ae);
		}
}

@DeleteMapping(value="/delete/{cin}")
public void deleteGestionnaire(@PathVariable Long cin) {
	Gestionnaire a = getGestionnaire(cin);
	if (a != null) {	
		a.setActive(false);
		ar.save(a);
	}
}


}

