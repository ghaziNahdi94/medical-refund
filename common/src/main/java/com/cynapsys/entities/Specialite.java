package com.cynapsys.entities;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.sym.Name;

public enum Specialite {
	
=======
public enum Specialite {
>>>>>>> ff269941494f2cfaed75d82410247e73dbf3b8a2
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
<<<<<<< HEAD
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
=======
	Urologue
>>>>>>> ff269941494f2cfaed75d82410247e73dbf3b8a2
}
