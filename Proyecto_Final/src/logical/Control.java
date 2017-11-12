package logical;

public abstract class Control {

	//***********************Atributos********************************
	protected String codigo;
	protected String nombre;
	protected String descricion;
	//************************Constructor****************************
	public Control(String codigo, String nombre, String descricion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descricion = descricion;
	}
	//*****************************Sets y Gets*********************
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescricion() {
		return descricion;
	}
	public void setDescricion(String descricion) {
		this.descricion = descricion;
	}
	//*******************************Metodos************************
	
}





/*
 * Creado por: Alejandro Colón
 * Fecha:12/11/17
 * Anotaciones:
 * 
 * */
