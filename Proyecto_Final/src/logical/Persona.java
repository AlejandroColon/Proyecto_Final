package logical;

public abstract class Persona {
	
	//**************************************ATRIBUTOS DE LA CLASE***********************************************
	
	protected String cedula;
	protected String nombre;
	protected String apellido;
	protected int edad;
	protected String telefono;
	protected String direccion;
	protected String sexo;
	
	//************************************** CONSTRUCTOR DE LA CLASE********************************************
	
	public Persona(String cedula, String nombre,String apellido, int edad, String telefono, String direccion, String sexo) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
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


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
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
 * CREADO POR:
 * 				Oscar Rodriguez.
 * 				12/11/2017
 * 
 */
