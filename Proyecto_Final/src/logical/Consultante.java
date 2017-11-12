package logical;

import java.util.ArrayList;

public class Consultante extends Persona {
	
	//**************************************ATRIBUTOS DE LA CLASE************************************************
	private ArrayList<String> misVacunas;//Luego de subir, cambiar a clase Vacuna
	private ArrayList<String> miHistorial;//Luego de subir, cambiar a clase Historial.
	
	//**************************************CONSTRUCTOR DE LA CLASE**********************************************
	public Consultante(String cedula, String nombre, String apellido, int edad, String telefono, String direccion,
			String sexo) {
		super(cedula, nombre, apellido, edad, telefono, direccion, sexo);
		misVacunas = new ArrayList<>();
		miHistorial = new ArrayList<>();
	}
	
	//*********************************************SETS Y GETS***************************************************
	public ArrayList<String> getMisVacunas() {
		return misVacunas;
	}

	public void setMisVacunas(ArrayList<String> misVacunas) {
		this.misVacunas = misVacunas;
	}

	public ArrayList<String> getMiHistorial() {
		return miHistorial;
	}

	public void setMiHistorial(ArrayList<String> miHistorial) {
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
