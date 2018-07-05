package com.cynapsys.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ActMedical {
@Id
@GeneratedValue
	private Long idActMedical;
	private float somme;
	
	

	
	
	public Long getIdActMedical() {
		return idActMedical;
	}
	public void setIdActMedical(Long id) {
		this.idActMedical = id;
	}
	public float getSomme() {
		return somme;
	}
	public void setSomme(float somme) {
		this.somme = somme;
	}
	public ActMedical(float somme) {
		super();
		this.somme = somme;
	}
	public ActMedical() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
