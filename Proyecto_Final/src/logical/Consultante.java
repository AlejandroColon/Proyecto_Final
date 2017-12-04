package logical;

import java.io.Serializable;

public class Consultante extends Persona implements Serializable{
	
	//**************************************ATRIBUTOS DE LA CLASE************************************************
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -926983007045176977L;

	//**************************************CONSTRUCTOR DE LA CLASE**********************************************
	public Consultante(String cedula, String nombre, String fechaNacimiento, String telefono, String direccion,
			String sexo) {
		super(cedula, nombre, fechaNacimiento, telefono, direccion, sexo);
		
	}
	
	//*********************************************SETS Y GETS***************************************************
	
	//***********************************************METODOS*****************************************************

}

/*
 * 
 * Creado Por: Oscar Rodriguez.
 * Fecha: 12/11/17
 * Anotaciones:
 * 
 * 
 * Modificado: Alejandro Colón
 * Fecha:12/11/17
 * Anotaciones: eliminacion del parametro apellido
 * 
 * 
 * Modificado: Alejandro Colón
 * Fecha:27/11/17: 
 * anotaciones: eliminacion del arraylsit de vacunas y enfermedades,
 * ya que es un parametreo solo de paciente
 * 
 */
