package com.cynapsys.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Societe implements Serializable{
	@Id
	@GeneratedValue
	private Long idSociete;
	private String name;
	private String address;
	private Long telephone;

	@OneToMany(mappedBy="societe")
	private List<AssuranceEmploye> assuranceEmployes;
	
	
	
	
	public List<AssuranceEmploye> getAssuranceEmployes() {
		return assuranceEmployes;
	}
	public void setAssuranceEmployes(List<AssuranceEmploye> assuranceEmployes) {
		this.assuranceEmployes = assuranceEmployes;
	}
	public Long getIdSociete() {
		return idSociete;
	}
	public void setIdSociete(Long id) {
		this.idSociete = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getTelephone() {
		return telephone;
	}
	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}
	public Societe(String name, String address, Long telephone) {
		super();
		this.name = name;
		this.address = address;
		this.telephone = telephone;
	}
	public Societe() {
		// TODO Auto-generated constructor stub
	}
	
	
}
