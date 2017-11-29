package logical;

import java.io.Serializable;

public abstract class Trabajador extends Persona implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6524013019595222580L;
	//*******************************************ATRIBUTOS DE LA CLASE*******************************************
	protected String usuario;
	protected String password;
	
	//********************************************CONSTRUCTOR DE LA CLASE****************************************
	public Trabajador(String cedula, String nombre, int edad, String telefono, String direccion,
			String sexo, String usuario, String password) {
		super(cedula, nombre, edad, telefono, direccion, sexo);
		this.usuario = usuario;
		this.password = password;
	}

	//*********************************************GETS Y SETS**************************************************
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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
