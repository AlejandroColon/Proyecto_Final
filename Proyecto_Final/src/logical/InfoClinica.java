package logical;

import java.io.Serializable;

public abstract class InfoClinica implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1495026567206777360L;
	// *****************************ATRIBUTOS****************************
	private String codigo;
	private String fecha; // más adelante se determinará si debe ser date o no
	private String sintomas;
	private String diagnostico;
	private String tratamiento;
	private Enfermedad enfermedad;// cuando Ale suba la clase enfermedad se va cambiar de String a Enfermedad

	// ****************************CONSTRUCTOR************************

	public InfoClinica(String codigo, String fecha, String sintomas, String diagnostico, String tratamiento,
			Enfermedad enfermedad) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.sintomas = sintomas;
		this.diagnostico = diagnostico;
		this.tratamiento = tratamiento;
		this.enfermedad = enfermedad;
	}

	// ****************************GETTERS AND SETTERS*******************

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public Enfermedad getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(Enfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}

	

	// *****************************METODOS*******************************

}
/*
 * Creado por: Yamilka 12/11/17
 */
