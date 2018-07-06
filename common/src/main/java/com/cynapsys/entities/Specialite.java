package com.cynapsys.entities;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.sym.Name;

public enum Specialite {
	

	Angiologue,
	Cardiologue,
	Cancérologue,
	Dentiste,
	Dermatologue,
	Diabétologue,
	Gastro,
	Gynécologue,
	Neurologue,
	Ophtalmologiste,
	OtoRhinoLaryngologiste,
	Pneumologue,
	Pharmacien,
	Rhumatologue,
	Urologue;

	
	
	

	
	
	@JsonCreator
	public static Specialite fromValue(String value) {
		
		return getEnumfromString(value);
		}
	
	
	
	@JsonValue
	public  String toJson() {
		return this.name().toLowerCase();
	}
	
	
	
	
	
	
	public static Specialite getEnumfromString(String text) {
		
		Specialite s = null;
		
		if(text != null) {
			
			for(Specialite sp : values()) {
				if(text.equalsIgnoreCase(sp.toString())) {
					s = sp;
					break;
				}
			}
			
			
		}
		
		return s;
	}


}
