package com.cynapsys.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ActeMedical {
@Id
@GeneratedValue
	private Long id;
	private float solde;
	
	



	public ActeMedical() {
		// TODO Auto-generated constructor stub
	}
	
	public ActeMedical(float solde) {
		super();
		this.solde = solde;
	}

	
	
}
