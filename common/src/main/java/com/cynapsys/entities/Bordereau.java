package com.cynapsys.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Bordereau implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private Date dateEnvoi;
	

	
	
	public Bordereau() {
		// TODO Auto-generated constructor stub
	}




	public Bordereau(Long id, Date dateEnvoi) {
		super();
		this.id = id;
		this.dateEnvoi = dateEnvoi;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Date getDateEnvoi() {
		return dateEnvoi;
	}




	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}


	
	
	
	
}
