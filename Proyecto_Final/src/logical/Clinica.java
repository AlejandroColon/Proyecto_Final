package logical;

import java.util.ArrayList;

public class Clinica {
	
	//***********************************ATRIBUTOS********************************
	private ArrayList<Persona> misPersonas;
	
	
	
	//************************************CONSTRUCTOR*****************************
	public Clinica() {
		super();
		misPersonas = new ArrayList<>();
		
	}
	//****************************************GETS Y SETS*************************************
	public ArrayList<Persona> getMisPersonas() {
		return misPersonas;
	}
	public void setMisPersonas(ArrayList<Persona> misPersonas) {
		this.misPersonas = misPersonas;
	}
	//***************************************METODOS*******************************
	

	
	
}
