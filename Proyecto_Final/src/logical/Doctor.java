package logical;

import java.io.Serializable;

public class Doctor extends Trabajador implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 655100937815671529L;
	//******************************************ATRIBUTOS*******************************************
	private String exequatur;
	private String especialidad;
	private int citasXdia;
	
	//***********************************CONSTRUCTOR DE LA CLASE************************************
	public Doctor(String cedula, String nombre, int edad, String telefono, String direccion,
			String sexo, String usuario, String password, String exequatur, String especialidad, int citasXdia) {
		super(cedula, nombre, edad, telefono, direccion, sexo, usuario, password);
		this.exequatur = exequatur;
		this.especialidad = especialidad;
		this.citasXdia = citasXdia;
	}
	//****************************************GETS Y SETS*******************************************
	public String getCodigo() {
		return exequatur;
	}
	
	public void setCodigo(String codigo) {
		this.exequatur = codigo;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public int getCitasXdia() {
		return citasXdia;
	}

	public void setCitasXdia(int citasXdia) {
		this.citasXdia = citasXdia;
	}
	
	//*******************************************METODOS***********************************************

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
