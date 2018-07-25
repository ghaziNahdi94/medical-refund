package com.cynapsys.utile;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Email implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	private Date dateReclamation;
	
	private String objet;
	private String msg;
	
	@Column(name="emetteur")
	private String from;
	
	@Column(name="recepteur")
	private String to;
	
	public Email() {}

	public Email(String objet, String msg, String from, String to) {
		super();
		this.objet = objet;
		this.msg = msg;
		this.from = from;
		this.to = to;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateReclamation() {
		return dateReclamation;
	}

	public void setDateReclamation(Date dateReclamation) {
		this.dateReclamation = dateReclamation;
	}

	
	
}
