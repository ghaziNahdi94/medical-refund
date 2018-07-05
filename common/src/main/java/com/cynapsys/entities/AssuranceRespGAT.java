package com.cynapsys.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class AssuranceRespGAT extends AssuranceUser {
	@ManyToOne
	@JoinColumn(name="idRole")
	private Role role;
	public AssuranceRespGAT() {
		// TODO Auto-generated constructor stub
	}

	public AssuranceRespGAT(Long cin, Long registrationNumber, String name, Situation familySituation,
			String spouceName, String address, Date subscriptionDate, String email, String cnamSector,
			String cnamAffiliation, String urlAffiliationFile, Date birthday, String password, float salary,
			boolean active) {
		super(cin, registrationNumber, name,  familySituation, spouceName, address, subscriptionDate, email,
				cnamSector, cnamAffiliation, urlAffiliationFile, birthday, password, salary, active);
		// TODO Auto-generated constructor stub
	}

}
