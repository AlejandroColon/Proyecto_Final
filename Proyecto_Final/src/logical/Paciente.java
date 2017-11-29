package logical;

import java.util.ArrayList;

public class Paciente extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1281050099341321750L;
	// **************************************ATRIBUTOS DE LA CLASE************************************************
	private String numeroAfiliado;
	private ArrayList<String> misVacunas;// Luego de subir, cambiar a clase Vacuna
	private ArrayList<String> miHistorial;// Luego de subir, cambiar a clase Historial.

	// **************************************CONSTRUCTOR DE LA CLASE**********************************************
	public Paciente(String cedula, String nombre, int edad, String telefono, String direccion,
			String sexo, String numeroAfiliado) {
		super(cedula, nombre, edad, telefono, direccion, sexo);
		misVacunas = new ArrayList<>();
		miHistorial = new ArrayList<>();
		this.numeroAfiliado = numeroAfiliado;
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

	public String getNumeroAfiliado() {
		return numeroAfiliado;
	}

	public void setNumeroAfiliado(String numeroAfiliado) {
		this.numeroAfiliado = numeroAfiliado;
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
 * 
 * Modificado: Alejandro Colón
 * Fecha:27/11/17
 * Anotaciones: agregar numero afiliado
 */
