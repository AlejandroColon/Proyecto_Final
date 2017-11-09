package logical;

public class Doctor extends Persona {
	
	/******************************************ATRIBUTOS*******************************************/
	private String codigo;
	private String especialidad;
	
	/***********************************CONSTRUCTOR DE LA CLASE************************************/
	public Doctor(String cedula, String nombre, int edad, String telefono, String direccion, String sexo, String codigo,
			String especialidad) {
		super(cedula, nombre, edad, telefono, direccion, sexo);
		this.codigo = codigo;
		this.especialidad = especialidad;
	}
	
	/****************************************GETS Y SETS*******************************************/
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	

}
