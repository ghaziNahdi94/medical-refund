package com.cynapsys.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Bordereau implements Serializable {

	@Id
	@GeneratedValue
	private Long idBordereau;
	private String code;
	private String state;
	private Date date;
	@OneToMany(mappedBy="bordereaux")
	private List<CareBulletin> careBulletin;
	
	public Long getIdBordereau() {
		return idBordereau;
	}
	public void setIdBordereau(Long id) {
		this.idBordereau = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Bordereau(String code, String state, Date date) {
		super();
		this.code = code;
		this.state = state;
		this.date = date;
	}
	public Bordereau() {
		// TODO Auto-generated constructor stub
	}
	
	
}
