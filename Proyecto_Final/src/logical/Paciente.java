package logical;

import java.util.Date;

public class Paciente extends Persona {
	
	/***********************************ATRIBUTOS DE LA CLASE****************************************/
	
	private Date fechaIngreso;
	private String aseguradora;
	private String numeroSS;
	private Doctor doc;
	private HistorialClinico hist;
	
	/**********************************CONSTRUCTOR DE LA CLASE***************************************/
	
	public Paciente(String cedula, String nombre, int edad, String telefono, String direccion, String sexo, Date fechaIngreso,
			String aseguradora, String numeroSS) {
		super(cedula, nombre, edad, telefono, direccion, sexo);
		this.fechaIngreso = fechaIngreso;
		this.aseguradora = aseguradora;
		this.numeroSS = numeroSS;
	}
	
	
	/***************************************SETS Y GETS**********************************************/
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getAseguradora() {
		return aseguradora;
	}
	public void setAseguradora(String aseguradora) {
		this.aseguradora = aseguradora;
	}
	public String getNumeroSS() {
		return numeroSS;
	}
	public void setNumeroSS(String numeroSS) {
		this.numeroSS = numeroSS;
	}


	public Doctor getDoc() {
		return doc;
	}


	public void setDoc(Doctor doc) {
		this.doc = doc;
	}


	public HistorialClinico getHist() {
		return hist;
	}


	public void setHist(HistorialClinico hist) {
		this.hist = hist;
	}

}
