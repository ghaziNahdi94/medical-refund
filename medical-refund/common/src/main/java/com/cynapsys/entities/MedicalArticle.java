package com.cynapsys.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class MedicalArticle implements Serializable {
	@Id
	@GeneratedValue
	private Long idMedicalArticle;
	private String urlFile;
	
	@ManyToOne
	@JoinColumn(name="idCareBulletin")
	private CareBulletin careBulletins;
	
	public Long getIdMedicalArticle() {
		return idMedicalArticle;
	}
	public void setIdMedicalArticle(Long id) {
		this.idMedicalArticle = id;
	}
	public String getUrlFile() {
		return urlFile;
	}
	public void setUrlFile(String urlFile) {
		this.urlFile = urlFile;
	}
	public MedicalArticle(String urlFile) {
		super();
		this.urlFile = urlFile;
	}
	public MedicalArticle() {
		// TODO Auto-generated constructor stub
	}
	
	
}
