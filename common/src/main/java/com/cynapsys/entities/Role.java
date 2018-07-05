package com.cynapsys.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Role implements Serializable{
	@Id
	@GeneratedValue
	private Long idRole;
	private String poste;
	private Long plafond;
	
	@OneToMany(mappedBy="role")
	private List<AssuranceEmploye> assuranceEmployes;
	@OneToMany(mappedBy="role")
	private List<AssuranceRespGAT> assuranceRespgats;
	@OneToMany(mappedBy="role")
	private List<AssuranceRespSociete> assuranceRespSocietes;

	
	
	

	
	
	
	
	public List<AssuranceEmploye> getAssuranceEmployes() {
		return assuranceEmployes;
	}
	public void setAssuranceEmployes(List<AssuranceEmploye> assuranceEmployes) {
		this.assuranceEmployes = assuranceEmployes;
	}
	public List<AssuranceRespGAT> getAssuranceRespgats() {
		return assuranceRespgats;
	}
	public void setAssuranceRespgats(List<AssuranceRespGAT> assuranceRespgats) {
		this.assuranceRespgats = assuranceRespgats;
	}
	public List<AssuranceRespSociete> getAssuranceRespSocietes() {
		return assuranceRespSocietes;
	}
	public void setAssuranceRespSocietes(List<AssuranceRespSociete> assuranceRespSocietes) {
		this.assuranceRespSocietes = assuranceRespSocietes;
	}
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long id) {
		this.idRole = id;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public Long getPlafond() {
		return plafond;
	}
	public void setPlafond(Long plafond) {
		this.plafond = plafond;
	}
	
	
	
	
	public Role(String poste, Long plafond) {
		super();
		this.poste = poste;
		this.plafond = plafond;
	}
	public Role() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
