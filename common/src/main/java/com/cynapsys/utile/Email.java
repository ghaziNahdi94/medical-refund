package com.cynapsys.utile;

public class Email {

	private String objet;
	private String msg;
	private String from;
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

	
	
}
