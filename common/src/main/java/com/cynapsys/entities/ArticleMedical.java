package com.cynapsys.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class ArticleMedical implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String urlFichier;
	private String libelle;
	private String description;
	private float prix;
	private int quantite;
	private boolean active;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="idBulletinSoin")
	private BulletinSoin bulletinSoin;
	

	public ArticleMedical() {
		// TODO Auto-generated constructor stub
	}


	public ArticleMedical(Long id, String urlFichier, String libelle, String description, float prix, int quantite,
			BulletinSoin bulletinSoin, boolean active) {
		
		this.id = id;
		this.urlFichier = urlFichier;
		this.libelle = libelle;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.bulletinSoin = bulletinSoin;
		this.active = active;
		
	}


	public String getUrlFichier() {
		return urlFichier;
	}


	public void setUrlFichier(String urlFichier) {
		this.urlFichier = urlFichier;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public float getPrix() {
		return prix;
	}


	public void setPrix(float prix) {
		this.prix = prix;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public BulletinSoin getBulletinSoin() {
		return bulletinSoin;
	}


	public void setBulletinSoin(BulletinSoin bulletinSoin) {
		this.bulletinSoin = bulletinSoin;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	
}
