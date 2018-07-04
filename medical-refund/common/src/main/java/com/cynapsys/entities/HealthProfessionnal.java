package com.cynapsys.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class HealthProfessionnal implements Serializable {
	@Id
	@GeneratedValue	
	private Long idHealthProfessionnal;
	private String centerName;
	private String address;
	private String type;
	private boolean active;
	@Enumerated(EnumType.STRING)
	private Specialite specialite;
	
	
	public Long getIdHealthProfessionnal() {
		return idHealthProfessionnal;
	}
	public void setIdHealthProfessionnal(Long id) {
		this.idHealthProfessionnal = id;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public HealthProfessionnal(String centerName, String address, String type, boolean active) {
		super();
		this.centerName = centerName;
		this.address = address;
		this.type = type;
		this.active = active;
	}
	public HealthProfessionnal() {
		// TODO Auto-generated constructor stub
	}
	
}
