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
	@Enumerated(EnumType.STRING)
	private Situation situationFamiliale;
	private String nomConjoint;
	@Enumerated(EnumType.STRING)
	private Filiere filiereCnam;
	private String numAffiliationCnam;
	private String urlFichierAffiliation;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDerniereModif;
	private float salaire;
	@Enumerated(EnumType.STRING)
	private Poste poste;
	private int nbrPersonneEnCharge;
	private String nationnalite;
	@OneToMany(mappedBy="assures")
	private List<BulletinSoin> bulletinSoins;

	

	public Assure() {
		// TODO Auto-generated constructor stub
	}



	public Assure(Long cin, Date dateCin, Long numMatricule, String nom, Sexe sexe, String prenom,
			String adresse, String email, Date dateInscription, Date dateNaissance, String password, boolean active,
			Situation situationFamiliale, String nomConjoint, Filiere filiereCnam, String numAffiliationCnam,
			String urlFichierAffiliation, Date dateDerniereModif, float salaire, Poste poste, int nbrPersonneEnCharge,
			String nationnalite, List<BulletinSoin> bulletinSoins) {
		super(cin, dateCin, numMatricule, nom, sexe, prenom, adresse, email, dateInscription, dateNaissance,
				password, active);
		this.situationFamiliale = situationFamiliale;
		this.nomConjoint = nomConjoint;
		this.filiereCnam = filiereCnam;
		this.numAffiliationCnam = numAffiliationCnam;
		this.urlFichierAffiliation = urlFichierAffiliation;
		this.dateDerniereModif = dateDerniereModif;
		this.salaire = salaire;
		this.poste = poste;
		this.nbrPersonneEnCharge = nbrPersonneEnCharge;
		this.nationnalite = nationnalite;
		this.bulletinSoins = bulletinSoins;
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

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public Poste getPoste() {
		return poste;
	}



	public void setPoste(Poste poste) {
		this.poste = poste;
	}



	public List<BulletinSoin> getBulletinSoins() {
		return bulletinSoins;
	}



	public void setBulletinSoins(List<BulletinSoin> bulletinSoins) {
		this.bulletinSoins = bulletinSoins;
	}

	

	public Date getDateDerniereModif() {
		return dateDerniereModif;
	}





	public void setDateDerniereModif(Date dateDerniereModif) {
		this.dateDerniereModif = dateDerniereModif;
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

