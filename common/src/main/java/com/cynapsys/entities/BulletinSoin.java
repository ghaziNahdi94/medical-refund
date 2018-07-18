package com.cynapsys.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class BulletinSoin implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	private Long numBulletin;
	private String urlBulletin;
	private float montantRembourse;
	private float montantPharmacie;
	private String etat;
	private String resultat;
	private Date dateValidation;
	private Date dateAffiliation;
	private Date dateSoin;
	private boolean active;
	
    @JsonManagedReference
	@OneToMany(cascade= {CascadeType.ALL}, mappedBy="bulletinSoin")
	private List<ArticleMedical> articleMedicals;
	
	@ManyToOne
	@JoinColumn(name="idBordereau")
	private Bordereau bordereaux;
	
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="idAssure")
	private Assure assure;
	
	
	public BulletinSoin() {
		// TODO Auto-generated constructor stub
	}


	public BulletinSoin(Long id, Long numBulletin, String urlBulletin, float montantRembourse, float montantPharmacie,
			String etat, String resultat, Date dateValidation, Date dateAffiliation, Date dateSoin, boolean active,
			List<ArticleMedical> articleMedicals, Bordereau bordereaux, Assure assure) {
		super();
		this.id = id;
		this.numBulletin = numBulletin;
		this.urlBulletin = urlBulletin;
		this.montantRembourse = montantRembourse;
		this.montantPharmacie = montantPharmacie;
		this.etat = etat;
		this.resultat = resultat;
		this.dateValidation = dateValidation;
		this.dateAffiliation = dateAffiliation;
		this.dateSoin = dateSoin;
		this.active = active;
		this.articleMedicals = articleMedicals;
		this.bordereaux = bordereaux;
		this.assure = assure;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getNumBulletin() {
		return numBulletin;
	}


	public void setNumBulletin(Long numBulletin) {
		this.numBulletin = numBulletin;
	}


	public String getUrlBulletin() {
		return urlBulletin;
	}


	public void setUrlBulletin(String urlBulletin) {
		this.urlBulletin = urlBulletin;
	}


	public float getMontantRembourse() {
		return montantRembourse;
	}


	public void setMontantRembourse(float montantRembourse) {
		this.montantRembourse = montantRembourse;
	}


	public float getMontantPharmacie() {
		return montantPharmacie;
	}


	public void setMontantPharmacie(float montantPharmacie) {
		this.montantPharmacie = montantPharmacie;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	public String getResultat() {
		return resultat;
	}


	public void setResultat(String resultat) {
		this.resultat = resultat;
	}


	public Date getDateValidation() {
		return dateValidation;
	}


	public void setDateValidation(Date dateValidation) {
		this.dateValidation = dateValidation;
	}


	public Date getDateAffiliation() {
		return dateAffiliation;
	}


	public void setDateAffiliation(Date dateAffiliation) {
		this.dateAffiliation = dateAffiliation;
	}


	public Date getDateSoin() {
		return dateSoin;
	}


	public void setDateSoin(Date dateSoin) {
		this.dateSoin = dateSoin;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public List<ArticleMedical> getArticleMedicals() {
		return articleMedicals;
	}


	public void setArticleMedicals(List<ArticleMedical> articleMedicals) {
		this.articleMedicals = articleMedicals;
	}


	public Bordereau getBordereaux() {
		return bordereaux;
	}


	public void setBordereaux(Bordereau bordereaux) {
		this.bordereaux = bordereaux;
	}


	public Assure getAssure() {
		return assure;
	}


	public void setAssure(Assure assure) {
		this.assure = assure;
	}


	





	

	
	
	
}
