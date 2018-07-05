package com.cynapsys.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class CareBulletin implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idCareBulletin;
	private Long cin;
	private String urlBulletin;
	private float balanceRefounded;
	private String state;
	private String result;
	
	@OneToMany(mappedBy="careBulletins")
	private List<MedicalArticle> medicalArticles;
	
	@ManyToOne
	@JoinColumn(name="idBordereau")
	private Bordereau bordereaux;
	
	@ManyToOne
	@JoinColumn(name="idAssuranceEmploye")
	private AssuranceEmploye assuranceEmployes;
	
	public Long getIdCareBulletin() {
		return idCareBulletin;
	}
	public void setIdCareBulletin(Long id) {
		this.idCareBulletin = id;
	}
	public Long getCin() {
		return cin;
	}
	public void setCin(Long cin) {
		this.cin = cin;
	}
	public String getUrlBulletin() {
		return urlBulletin;
	}
	public void setUrlBulletin(String urlBulletin) {
		this.urlBulletin = urlBulletin;
	}
	public float getBalanceRefounded() {
		return balanceRefounded;
	}
	public void setBalanceRefounded(float balanceRefounded) {
		this.balanceRefounded = balanceRefounded;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public CareBulletin(Long cin, String urlBulletin, float balanceRefounded, String state, String result) {
		super();
		this.cin = cin;
		this.urlBulletin = urlBulletin;
		this.balanceRefounded = balanceRefounded;
		this.state = state;
		this.result = result;
	}
	public CareBulletin() {
		// TODO Auto-generated constructor stub
	}
	
	
}
