package logical;

import java.io.Serializable;

public abstract class Persona implements Serializable{
	
	//**************************************ATRIBUTOS DE LA CLASE***********************************************
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7041660825441736841L;
	protected String cedula;
	protected String nombre;
	protected String fechaNacimiento;
	protected String telefono;
	protected String direccion;
	protected String sexo;
	
	//************************************** CONSTRUCTOR DE LA CLASE********************************************
	
	public Persona(String cedula, String nombre, String fechaNacimiento, String telefono, String direccion, String sexo) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.sexo = sexo;
	}
	
	
	//********************************************* GETS Y SETS ************************************************
	public String getCedula() {
		return cedula;
	}
	
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	//*******************************************************METODOS***********************************************

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
