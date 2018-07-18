package com.cynapsys.entities;

import java.util.Date;

public class User {
private Long cin;
private String nom;
private String prenom;
private Date dateInscription;
private Role role;
public Long getCin() {
	return cin;
}
public void setCin(Long cin) {
	this.cin = cin;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public Date getDateInscription() {
	return dateInscription;
}
public void setDateInscription(Date dateInscription) {
	this.dateInscription = dateInscription;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
public User(Long cin, String nom, String prenom, Date dateInscription, Role role) {
	this.cin = cin;
	this.nom = nom;
	this.prenom = prenom;
	this.dateInscription = dateInscription;
	this.role = role;
}
public User() {
}


}
