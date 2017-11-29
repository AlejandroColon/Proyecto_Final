package logical;

import java.io.Serializable;

public class Administrativo extends Trabajador implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2028985840255312992L;

	//*************************************CONSTRUCTOR DE LA CLASE**************************************************
	public Administrativo(String cedula, String nombre, int edad, String telefono, String direccion,
			String sexo, String usuario, String password) {
		super(cedula, nombre, edad, telefono, direccion, sexo, usuario, password);
		// TODO Auto-generated constructor stub
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
