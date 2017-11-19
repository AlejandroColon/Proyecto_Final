package logical;

public class Consulta extends InfoClinica {

	// ********************************ATRIBUTOS******************************
	private Paciente paciente;
	// ******************************CONSTRUCTOR******************************

	public Consulta(String codigo, String fecha, String sintomas, String diagnostico, String tratamiento,
			Enfermedad enfermedad, Paciente paciente) {
		super(codigo, fecha, sintomas, diagnostico, tratamiento, enfermedad);
		this.paciente = paciente;
	}

	
	// ***************************GETTERS AND SETTERS*************************
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	// ***************************METODOS*************************************

}

/*
 * Creado por: Yamilka 12/11/17
 */
