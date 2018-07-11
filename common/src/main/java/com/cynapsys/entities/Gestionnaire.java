package com.cynapsys.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Gestionnaire extends AssuranceUser  {

	private Date dateAffiliation;
	
	public Gestionnaire() {
		// TODO Auto-generated constructor stub
	}

	
	
	

	public Gestionnaire(Long cin, Long numMatricule, String nom, String prenom, Situation situationFamiliale,
			String nomConjoint, String adresse, String email, Filiere filiereCnam, String numAffiliationCnam,
			String urlFichierAffiliation, Date dateNaissance, String password, float salaire, boolean active,
			Date dateAffiliation) {
		super(cin, numMatricule, nom, prenom, situationFamiliale, nomConjoint, adresse, email, filiereCnam,
				numAffiliationCnam, urlFichierAffiliation, dateNaissance, password, salaire, active);
		this.dateAffiliation = dateAffiliation;
	}









	public Date getDateAffiliation() {
		return dateAffiliation;
	}

	public void setDateAffiliation(Date dateAffiliation) {
		this.dateAffiliation = dateAffiliation;
	}


	
	
}
