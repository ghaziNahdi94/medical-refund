package com.cynapsys.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AssuranceRespSociete extends AssuranceUser  {

	private Date date;
	@ManyToOne
	@JoinColumn(name="idRole")
	private Role role;
	public AssuranceRespSociete() {
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
	public AssuranceRespSociete(Long cin, Long registrationNumber, String name, String firstName,
			Situation familySituation, String spouceName, String address, Date subscriptionDate, String email,
			String cnamSector, String cnamAffiliation, String urlAffiliationFile, Date birthday, String password,
			float salary, boolean active) {
		super(cin, registrationNumber, name, firstName, familySituation, spouceName, address, subscriptionDate, email,
=======
	public AssuranceRespSociete(Long cin, Long registrationNumber, String name,
			Situation familySituation, String spouceName, String address, Date subscriptionDate, String email,
			String cnamSector, String cnamAffiliation, String urlAffiliationFile, Date birthday, String password,
			float salary, boolean active) {
		super(cin, registrationNumber, name, familySituation, spouceName, address, subscriptionDate, email,
>>>>>>> ff269941494f2cfaed75d82410247e73dbf3b8a2
				cnamSector, cnamAffiliation, urlAffiliationFile, birthday, password, salary, active);
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
	public AssuranceRespSociete(Long cin, Long registrationNumber, String name, String firstName,
			Situation familySituation, String spouceName, String address, Date subscriptionDate, String email,
			String cnamSector, String cnamAffiliation, String urlAffiliationFile, Date birthday, String password,
			float salary, boolean active, Date date) {
		super(cin, registrationNumber, name, firstName, familySituation, spouceName, address, subscriptionDate, email,
=======
	public AssuranceRespSociete(Long cin, Long registrationNumber, String name,
			Situation familySituation, String spouceName, String address, Date subscriptionDate, String email,
			String cnamSector, String cnamAffiliation, String urlAffiliationFile, Date birthday, String password,
			float salary, boolean active, Date date) {
		super(cin, registrationNumber, name,  familySituation, spouceName, address, subscriptionDate, email,
>>>>>>> ff269941494f2cfaed75d82410247e73dbf3b8a2
				cnamSector, cnamAffiliation, urlAffiliationFile, birthday, password, salary, active);
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
