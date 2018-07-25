package com.cynapsys.controllers;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Parametres implements Serializable{


	@Id
	private int id;
	
	@ElementCollection(targetClass=String.class)
	private List<String> datesEnvoi;

	
	
	public Parametres() {}
	
	
	public Parametres(int id, List<String> datesEnvoi) {
		super();
		this.id = id;
		this.datesEnvoi = datesEnvoi;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<String> getDatesEnvoi() {
		return datesEnvoi;
	}


	public void setDatesEnvoi(List<String> datesEnvoi) {
		this.datesEnvoi = datesEnvoi;
	}



	
	
	
	
}
