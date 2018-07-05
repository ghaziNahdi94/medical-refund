package com.cynapsys.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class AssuranceEmploye extends AssuranceUser{
	
	
	private Date date;
	@ManyToOne
	@JoinColumn(name="idRole")
	private Role role;
	@ManyToOne
	@JoinColumn(name="idSociete")
	private Societe societe;

	@OneToMany(mappedBy="assuranceEmployes")
	private List<CareBulletin> careBulletins;
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AssuranceEmploye(Long cin, Long registrationNumber, String name, Situation familySituation,
			String spouceName, String address, Date subscriptionDate, String email, String cnamSector,
			String cnamAffiliation, String urlAffiliationFile, Date birthday, String password, float salary,
			boolean active, Date date) {
		super(cin, registrationNumber, name, familySituation, spouceName, address, subscriptionDate, email,
				cnamSector, cnamAffiliation, urlAffiliationFile, birthday, password, salary, active);
		this.date = date;
	}
	public AssuranceEmploye(Long id, String n) {
		super(id,n);
	}
	public AssuranceEmploye() {
		// TODO Auto-generated constructor stub
	}



	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public List<CareBulletin> getCareBulletins() {
		return careBulletins;
	}

	public void setCareBulletins(List<CareBulletin> careBulletins) {
		this.careBulletins = careBulletins;
	}

	
	
	
	
	

}

