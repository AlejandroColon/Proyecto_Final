package logical;

import java.util.ArrayList;

public class Consultante extends Persona {
	
	//**************************************ATRIBUTOS DE LA CLASE************************************************
	private ArrayList<Vacuna> misVacunas;
	private ArrayList<Historial> miHistorial;
	
	//**************************************CONSTRUCTOR DE LA CLASE**********************************************
	public Consultante(String cedula, String nombre, String apellido, int edad, String telefono, String direccion,
			String sexo) {
		super(cedula, nombre, apellido, edad, telefono, direccion, sexo);
		misVacunas = new ArrayList<>();
		miHistorial = new ArrayList<>();
	}
	
	//*********************************************SETS Y GETS***************************************************
	public ArrayList<Vacuna> getMisVacunas() {
		return misVacunas;
	}

	public void setMisVacunas(ArrayList<Vacuna> misVacunas) {
		this.misVacunas = misVacunas;
	}

	public ArrayList<Historial> getMiHistorial() {
		return miHistorial;
	}

	public void setMiHistorial(ArrayList<Historial> miHistorial) {
		this.miHistorial = miHistorial;
	}
	
	//***********************************************METODOS*****************************************************

}

/*
 * CREADO POR:
 * 				Oscar Rodriguez.
 * 				12/11/2017
 * 
 * */
