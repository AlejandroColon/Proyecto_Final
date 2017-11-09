package logical;

import java.util.ArrayList;

public class Clinica {
	
	/***********************************ATRIBUTOS DE LA CLASE********************************/
	private ArrayList<Persona> misPersonas;
	private ArrayList<HistorialClinico> misHist;
	
	
	/************************************CONSTRUCTOR DE LA CLASE*****************************/
	public Clinica() {
		super();
		misPersonas = new ArrayList<>();
		misHist = new ArrayList<>();
	}
	/****************************************GETS Y SETS*************************************/
	public ArrayList<Persona> getMisPersonas() {
		return misPersonas;
	}
	public void setMisPersonas(ArrayList<Persona> misPersonas) {
		this.misPersonas = misPersonas;
	}
	public ArrayList<HistorialClinico> getMisHist() {
		return misHist;
	}
	public void setMisHist(ArrayList<HistorialClinico> misHist) {
		this.misHist = misHist;
	}

	
	
}
