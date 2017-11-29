package logical;

import java.io.Serializable;

public class Historial extends InfoClinica implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6069021962541681501L;

	// ********************************ATRIBUTOS*****************************

	// *******************************CONSTRUCTOR****************************

	public Historial(String codigo, String fecha, String sintomas, String diagnostico, String tratamiento,
			Enfermedad enfermedad) {
		super(codigo, fecha, sintomas, diagnostico, tratamiento, enfermedad);

	}

	// ****************************GETTERS AND SETTERS***********************

	// ******************************METODOS*********************************

}

/*
 * Creado por: Yamilka 12/11/17
 */
