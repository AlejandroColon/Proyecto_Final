package logical;

import java.io.Serializable;
import java.util.ArrayList;

public class Paciente extends Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1281050099341321750L;
	// **************************************ATRIBUTOS DE LA CLASE************************************************
	private String numeroAfiliado;
	private String aseguradora;
	private String tipoSangre;
	private ArrayList<Vacuna> misVacunas;// Luego de subir, cambiar a clase Vacuna
	private ArrayList<Historial> miHistorial;// Luego de subir, cambiar a clase Historial.

	// **************************************CONSTRUCTOR DE LA CLASE**********************************************
	public Paciente(String cedula, String nombre, int edad, String tipoSangre, String telefono, String direccion,
			String sexo, String numeroAfiliado, String aseguradora) {
		super(cedula, nombre, edad, telefono, direccion, sexo);
		misVacunas = new ArrayList<>();
		miHistorial = new ArrayList<>();
		this.numeroAfiliado = numeroAfiliado;
		this.tipoSangre = tipoSangre;
		this.aseguradora = aseguradora;
	}

	// *********************************************SETS Y GETS***************************************************
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

	public String getNumeroAfiliado() {
		return numeroAfiliado;
	}

	public void setNumeroAfiliado(String numeroAfiliado) {
		this.numeroAfiliado = numeroAfiliado;
	}

	public String getAseguradora() {
		return aseguradora;
	}

	public void setAseguradora(String aseguradora) {
		this.aseguradora = aseguradora;
	}

	public String getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
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
 * 
 *  Modificado: Alejandro Colón
 * Fecha:30/11/17
 * Anotaciones: agregar aseguradora, tipo de sandre
 */
