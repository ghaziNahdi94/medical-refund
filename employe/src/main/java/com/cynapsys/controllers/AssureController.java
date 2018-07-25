package com.cynapsys.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cynapsys.entities.Assure;
import com.cynapsys.email.SimpleMail;
import com.cynapsys.entities.Admin;
import com.cynapsys.entities.BulletinSoin;
import com.cynapsys.entities.Gestionnaire;
import com.cynapsys.entities.AssuranceUser;
import com.cynapsys.repositories.AdminRepository;
import com.cynapsys.repositories.AssureRepository;

@RestController
@RequestMapping(value="/assure")
@CrossOrigin("*")
public class AssureController {
	private final Logger logger = LoggerFactory.getLogger(AssureController.class) ;
	private final String UPLOADED_FOLDER_AFF_FILE = "C:\\Users\\Toshiba\\Desktop\\stage\\ficheAffiliation";

	@Autowired
	private AssureRepository ar;
	private List<Assure> laf;	
	 @Autowired
	    private JavaMailSender mailSender;
	@RequestMapping("/sendmail/{cin}")
    public void sendSimpleMail(@PathVariable Long cin) {
    	Assure g = getAssure(cin);
    	if (g != null)
    	{
    	SimpleMail mail =  new SimpleMail(g.getEmail());
    	SimpleMailMessage message = new SimpleMailMessage();
    	message.setSubject("Mot de passe");
    	message.setTo(mail.getTo());
        String a= "Bonjour,\n";
    	String msg =a+  " Vous êtes inscrit sur la plateforme en tant qu'assuré. Votre mot de passe pour se connecter sur la plateforme de remboursement médical de Cynapsys BY GFI est: " + g.getPassword();
    	message.setText(msg);
        mailSender.send(message);
    }
    	}
	
	 
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

@PostMapping("/uploadAffFile")
public String uploadAffFile(@RequestParam("file") MultipartFile file) {

	String fileName = "";
	
	if(file.isEmpty()) {
		logger.debug("empty !");
	}
	
	
	
	try {
		fileName = saveUploadedFile(file, UPLOADED_FOLDER_AFF_FILE);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	return fileName;
}
private String saveUploadedFile(MultipartFile file, String directory) throws IOException {

	String fileName = RandomStringUtils.randomAlphanumeric(30) + ".pdf";

	File directoryFile = new File(directory);

	String[] files = directoryFile.list();


	while(Arrays.asList(files).contains(fileName)) {
		fileName = RandomStringUtils.randomAlphanumeric(30) + ".pdf";
	}
	

    if (file.isEmpty()) {
        return "";
    }

    byte[] bytes = file.getBytes();
    Path path = Paths.get(directory + fileName);
    Files.write(path, bytes);
    return fileName;
}
@GetMapping("/downloadAffFile/{name}")
public ResponseEntity<InputStreamResource> downloadAffFile(@PathVariable String name) throws IOException {


	File file = new File(UPLOADED_FOLDER_AFF_FILE+name);

    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType("application/pdf"));
    headers.add("Content-Disposition", "filename=" + name);
    headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
    headers.add("Pragma", "no-cache");
    headers.add("Expires", "0");
    headers.setContentLength(file.length());
    ResponseEntity<InputStreamResource> response = new ResponseEntity<InputStreamResource>(
      new InputStreamResource(new FileInputStream(file)), headers, HttpStatus.OK);
    return response;
}


@GetMapping(value="/history/{cin}")
public List<Assure> getHistory(@PathVariable Long cin) {
	List<Assure> la = ar.findByCin(cin);
	List<Assure> laf = new ArrayList<Assure>();
	for (int i=0; i<la.size(); i++) {
		if (la.get(i).getDateDerniereModif() != null)
		{laf.add(la.get(i));}
	}
return laf;		
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


@GetMapping(value="/getByCIN/{cin}")
public Assure getAssureByCIN(@PathVariable Long cin) {
	
	return ar.getByCin(cin);
}



@PostMapping(value="/create")
public void createAssure(@RequestBody Assure a) {
	ar.save(a);
}





@DeleteMapping(value="/delete/{cin}")
public void deleteAssure(@PathVariable Long cin) {
	Assure a = getAssure(cin);
	if (a != null) {	
		a.setActive(false);
		ar.save(a);
	}
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
}
@PutMapping(value="/update/{cin}")
public void updateAssure(@PathVariable Long cin, @RequestBody Assure ae) {
	Assure a = getAssure(cin);
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


}
