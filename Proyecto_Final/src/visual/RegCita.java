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
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class RegCita extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7211512533171783862L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDireccion;
	private JTextField txtID;
	private JTextField txtFecha;
	private JComboBox<String> cbxDoctor;
	private JFormattedTextField formattedTextFldCedula, formattedTextFldNombre, formattedTextFldNacimiento,
			formattedTextFldTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegCita dialog = new RegCita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegCita() {
		setTitle("Registrar cita");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegCita.class.getResource("/images/icon.png")));
		setResizable(false);
		setBounds(100, 100, 289, 437);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panelDatosPersona = new JPanel();
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

		JCheckBox chckbxM = new JCheckBox("M");
		chckbxM.setEnabled(false);
		chckbxM.setBounds(139, 85, 33, 23);
		panelDatosPersona.add(chckbxM);

		JCheckBox chckbxF = new JCheckBox("F");
		chckbxF.setEnabled(false);
		chckbxF.setBounds(174, 85, 33, 23);
		panelDatosPersona.add(chckbxF);

		JButton btnBuscar = new JButton("Buscar...");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula = formattedTextFldCedula.getText();
				Persona aux = null;
				//int edad = 0;
				aux = Clinica.getInstance().findByCedula(cedula);
				if (aux == null) {
					txtDireccion.setEnabled(true);
					formattedTextFldNacimiento.setEnabled(true);
					formattedTextFldNombre.setEnabled(true);
					formattedTextFldTelefono.setEnabled(true);
					chckbxF.setEnabled(true);
					chckbxM.setEnabled(true);
				} else if (aux != null) {
					txtDireccion.setText(aux.getDireccion());
					formattedTextFldNacimiento.setText("00/00/0000");
					formattedTextFldNombre.setText(aux.getNombre());
					formattedTextFldTelefono.setText(aux.getTelefono());
					String sexo = aux.getSexo();
					if (sexo.equalsIgnoreCase("Feminino")) {
						chckbxF.setSelected(true);
						chckbxM.setSelected(false);
					} else if (sexo.equalsIgnoreCase("Masculino")) {
						chckbxM.setSelected(true);
						chckbxF.setSelected(true);
					}

				}
			}
		});
		btnBuscar.setBounds(129, 38, 97, 23);
		panelDatosPersona.add(btnBuscar);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(139, 118, 46, 14);
		panelDatosPersona.add(lblTelfono);

		MaskFormatter maskPhone = null;
		try {
			maskPhone = new MaskFormatter("(###) ###-####");
			maskPhone.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		formattedTextFldTelefono = new JFormattedTextField(maskPhone);
		formattedTextFldTelefono.setEnabled(false);
		formattedTextFldTelefono.setText("");
		formattedTextFldTelefono.setBounds(139, 135, 109, 20);
		panelDatosPersona.add(formattedTextFldTelefono);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(10, 166, 67, 14);
		panelDatosPersona.add(lblDireccin);

		txtDireccion = new JTextField();
		txtDireccion.setEnabled(false);
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

		formattedTextFldCedula = new JFormattedTextField(maskCedula);
		formattedTextFldCedula.setBounds(10, 39, 109, 20);
		panelDatosPersona.add(formattedTextFldCedula);

		MaskFormatter maskName = null;
		try {
			maskName = new MaskFormatter("************************************");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		maskName.setValidCharacters(
				"qwertyuiopasdfghjklzxcvbnm" + "           QWERTYUIOPASDFGHJKLZXCVBNM " + "ÁáÉéÍíÚú");
		maskName.setPlaceholderCharacter(' ');

		formattedTextFldNombre = new JFormattedTextField(maskName);
		formattedTextFldNombre.setEnabled(false);
		formattedTextFldNombre.setBounds(10, 87, 109, 20);
		panelDatosPersona.add(formattedTextFldNombre);

		formattedTextFldNacimiento = new JFormattedTextField();
		formattedTextFldNacimiento.setEnabled(false);
		formattedTextFldNacimiento.setBounds(10, 135, 109, 20);
		panelDatosPersona.add(formattedTextFldNacimiento);

		JPanel panelDatosCita = new JPanel();
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

		txtFecha = new JTextField();
		txtFecha.setBounds(139, 42, 86, 20);
		panelDatosCita.add(txtFecha);
		txtFecha.setColumns(10);

		JLabel lblDoctor = new JLabel("Doctor:");
		lblDoctor.setBounds(10, 73, 46, 14);
		panelDatosCita.add(lblDoctor);

		cbxDoctor = new JComboBox<String>();
		cbxDoctor.setModel(new DefaultComboBoxModel<String>(new String[] { "<Seleccione>" }));
		cbxDoctor.setBounds(10, 90, 106, 20);
		panelDatosCita.add(cbxDoctor);
		llenarCMB();
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Datos de la cita
						String id = txtID.getText();
						//Doctor doctor = (Doctor) cbxDoctor.getSelectedItem();
						String fecha = txtFecha.getText();
						// verificando si la persona existe o no
						Persona aux = Clinica.getInstance().findByCedula(formattedTextFldCedula.getText());
						if (aux == null) {
							String cedula = formattedTextFldCedula.getText();
							String nombre = formattedTextFldNombre.getText();
							String direccion = txtDireccion.getText();
							String telefono = formattedTextFldTelefono.getText();
							int edad = 5;
							String sexo = null;
							if (chckbxF.isSelected()) {
								sexo = "Femenino";
							} else if (chckbxM.isSelected()) {
								sexo = "Masculino";
							}
							// Como el consultante no existia antes se crea
							Persona newConsultante = new Consultante(cedula, nombre, edad, telefono, direccion, sexo);
							Clinica.getInstance().addPersona(newConsultante);
							Cita newCita = new Cita(id, fecha, null, newConsultante);
							Clinica.getInstance().addCitas(newCita);
						}
						
						// Si el consultante existe ya solo creame una cita
						// nueva con los datos de la persona registro
						else if (aux != null) {
							Cita newCita = new Cita(id, fecha, null, aux);
							Clinica.getInstance().addCitas(newCita);
						}

						JOptionPane.showMessageDialog(null, "La operación ha sido exitosa", "Información",
								JOptionPane.INFORMATION_MESSAGE);

					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}

	private void llenarCMB() {
		boolean encontrado = false;
		cbxDoctor.removeAllItems();  	//limpiando la info del cmb
		
		try{
			for (int i = 0; i < Clinica.getInstance().getMisPersonas().size(); i++){
				if(Clinica.getInstance().getMisPersonas().get(i) instanceof Doctor){
					cbxDoctor.addItem(new String(Clinica.getInstance().getMisPersonas().get(i).getNombre() + "(" + Clinica.getInstance().getMisPersonas().get(i).getCedula() + ") " ));
					encontrado = true;
				}
			}
			
			if (encontrado){
				//CMBSuministrador.insertItemAt("<Seleccione>", 0);
				cbxDoctor.setSelectedItem(0);
			}else{
			
				JOptionPane.showMessageDialog(null, "No hay Doctores Registrados", "ERROR", JOptionPane.ERROR_MESSAGE);
				dispose();
			}
			
		
		}catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "EL PROGRAMA HA EXPLOTADO INESPERADAMENTE", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	public void clean() {
		formattedTextFldCedula.setText("");
		formattedTextFldNombre.setText("");
		formattedTextFldNacimiento.setText(new String(""));
		formattedTextFldTelefono.setText(new String(""));
		txtID.setText("CIT-" + (Clinica.getInstance().getMisCitas().size() + 1));
	}
}
