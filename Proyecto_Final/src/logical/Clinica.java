package logical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class Clinica implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6706713879333725409L;
	// ***********************************ATRIBUTOS********************************
	private ArrayList<Persona> misPersonas;
	private ArrayList<Consulta> misConsultas;
	private ArrayList<Vacuna> misVacunas;
	private ArrayList<Enfermedad> misEnfermedades;
	private ArrayList<Cita> misCitas;
	private static Clinica clinica = null;
	
	//Archivos
	private String pathFilePersona = "misPersonas.dat";
	private File filePersona =  new File(pathFilePersona);
	private String pathFileVacuna = "misVacunas.dat";
	private File fileVacuna =  new File(pathFileVacuna);
	private String pathFileEnfermedad = "misEnfermedades.dat";
	private File fileEnfermedad =  new File(pathFileEnfermedad);
	private String pathFileCita = "misCitas.dat";
	private File fileCita =  new File(pathFileCita);
	private String pathFileConsulta = "misConsultas.dat";
	private File fileConsulta =  new File(pathFileConsulta);

	// ************************************CONSTRUCTOR*****************************
	public Clinica() {
		super();
		misPersonas = new ArrayList<>();
		misConsultas = new ArrayList<>();
		misEnfermedades = new ArrayList<>();
		misEnfermedades = new ArrayList<>();
		misCitas = new ArrayList<>();
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
	

	public ArrayList<Cita> getMisCitas() {
		return misCitas;
	}

	public void setMisCitas(ArrayList<Cita> misCitas) {
		this.misCitas = misCitas;
	}

	// ***************************************METODOS*******************************
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
	
	public void addCitas(Cita c) {
		misCitas.add(c);
	}
	
	public void salvarPersonas() throws IOException{
		FileOutputStream fPersona = new FileOutputStream(pathFilePersona);
		ObjectOutputStream writePersona = new ObjectOutputStream(fPersona);
		
		writePersona.writeInt(misPersonas.size());
		
		for(Persona aux : misPersonas) {    //aqui recorro el array de personas para copiarlas al archivo.
			writePersona.writeObject(aux);
		}
		writePersona.close();
	}
	
	public void leerPersonas() throws FileNotFoundException, IOException, ClassNotFoundException{
		if(filePersona.exists() == true){
			
			FileInputStream fPersona =  new FileInputStream(pathFilePersona);
			ObjectInputStream readPersona = new ObjectInputStream(fPersona);		
			
			int cantPersonas = readPersona.readInt();
			
			for(int i = 0; i < cantPersonas; i ++){
				misPersonas.add((Persona)readPersona.readObject());
			}
			readPersona.close();
		}	
	} 
	
	public void salvarVacunas() throws IOException{
		FileOutputStream fVacuna = new FileOutputStream(pathFilePersona);
		ObjectOutputStream writeVacuna = new ObjectOutputStream(fVacuna);
		
		writeVacuna.writeInt(misVacunas.size());
		
		for(Vacuna aux : misVacunas) {    //aqui recorro el array de personas para copiarlas al archivo.
			writeVacuna.writeObject(aux);
		}
		writeVacuna.close();
	}
	
	public void leerVacunas() throws FileNotFoundException, IOException, ClassNotFoundException{
		if(fileVacuna.exists() == true){
			
			FileInputStream fVacuna =  new FileInputStream(pathFilePersona);
			ObjectInputStream readVacuna = new ObjectInputStream(fVacuna);		
			
			int cantVacuna = readVacuna.readInt();
			
			for(int i = 0; i < cantVacuna; i ++){
				misVacunas.add((Vacuna) readVacuna.readObject());
			}
			readVacuna.close();
		}	
	} 
	
	public void salvarEnfermedades() throws IOException{
		FileOutputStream fEnfermedad = new FileOutputStream(pathFileEnfermedad);
		ObjectOutputStream writeEnfermedad = new ObjectOutputStream(fEnfermedad);
		
		writeEnfermedad.writeInt(misEnfermedades.size());
		
		for(Enfermedad aux : misEnfermedades) {    //aqui recorro el array de personas para copiarlas al archivo.
			writeEnfermedad.writeObject(aux);
		}
		
		writeEnfermedad.close();
	}
	
	public void leerEnfermedades() throws FileNotFoundException, IOException, ClassNotFoundException{
		if(fileEnfermedad.exists() == true){
			
			FileInputStream fEnfermedad =  new FileInputStream(pathFileEnfermedad);
			ObjectInputStream readEnfermedad = new ObjectInputStream(fEnfermedad);		
			
			int cantEnfermedades = readEnfermedad.readInt();
			
			for(int i = 0; i < cantEnfermedades; i ++){
				misEnfermedades.add((Enfermedad) readEnfermedad.readObject());
			}
			readEnfermedad.close();
		}	
	} 
	
	public void salvarConsultas() throws IOException{
		FileOutputStream fConsulta = new FileOutputStream(pathFileConsulta);
		ObjectOutputStream writeConsulta = new ObjectOutputStream(fConsulta);
		
		writeConsulta.writeInt(misConsultas.size());
		
		for(Consulta aux : misConsultas) {    //aqui recorro el array de personas para copiarlas al archivo.
			writeConsulta.writeObject(aux);
		}
		
		writeConsulta.close();
	}
	
	public void leerConsultas() throws FileNotFoundException, IOException, ClassNotFoundException{
		if(fileConsulta.exists() == true){
			
			FileInputStream fConsulta =  new FileInputStream(pathFileConsulta);
			ObjectInputStream readConsulta = new ObjectInputStream(fConsulta);		
			
			int cantConsultas = readConsulta.readInt();
			
			for(int i = 0; i < cantConsultas; i ++){
				misConsultas.add((Consulta) readConsulta.readObject());
			}
			readConsulta.close();
		}	
	} 
	
	public void salvarCitas() throws IOException{
		FileOutputStream fCita = new FileOutputStream(pathFileCita);
		ObjectOutputStream writeCita = new ObjectOutputStream(fCita);
		
		writeCita.writeInt(misCitas.size());
		
		for(Cita aux : misCitas) {    //aqui recorro el array de personas para copiarlas al archivo.
			writeCita.writeObject(aux);
		}
		
		fCita.close();
	}
	
	public void leerCitas() throws FileNotFoundException, IOException, ClassNotFoundException{
		if(fileCita.exists() == true){
			
			FileInputStream fCita =  new FileInputStream(pathFileCita);
			ObjectInputStream readCita = new ObjectInputStream(fCita);		
			
			int cantCita = readCita.readInt();
			
			for(int i = 0; i < cantCita; i ++){
				misCitas.add((Cita) readCita.readObject());
			}
			readCita.close();
		}	
	} 
	
	public Persona findByCedula(String cedula){
		Persona p =null;
		boolean encontrado = false;
		int i = 0;
		
		while(!encontrado && i <misPersonas.size()){
			if(misPersonas.get(i).getCedula().equalsIgnoreCase(cedula)){
				p = misPersonas.get(i);
				encontrado = true;
			}
			i++;
		}
		return p;
	}
	
	public Cita findCitaByID(String id){
		Cita c =null;
		boolean encontrado = false;
		int i = 0;
		
		while(!encontrado && i <misCitas.size()){
			if(misCitas.get(i).getId().equalsIgnoreCase(id)){
				c = misCitas.get(i);
				encontrado = true;
			}
			i++;
		}
		return c;
	}
	
	public Consulta findConsultaByCodigo(String codigo){
		Consulta c = null;
		boolean encontrado = false;
		int i = 0;
		
		while(!encontrado && i <misConsultas.size()){
			if(misConsultas.get(i).getCodigo().equalsIgnoreCase(codigo)){
				c = misConsultas.get(i);
				encontrado = true;
			}
			i++;
		}
		return c;
	}
	
	public Consulta findConsultaByCedula(String cedula){
		Consulta c = null;
		boolean encontrado = false;
		int i = 0;
		
		while(!encontrado && i <misConsultas.size()){
			if(misConsultas.get(i).getPaciente().getCedula().equalsIgnoreCase(cedula)){
				c = misConsultas.get(i);
				encontrado = true;
			}
			i++;
		}
		return c;
	}
	
	public boolean validarUsuario(String user){
		boolean validar = false;
		int i = 0;
		while(!validar && i < misPersonas.size()){
			if(misPersonas.get(i) instanceof Trabajador){
				if(((Trabajador) misPersonas.get(i)).getUsuario().equalsIgnoreCase(user)) {
				validar = true;
				}
			}
			i++;
		}
		return validar;
	}
	
	public Persona buscarTrabajador(String user) {
		Persona trabajador = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i< misPersonas.size()) {
			if(misPersonas.get(i) instanceof Trabajador) {
				if(((Trabajador) misPersonas.get(i)).getUsuario().equalsIgnoreCase(user)) {
					encontrado = true;
					trabajador = misPersonas.get(i);
				}
			}
			i++;
		}
		return trabajador;
	}
	
	public boolean validarLogin(String user, String password) {
		Trabajador userlog = null;
		boolean acceder = false;
		if(validarUsuario(user)) {    //Aqui utilizo la funcion validarUsuario para comprobar si el usuario existe o se escribio bien.
			userlog = (Trabajador) buscarTrabajador(user);
			if(userlog.getPassword().equals(password)) {
				acceder = true;
			}
		}
		return acceder;
	}
}

/*
 * Creado por: Alejandro Col�n
 * Fecha:
 * Anotaciones:
 * 
 * 
 * Modificacion: Alejandro Col�n
 * Fecha: 13/11/17
 * Anotaciones: codificacion de instancia "Singleton"
 * 
 * Modificacion: Oscar Rodriguez
 * Fecha: 13/11/17
 * Anotaciones: Se creo el metodo salvarPersonas() para crear un archivo
 * 
 * Modificaciones: Oscar Rodriguez
 * Fecha: 19/11/2017
 * Anotaciones: Metodos para validar usuario y contrasena.
 * 
 * Modificaciones: Oscar Rodriguez
 * Fecha: 27/11/2017
 * Anotaciones: modificar las funciones de agregar en archivo
 * */
