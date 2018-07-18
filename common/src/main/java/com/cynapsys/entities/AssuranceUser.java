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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@MappedSuperclass
public class AssuranceUser implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	private Long cin;
	@Temporal(value = TemporalType.DATE)
	private Date dateCin;
	private Long numMatricule;
	private String nom;
	private Sexe sexe;
	private String prenom;
	private String adresse;
	private String email;
	private Date dateInscription;
	@Temporal(value = TemporalType.DATE)
	private Date dateNaissance;
	private String password;
	private boolean active;
	
	public AssuranceUser() {}



	public AssuranceUser(Long cin, Date dateCin, Long numMatricule, String nom, Sexe sexe, String prenom,
			String adresse, String email, Date dateInscription, Date dateNaissance, String password, boolean active) {
		this.cin = cin;
		this.dateCin = dateCin;
		this.numMatricule = numMatricule;
		this.nom = nom;
		this.sexe = sexe;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.dateInscription = dateInscription;
		this.dateNaissance = dateNaissance;
		this.password = password;
		this.active = active;
	}











	public Date getDateInscription() {
		return dateInscription;
	}











	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
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


	public Date getDateCin() {
		return dateCin;
	}


	public void setDateCin(Date dateCin) {
		this.dateCin = dateCin;
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


	public Sexe getSexe() {
		return sexe;
	}


	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
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


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	
	}
