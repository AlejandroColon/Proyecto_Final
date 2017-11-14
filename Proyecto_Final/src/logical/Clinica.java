package logical;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Clinica {

	// ***********************************ATRIBUTOS********************************
	private ArrayList<Persona> misPersonas;
	private ArrayList<Consulta> misConsultas;
	private ArrayList<Vacuna> misVacunas;
	private ArrayList<Enfermedad> misEnfermedades;
	private static Clinica clinica = null;

	// ************************************CONSTRUCTOR*****************************
	public Clinica() {
		super();
		misPersonas = new ArrayList<>();
		misConsultas = new ArrayList<>();
		misVacunas = new ArrayList<>();
		misEnfermedades = new ArrayList<>();
	}

	// ****************************************GETS Y SETS*************************************
	public ArrayList<Persona> getMisPersonas() {
		return misPersonas;
	}

	public void setMisPersonas(ArrayList<Persona> misPersonas) {
		this.misPersonas = misPersonas;
	}

	public ArrayList<Consulta> getMisConsultas() {
		return misConsultas;
	}

	public void setMisConsultas(ArrayList<Consulta> misConsultas) {
		this.misConsultas = misConsultas;
	}

	public ArrayList<Vacuna> getMisVacunas() {
		return misVacunas;
	}

	public void setMisVacunas(ArrayList<Vacuna> misVacunas) {
		this.misVacunas = misVacunas;
	}

	public ArrayList<Enfermedad> getMisEnfermedades() {
		return misEnfermedades;
	}

	public void setMisEnfermedades(ArrayList<Enfermedad> misEnfermedades) {
		this.misEnfermedades = misEnfermedades;
	}

	// ***************************************METODOS*******************************
	public void salvarPersonas() throws IOException{
		FileOutputStream f= new FileOutputStream("Personas.dat"); //Creando el archivo que almacenara las personas.
		ObjectOutputStream per = new ObjectOutputStream(f);
		
		for(Persona gente: misPersonas) {    //aqui recorro el array de personas para copiarlas al archivo.
			per.writeObject(gente);
		}
		
		f.close();
	}
	public static Clinica getInstance() {
		if (clinica == null) {
			clinica = new Clinica();
		}
		return clinica;
	}

	public void addPersona(Persona p) {
		misPersonas.add(p);
	}

	public void addConsulta(Consulta c) {
		misConsultas.add(c);
	}

	public void addEnfermedades(Enfermedad e) {
		misEnfermedades.add(e);
	}

	public void addVacunas(Vacuna c) {
		misVacunas.add(c);
	}

}

/*
 * Creado por: Alejandro Colón
 * Fecha:
 * Anotaciones:
 * 
 * 
 * Modificacion: Alejandro Colón
 * Fecha: 13/11/17
 * Anotaciones: codificacion de instancia "Singleton"
 * 
 * Modificacion: Oscar Rodriguez
 * Fecha: 13/11/17
 * Anotaciones: Se creo el metodo salvarPersonas() para crear un archivo
 * 
 * */
