package com.cynapsys.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class AssuranceUser implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	private Long cin;
	private Long numMatricule;
	private String nom;

	private String prenom;


	@Enumerated(EnumType.STRING)
	private Situation situationFamiliale;
	private String nomConjoint;
	private String adresse;
	private String email;
	@Enumerated(EnumType.STRING)
	private Filiere filiereCnam;
	private String numAffiliationCnam;
	private String urlFichierAffiliation;
	private Date dateNaissance;
	private String password;
	private float salaire;
	private boolean active;
	
	
	public AssuranceUser() {}
	
	
	
	
	
	
	public AssuranceUser(Long cin, Long numMatricule, String nom, String prenom, Situation situationFamiliale,
			String nomConjoint, String adresse, String email, Filiere filiereCnam, String numAffiliationCnam,
			String urlFichierAffiliation, Date dateNaissance, String password, float salaire, boolean active) {
		super();
		this.id = id;
		this.cin = cin;
		this.numMatricule = numMatricule;
		this.nom = nom;
		this.prenom = prenom;
		this.situationFamiliale = situationFamiliale;
		this.nomConjoint = nomConjoint;
		this.adresse = adresse;
		this.email = email;
		this.filiereCnam = filiereCnam;
		this.numAffiliationCnam = numAffiliationCnam;
		this.urlFichierAffiliation = urlFichierAffiliation;
		this.dateNaissance = dateNaissance;
		this.password = password;
		this.salaire = salaire;
		this.active = active;
	}






	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCin() {
		return cin;
	}
	public void setCin(Long cin) {
		this.cin = cin;
	}
	public Long getNumMatricule() {
		return numMatricule;
	}
	public void setNumMatricule(Long numMatricule) {
		this.numMatricule = numMatricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Situation getSituationFamiliale() {
		return situationFamiliale;
	}
	public void setSituationFamiliale(Situation situationFamiliale) {
		this.situationFamiliale = situationFamiliale;
	}
	public String getNomConjoint() {
		return nomConjoint;
	}
	public void setNomConjoint(String nomConjoint) {
		this.nomConjoint = nomConjoint;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Filiere getFiliereCnam() {
		return filiereCnam;
	}
	public void setFiliereCnam(Filiere filiereCnam) {
		this.filiereCnam = filiereCnam;
	}
	public String getNumAffiliationCnam() {
		return numAffiliationCnam;
	}
	public void setNumAffiliationCnam(String numAffiliationCnam) {
		this.numAffiliationCnam = numAffiliationCnam;
	}
	public String getUrlFichierAffiliation() {
		return urlFichierAffiliation;
	}
	public void setUrlFichierAffiliation(String urlFichierAffiliation) {
		this.urlFichierAffiliation = urlFichierAffiliation;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public float getSalaire() {
		return salaire;
	}
	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	

	
	
	

	}
