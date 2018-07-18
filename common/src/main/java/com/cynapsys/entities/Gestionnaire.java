package com.cynapsys.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Gestionnaire extends AssuranceUser  {

	private Date dateDerniereModif;
	
	public Gestionnaire() {
		// TODO Auto-generated constructor stub
	}

	public Gestionnaire(Long cin, Date dateCin, Long numMatricule, String nom, Sexe sexe, String prenom, String adresse,
			String email, Date dateInscription, Date dateNaissance, String password, boolean active,
			Date dateDerniereModif) {
		super(cin, dateCin, numMatricule, nom, sexe, prenom, adresse, email, dateInscription, dateNaissance, password,
				active);
		this.dateDerniereModif = dateDerniereModif;
	}





	public Date getDateDerniereModif() {
		return dateDerniereModif;
	}

	public void setDateDerniereModif(Date dateDerniereModif) {
		this.dateDerniereModif = dateDerniereModif;
	}


	
		
}
