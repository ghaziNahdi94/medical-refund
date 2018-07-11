package com.cynapsys.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Bordereau implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String code;
	private String etat;
	private Date dateEnvoi;
	@OneToMany(mappedBy="bordereaux")
	private List<BulletinSoin> bulletinSoin;
	
	
	public Bordereau() {
		// TODO Auto-generated constructor stub
	}


	public Bordereau(String code, String etat, Date dateEnvoi, List<BulletinSoin> bulletinSoin) {
		
		this.code = code;
		this.etat = etat;
		this.dateEnvoi = dateEnvoi;
		this.bulletinSoin = bulletinSoin;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	public Date getDateEnvoi() {
		return dateEnvoi;
	}


	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}


	public List<BulletinSoin> getBulletinSoin() {
		return bulletinSoin;
	}


	public void setBulletinSoin(List<BulletinSoin> bulletinSoin) {
		this.bulletinSoin = bulletinSoin;
	}
	
	
	
	
	
}
