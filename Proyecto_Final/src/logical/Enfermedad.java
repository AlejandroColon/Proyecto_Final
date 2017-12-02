package logical;

import java.io.Serializable;

public class Enfermedad extends Control implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5650943839921258950L;

	//**************************Atributos*******************
	private boolean estado = true;
	
	//*****************************Constructor********************
	public Enfermedad(String codigo, String nombre, String descripcion) {
		super(codigo, nombre, descripcion);
		// TODO Auto-generated constructor stub
	}
	//******************************Sets y Gets*******************************

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	//*****************************Metodos*******************************
}



/*
 * Creado por: Alejandro Colón
 * Fecha:12/11/17
 * Anotaciones:
 * 
 * */