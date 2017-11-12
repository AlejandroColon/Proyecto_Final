package logical;

public class Doctor extends Trabajador {
	
	//******************************************ATRIBUTOS*******************************************
	private String exequatur;
	private String especialidad;
	private int citasXdia;
	
	//***********************************CONSTRUCTOR DE LA CLASE************************************
	public Doctor(String cedula, String nombre, String apellido, int edad, String telefono, String direccion,
			String sexo, String usuario, String password, String exequatur, String especialidad, int citasXdia) {
		super(cedula, nombre, apellido, edad, telefono, direccion, sexo, usuario, password);
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
 * CREADO POR:
 * 				Oscar Rodriguez.
 * 				12/11/2017
 * */
