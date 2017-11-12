package logical;

public abstract class Control {

	//***********************Atributos********************************
	protected String codigo;
	protected String nombre;
	protected String descripcion;
	//************************Constructor****************************
	public Control(String codigo, String nombre, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
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
		return descripcion;
	}
	public void setDescricion(String descricion) {
		this.descripcion = descricion;
	}
	//*******************************Metodos************************
	
}





/*
 * Creado por: Alejandro Col�n
 * Fecha:12/11/17
 * Anotaciones:
 * 
 * */
