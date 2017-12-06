package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logical.Cita;
import logical.Clinica;
import logical.Consultante;
import logical.Doctor;
import logical.Persona;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class RegistrarCita extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7211512533171783862L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDireccion;
	private JTextField txtID;
	private JComboBox<String> cbxDoctor;
	private JFormattedTextField txtFormatCedula, txtFormatFechaNaci,
			txtFormatTelefono, txtFecha;
	JCheckBox chckbxM;
	JCheckBox chckbxF;
	private JTextField txtNombre;
	
	 
	
	
	
	public RegistrarCita() {
		setBackground(Color.WHITE);
		setTitle("Registrar cita");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarCita.class.getResource("/images/icon.png")));
		setResizable(false);
		setBounds(100, 100, 289, 437);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panelDatosPersona = new JPanel();
		panelDatosPersona.setBackground(Color.WHITE);
		panelDatosPersona.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Datos de la persona a consultar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDatosPersona.setBounds(10, 11, 262, 213);
		contentPanel.add(panelDatosPersona);
		panelDatosPersona.setLayout(null);

		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(10, 22, 46, 14);
		panelDatosPersona.add(lblCdula);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 70, 67, 14);
		panelDatosPersona.add(lblNombre);

		JLabel lblEdad = new JLabel("Fecha de nacimiento:");
		lblEdad.setBounds(10, 118, 146, 14);
		panelDatosPersona.add(lblEdad);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(139, 71, 46, 14);
		panelDatosPersona.add(lblSexo);

		chckbxM = new JCheckBox("M");
		chckbxM.setBackground(Color.WHITE);
		chckbxM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxM.setSelected(true);
				chckbxF.setSelected(false);
			}
		});
		chckbxM.setEnabled(false);
		chckbxM.setBounds(139, 85, 46, 23);
		panelDatosPersona.add(chckbxM);
		chckbxF = new JCheckBox("F");
		chckbxF.setBackground(Color.WHITE);
		chckbxF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxM.setSelected(false);
				chckbxF.setSelected(true);
			}
		});
		chckbxF.setEnabled(false);
		chckbxF.setBounds(187, 85, 33, 23);
		panelDatosPersona.add(chckbxF);

		
		/*
		 * Esta es la seccion de buscar un consultante existente.
		 * se de be tener presente que aun no se utiliza el txtFecha de nacimineto.
		 * 
		 * 
		 * se debe hacer el metodo para calcular la edad.
		 * */
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(RegistrarCita.class.getResource("/images/binoculares.png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula = txtFormatCedula.getText();
				Persona aux = null;
				// int edad = 0;
				aux = Clinica.getInstance().findByCedula(cedula);
				if (aux == null) {
					txtDireccion.setEnabled(true);
					txtFormatFechaNaci.setEditable(true);
					txtNombre.setEditable(true);
					txtFormatTelefono.setEditable(true);
					txtDireccion.setEditable(true);
					chckbxF.setEnabled(true);
					chckbxM.setEnabled(true);
				} else if (aux != null) {
					txtDireccion.setText(aux.getDireccion());
					txtFormatFechaNaci.setText(aux.getFechaNacimiento());
					txtNombre.setText(aux.getNombre());
					txtFormatTelefono.setText(aux.getTelefono());
					String sexo = aux.getSexo();
					if (sexo.equalsIgnoreCase("Feminino")) {
						chckbxF.setSelected(true);
						chckbxM.setSelected(false);
					} else {
						chckbxM.setSelected(true);
						chckbxF.setSelected(false);
					}

				}
			}
		});
		btnBuscar.setBounds(129, 38, 102, 23);
		panelDatosPersona.add(btnBuscar);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(139, 118, 68, 14);
		panelDatosPersona.add(lblTelfono);

		MaskFormatter maskPhone = null;
		try {
			maskPhone = new MaskFormatter("(###) ###-####");
			maskPhone.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtFormatTelefono = new JFormattedTextField(maskPhone);
		txtFormatTelefono.setEditable(false);
		txtFormatTelefono.setText("");
		txtFormatTelefono.setBounds(139, 135, 109, 20);
		panelDatosPersona.add(txtFormatTelefono);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(10, 166, 67, 14);
		panelDatosPersona.add(lblDireccin);

		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(10, 183, 238, 20);
		panelDatosPersona.add(txtDireccion);
		txtDireccion.setColumns(10);

		MaskFormatter maskCedula = null;
		try {
			maskCedula = new MaskFormatter("###-#######-#");
			maskCedula.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtFormatCedula = new JFormattedTextField(maskCedula);
		txtFormatCedula.setBounds(10, 39, 109, 20);
		panelDatosPersona.add(txtFormatCedula);

		MaskFormatter maskName = null;
		try {
			maskName = new MaskFormatter("********************");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		maskName.setValidCharacters("qwertyuiopasdfghjklzxcvbnmñ" + "QWERTYUIOPASDFGHJKLZXCVBNM " + "ÁáÉéÍíÚú");
		maskName.setPlaceholderCharacter(' ');

		MaskFormatter maskDate = null;
		try {
			maskDate = new MaskFormatter("##/##/####");
			maskDate.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtFormatFechaNaci = new JFormattedTextField(maskDate);
		txtFormatFechaNaci.setEditable(false);
		txtFormatFechaNaci.setBounds(10, 135, 109, 20);
		panelDatosPersona.add(txtFormatFechaNaci);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(10, 86, 109, 20);
		panelDatosPersona.add(txtNombre);
		txtNombre.setColumns(10);

		JPanel panelDatosCita = new JPanel();
		panelDatosCita.setBackground(Color.WHITE);
		panelDatosCita.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de la cita",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDatosCita.setBounds(10, 237, 262, 127);
		contentPanel.add(panelDatosCita);
		panelDatosCita.setLayout(null);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 23, 46, 14);
		panelDatosCita.add(lblId);

		txtID = new JTextField();

		txtID.setEnabled(false);
		txtID.setBounds(10, 42, 106, 20);
		panelDatosCita.add(txtID);
		txtID.setColumns(10);
		txtID.setText("CIT-" + (Clinica.getInstance().getMisCitas().size() + 1));

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(139, 23, 46, 14);
		panelDatosCita.add(lblFecha);

		txtFecha = new JFormattedTextField(maskDate);
		txtFecha.setBounds(139, 42, 106, 20);
		panelDatosCita.add(txtFecha);
		txtFecha.setColumns(10);

		JLabel lblDoctor = new JLabel("Doctor:");
		lblDoctor.setBounds(10, 73, 46, 14);
		panelDatosCita.add(lblDoctor);

		cbxDoctor = new JComboBox<String>();
		cbxDoctor.setModel(new DefaultComboBoxModel<String>(new String[] { "<Seleccione>" }));
		cbxDoctor.setBounds(10, 90, 252, 20);
		panelDatosCita.add(cbxDoctor);
		llenarCMB();
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			buttonPane.setBackground(new Color(102, 153, 255));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				/*
				 * Esta es la seccion de registrar cita
				 * se debe tener presente que aun no se utiliza el txtFecha de nacimineto.
				 * 
				 * 
				 * se debe hacer el metodo para calcular la edad.
				 * Se debe controlar el no poder registrar si hay campos vacios
				 * */
				
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setIcon(new ImageIcon(RegistrarCita.class.getResource("/images/checked (1).png")));
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(txtFormatCedula.getText().toString().equalsIgnoreCase("")|| txtNombre.getText().toString().equalsIgnoreCase("")||
								txtFormatTelefono.getText().toString().equalsIgnoreCase("")||txtFormatFechaNaci.getText().toString().equalsIgnoreCase("")
								|| txtDireccion.getText().equalsIgnoreCase("") || txtFecha.getText().equalsIgnoreCase("")||
								cbxDoctor.getSelectedItem().toString().equalsIgnoreCase("Seleccione")){
							JOptionPane.showMessageDialog(null, "Compruebe que no existan datos inválidos", null, JOptionPane.WARNING_MESSAGE, null);
						
						}else{

						// Datos de la cita
						String id = txtID.getText();
						Doctor doctor = buscarDoctor();
						String fecha = txtFecha.getText();

						// verificando si la persona existe o no
						Persona aux = Clinica.getInstance().findByCedula(txtFormatCedula.getText());
						if (aux == null) {
							String cedula = txtFormatCedula.getText();
							String nombre = txtNombre.getText();
							String direccion = txtDireccion.getText();
							String telefono = txtFormatTelefono.getText();
							String fechaNacimiento = txtFormatFechaNaci.getText();
							String sexo = null;
							if (chckbxF.isSelected()) {
								sexo = "Femenino";
							} else {
								sexo = "Masculino";
							}
							
								// Creando nuevo Consultante
								Persona newConsultante = new Consultante(cedula, nombre, fechaNacimiento, telefono, direccion,
										sexo);
								Clinica.getInstance().addPersona(newConsultante);
								Cita newCita = new Cita(id, fecha, doctor, newConsultante);
								Clinica.getInstance().addCitas(newCita);
							} else{
							//Si el consultante existe, solo se crea la cita
							Cita newCita = new Cita(id, fecha, doctor, aux);
							Clinica.getInstance().addCitas(newCita);
						}
						try {
							Clinica.getInstance().salvarPersonas();
							Clinica.getInstance().salvarCitas();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						Principal.LoadTableAdministrativo();
						JOptionPane.showMessageDialog(null, "Cita Registrada", "Información",
								JOptionPane.INFORMATION_MESSAGE);
						clean();
					}
						dispose();
					}

					private Doctor buscarDoctor() {
						/* Esta funcion captura el String seleccionado en el cbxDoctor y extrae la cedula del mismo.
						 * luego implementa la funcion de buscar persona por cedula(implementada en la clase principal.
						 * retorna el objeto doctor seleccionado*/
						
						int size = cbxDoctor.getSelectedItem().toString().length(); 
						String cedula = (cbxDoctor.getSelectedItem().toString()).substring(size - 14, size - 1);
						return (Doctor) Clinica.getInstance().findByCedula(cedula);

					}

				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnAtras = new JButton("Atr\u00E1s");
				btnAtras.setIcon(new ImageIcon(RegistrarCita.class.getResource("/images/back (1).png")));
				btnAtras.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnAtras.setActionCommand("Cancel");
				buttonPane.add(btnAtras);
			}
		}
	}

	private void llenarCMB() {
		boolean encontrado = false;
		cbxDoctor.removeAllItems(); // limpiando la info del cmb

		try {
			for (int i = 0; i < Clinica.getInstance().getMisPersonas().size(); i++) {
				if (Clinica.getInstance().getMisPersonas().get(i) instanceof Doctor) {
					cbxDoctor.addItem(new String(Clinica.getInstance().getMisPersonas().get(i).getNombre() + "  ("
							+ Clinica.getInstance().getMisPersonas().get(i).getCedula() + ")"));
					encontrado = true;
				}
			}

			if (encontrado) {
				cbxDoctor.insertItemAt("<Seleccione>", 0);
				cbxDoctor.setSelectedItem(0);
			} else {
				cbxDoctor.removeAllItems(); 
				cbxDoctor.insertItemAt("<Vacio>", 0);
				cbxDoctor.setSelectedItem(0);
				JOptionPane.showMessageDialog(null, "No hay Doctores Registrados", "ERROR", JOptionPane.ERROR_MESSAGE);
				dispose();
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "EL PROGRAMA HA EXPLOTADO INESPERADAMENTE", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void clean() {
		txtFormatCedula.setText("");
		txtNombre.setText("");
		txtFormatFechaNaci.setText(new String(""));
		txtFormatTelefono.setText(new String(""));
		txtDireccion.setText("");
		txtFecha.setText("");
		chckbxF.setSelected(false);
		chckbxM.setSelected(false);
		txtID.setText("CIT-" + (Clinica.getInstance().getMisCitas().size() + 1));
	}
}

/*
 * 
 * Creado Por: Yamilka Vazquez. Fecha: Anotaciones:
 * 
 * 
 * Modificado: Alejandro Colon Fecha: 20/11/17 Anotaciones:
 * 
 * Modificado: Yamilka Fecha: 21/11/17 Anotaciones: agregué la condicion que verifica si algunos campos son invalidos antes de registrar
 * Cambié los nombre de los txt con formato por txtFormat(Nombre)
 *  
 * Modificado: Oscar Rodriguez
 * Fecha: 27/11/2017
 * Anotaciones: Agregue las llamadas a guardar en fichero
 * 
 */