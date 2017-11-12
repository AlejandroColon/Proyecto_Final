package logical;

import java.util.ArrayList;

public class Clinica {
	
	/***********************************ATRIBUTOS DE LA CLASE********************************/
	private ArrayList<Persona> misPersonas;
	
	
	
	/************************************CONSTRUCTOR DE LA CLASE*****************************/
	public Clinica() {
		super();
		misPersonas = new ArrayList<>();
		
	}
	/****************************************GETS Y SETS*************************************/
	public ArrayList<Persona> getMisPersonas() {
		return misPersonas;
	}
	public void setMisPersonas(ArrayList<Persona> misPersonas) {
		this.misPersonas = misPersonas;
	}
	

	
	
}
