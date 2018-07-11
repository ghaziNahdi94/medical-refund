package com.cynapsys.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Assure extends AssuranceUser{
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAffiliation;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	private int nbrPersonneEnCharge;
	private String nationnalite;

	@OneToMany(mappedBy="assure")
	private List<BulletinSoin> bulletinSoins;

	

	public Assure() {
		// TODO Auto-generated constructor stub
	}


	
	
	
	
	
	
	
	

	public Assure(Long cin, Long numMatricule, String nom, String prenom, Situation situationFamiliale,
			String nomConjoint, String adresse, String email, Filiere filiereCnam, String numAffiliationCnam,
			String urlFichierAffiliation, Date dateNaissance, String password, float salaire, boolean active,
			Date dateAffiliation, Role role, int nbrPersonneEnCharge, String nationnalite,
			List<BulletinSoin> bulletinSoins) {
		super(cin, numMatricule, nom, prenom, situationFamiliale, nomConjoint, adresse, email, filiereCnam,
				numAffiliationCnam, urlFichierAffiliation, dateNaissance, password, salaire, active);
		this.dateAffiliation = dateAffiliation;
		this.role = role;
		this.nbrPersonneEnCharge = nbrPersonneEnCharge;
		this.nationnalite = nationnalite;
		this.bulletinSoins = bulletinSoins;
	}











	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	public List<BulletinSoin> getCareBulletins() {
		return bulletinSoins;
	}

	public void setCareBulletins(List<BulletinSoin> bulletinSoins) {
		this.bulletinSoins = bulletinSoins;
	}

	public Date getDateAffiliation() {
		return dateAffiliation;
	}

	public void setDateAffiliation(Date dateAffiliation) {
		this.dateAffiliation = dateAffiliation;
	}

	public int getNbrPersonneEnCharge() {
		return nbrPersonneEnCharge;
	}

	public void setNbrPersonneEnCharge(int nbrPersonneEnCharge) {
		this.nbrPersonneEnCharge = nbrPersonneEnCharge;
	}

	public String getNationnalite() {
		return nationnalite;
	}

	public void setNationnalite(String nationnalite) {
		this.nationnalite = nationnalite;
	}

	
	
	
	
	

}

