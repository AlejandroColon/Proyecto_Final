package logical;

import java.util.ArrayList;

public class Paciente extends Persona {

	// **************************************ATRIBUTOS DE LA CLASE************************************************
	private ArrayList<String> misVacunas;// Luego de subir, cambiar a clase Vacuna
	private ArrayList<String> miHistorial;// Luego de subir, cambiar a clase Historial.

	// **************************************CONSTRUCTOR DE LA CLASE**********************************************
	public Paciente(String cedula, String nombre, int edad, String telefono, String direccion,
			String sexo) {
		super(cedula, nombre, edad, telefono, direccion, sexo);
		misVacunas = new ArrayList<>();
		miHistorial = new ArrayList<>();
	}

	// *********************************************SETS Y GETS***************************************************
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

	// ***********************************************METODOS*****************************************************

}

/*
 * 
 * Creado Por: Oscar Rodriguez.
 * Fecha: 12/11/17
 * Anotaciones:
 * 
 * Modificado: Alejandro Colón
 * Fecha:12/11/17
 * Anotaciones: eliminacion del parametro apellido
 */
