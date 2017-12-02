package logical;

import java.io.Serializable;

public class Cita implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5276687077784940601L;
	//*****************************Atributos******************
	private String id;
	private String fecha;
	private Doctor doctor;
	private Persona citado;
	private boolean estado = true;
	//******************************Constructor*************
	public Cita(String id, String fecha, Doctor doctor, Persona citado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.doctor = doctor;
		this.citado = citado;
	}
	//***************************Sets y Gets**********************
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Persona getCitado() {
		return citado;
	}
	public void setCitado(Persona citado) {
		this.citado = citado;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	///**********************Metodos****************


}




/*
 * Creado por: Alejandro Colón
 * Fecha:12/11/17
 * Anotaciones:
 * 
 * */
