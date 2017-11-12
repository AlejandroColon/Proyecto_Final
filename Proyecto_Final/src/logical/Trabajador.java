package logical;

public abstract class Trabajador extends Persona {
	
	//*******************************************ATRIBUTOS DE LA CLASE*******************************************
	protected String usuario;
	protected String password;
	
	//********************************************CONSTRUCTOR DE LA CLASE****************************************
	public Trabajador(String cedula, String nombre, String apellido, int edad, String telefono, String direccion,
			String sexo, String usuario, String password) {
		super(cedula, nombre, apellido, edad, telefono, direccion, sexo);
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
	/*
	 * CREADO POR:
	 * 				Oscar Rodriguez.
	 * 				12/11/2017
	 * 
	 */

}
