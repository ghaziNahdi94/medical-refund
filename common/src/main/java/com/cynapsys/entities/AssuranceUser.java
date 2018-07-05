package com.cynapsys.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class AssuranceUser implements Serializable {
	
	@Id
	@GeneratedValue
	private Long idAssuranceUser;
	private Long cin;
	private Long registrationNumber;
	private String name;
	@Enumerated(EnumType.STRING)
	private Situation familySituation;
	private String spouceName;
	private String address;
	//private Date subscriptionDate;
	private String email;
	private String cnamSector;
	private String cnamAffiliation;
	private String urlAffiliationFile;
	private Date birthday;
	private String password;
	private float salary;
	private boolean active;
	

	
	public Long getIdAssuranceUser() {
		return idAssuranceUser;
	}
	public void setIdAssuranceUser(Long id) {
		this.idAssuranceUser = id;
	}
	public Long getCin() {
		return cin;
	}
	public void setCin(Long cin) {
		this.cin = cin;
	}
	public Long getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(Long registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Situation getFamilySituation() {
		return familySituation;
	}
	public void setFamilySituation(Situation familySituation) {
		this.familySituation = familySituation;
	}
	public String getSpouceName() {
		return spouceName;
	}
	public void setSpouceName(String spouceName) {
		this.spouceName = spouceName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCnamSector() {
		return cnamSector;
	}
	public void setCnamSector(String cnamSector) {
		this.cnamSector = cnamSector;
	}
	public String getCnamAffiliation() {
		return cnamAffiliation;
	}
	public void setCnamAffiliation(String cnamAffiliation) {
		this.cnamAffiliation = cnamAffiliation;
	}
	public String getUrlAffiliationFile() {
		return urlAffiliationFile;
	}
	public void setUrlAffiliationFile(String urlAffiliationFile) {
		this.urlAffiliationFile = urlAffiliationFile;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public AssuranceUser(Long cin, Long registrationNumber, String name, Situation familySituation,
			String spouceName, String address, Date subscriptionDate, String email, String cnamSector,
			String cnamAffiliation, String urlAffiliationFile, Date birthday, String password, float salary,
			boolean active) {
		this.cin = cin;
		this.registrationNumber = registrationNumber;
		this.name = name;
		this.familySituation = familySituation;
		this.spouceName = spouceName;
		this.address = address;
		this.email = email;
		this.cnamSector = cnamSector;
		this.cnamAffiliation = cnamAffiliation;
		this.urlAffiliationFile = urlAffiliationFile;
		this.birthday = birthday;
		this.password = password;
		this.salary = salary;
		this.active = active;
	}
	public AssuranceUser() {
	}
	public AssuranceUser(Long id, String n) {
	this.idAssuranceUser = id;
	this.name=n;
	}
	}
