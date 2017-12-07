package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;


import logical.Administrativo;
import logical.Clinica;
import logical.Doctor;
import logical.Persona;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.IOException;
//import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class RegistrarUsuario extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3374135961528682571L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDireccion;
	private JTextField txtExequatur;
	private JSpinner spnCitasXDia;
	private JPasswordField passConfContra;
	private JPasswordField passContra;
	private JTextField txtUsuario;
	private JCheckBox chckbxM;
	private JCheckBox chckbxF;
	private JFormattedTextField txtFechaNacimiento;
	private JFormattedTextField txtTelefono;
	private JRadioButton rdbtnMedico;
	private JTextField txtNombre;
	private JRadioButton rdbtnAdm;
	private JFormattedTextField txtCedula;
	private JComboBox<String> cbxEspecialidad;

	public RegistrarUsuario() {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setTitle("Registro de usuarios");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarUsuario.class.getResource("/images/icon.png")));
		setBounds(100, 100, 423, 538);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Datos personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 386, 198);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(212, 24, 60, 14);
		panel.add(lblNombre);

		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(10, 24, 60, 14);
		panel.add(lblCedula);

		JLabel lblEdad = new JLabel("Fecha de nacimiento:");
		lblEdad.setBounds(10, 68, 164, 14);
		panel.add(lblEdad);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(212, 113, 86, 14);
		panel.add(lblTelefono);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(212, 68, 46, 14);
		panel.add(lblSexo);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(10, 113, 76, 14);
		panel.add(lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(10, 127, 164, 20);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);

		chckbxM = new JCheckBox("M");
		chckbxM.setBackground(Color.WHITE);
		chckbxM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxF.setSelected(false);
			}
		});
		chckbxM.setBounds(210, 81, 38, 23);
		panel.add(chckbxM);

		chckbxF = new JCheckBox("F");
		chckbxF.setBackground(Color.WHITE);
		chckbxF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxM.setSelected(false);
			}
		});
		chckbxF.setBounds(250, 81, 97, 23);
		panel.add(chckbxF);

		MaskFormatter maskDate = null;
		try {
			maskDate = new MaskFormatter("##/##/####");
			maskDate.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtFechaNacimiento = new JFormattedTextField(maskDate);
		txtFechaNacimiento.setBounds(10, 82, 164, 20);
		panel.add(txtFechaNacimiento);

		MaskFormatter maskphone = null;
		try {
			maskphone = new MaskFormatter("(###) ###-####");
			maskphone.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtTelefono = new JFormattedTextField(maskphone);
		txtTelefono.setBounds(212, 127, 164, 20);
		panel.add(txtTelefono);

		MaskFormatter maskName = null;
		try {
			maskName = new MaskFormatter("************************************");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		maskName.setValidCharacters(
				"qwertyuiopasdfghjklzxcvbn�m" + "           QWERTYUIOPASDFGHJKLZXCVBN�M " + "��������");
		maskName.setPlaceholderCharacter(' ');

		txtNombre = new JTextField();
		txtNombre.setBounds(212, 37, 164, 20);
		panel.add(txtNombre);

		MaskFormatter maskID = null;
		try {
			maskID = new MaskFormatter("###-#######-#");
			maskphone.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtCedula = new JFormattedTextField(maskID);
		txtCedula.setForeground(Color.BLACK);
		txtCedula.setBounds(10, 37, 164, 20);
		panel.add(txtCedula);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Datos Medicos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(206, 279, 190, 182);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblExequatur = new JLabel("Exequatur:");
		lblExequatur.setBounds(10, 29, 100, 14);
		panel_1.add(lblExequatur);

		txtExequatur = new JTextField();
		txtExequatur.setEditable(false);
		txtExequatur.setBounds(10, 46, 164, 20);
		panel_1.add(txtExequatur);
		txtExequatur.setColumns(10);

		JLabel lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setBounds(10, 77, 92, 14);
		panel_1.add(lblEspecialidad);

		spnCitasXDia = new JSpinner();
		spnCitasXDia.setBackground(Color.WHITE);
		spnCitasXDia.setEnabled(false);
		spnCitasXDia.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCitasXDia.setBounds(10, 137, 164, 20);
		panel_1.add(spnCitasXDia);

		JLabel lblCitasPorDia = new JLabel("Citas por dia:");
		lblCitasPorDia.setBounds(10, 123, 100, 14);
		panel_1.add(lblCitasPorDia);
		
		cbxEspecialidad = new JComboBox<String>();
		cbxEspecialidad.setEnabled(false);
		cbxEspecialidad.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Cirujano General", "Ginec\u00F3logo", "Cardi\u00F3logo", "Neur\u00F3logo", "Ur\u00F3logo", "Pediatra", "Dermat\u00F3logo", "Oftalm\u00F3logo"}));
		cbxEspecialidad.setBounds(10, 91, 164, 20);
		panel_1.add(cbxEspecialidad);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(
				new TitledBorder(null, "Datos de usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 220, 186, 241);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);

		passConfContra = new JPasswordField();
		passConfContra.setBounds(11, 136, 164, 20);
		panel_2.add(passConfContra);

		JLabel label = new JLabel("Confirmar contrase\u00F1a:");
		label.setBounds(11, 122, 148, 14);
		panel_2.add(label);

		passContra = new JPasswordField();
		passContra.setBounds(11, 91, 164, 20);
		panel_2.add(passContra);

		JLabel label_1 = new JLabel("Contrase\u00F1a:");
		label_1.setBounds(11, 77, 76, 14);
		panel_2.add(label_1);

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(11, 46, 164, 20);
		panel_2.add(txtUsuario);

		JLabel label_2 = new JLabel("Usuario:");
		label_2.setBounds(11, 29, 60, 14);
		panel_2.add(label_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(null, "Categoria", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(206, 220, 190, 48);
		contentPanel.add(panel_3);
		panel_3.setLayout(null);

		rdbtnMedico = new JRadioButton("Medico");
		rdbtnMedico.setBackground(Color.WHITE);
		rdbtnMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnMedico.setSelected(true);
				rdbtnAdm.setSelected(false);
				cbxEspecialidad.setEnabled(true);
				
				txtExequatur.setEditable(true);
				spnCitasXDia.setEnabled(true);
			}
		});
		rdbtnMedico.setBounds(38, 18, 67, 23);
		panel_3.add(rdbtnMedico);

		rdbtnAdm = new JRadioButton("Adm.");
		rdbtnAdm.setBackground(Color.WHITE);
		rdbtnAdm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnMedico.setSelected(false);
				rdbtnAdm.setSelected(true);
				cbxEspecialidad.setEnabled(false);
				txtExequatur.setEnabled(true);
				txtExequatur.setEditable(false);
				spnCitasXDia.setEnabled(false);
			}
		});
		rdbtnAdm.setBounds(107, 18, 77, 23);
		panel_3.add(rdbtnAdm);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(102, 153, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setIcon(new ImageIcon(RegistrarUsuario.class.getResource("/images/checked (1).png")));
				okButton.setBackground(new Color(204, 204, 204));
				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if (txtCedula.getText().equalsIgnoreCase("") || txtDireccion.getText().equalsIgnoreCase("")
								|| (cbxEspecialidad.isEditable() && !cbxEspecialidad.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>"))
								|| (txtExequatur.isEditable() && txtExequatur.getText().equalsIgnoreCase(""))
								|| txtFechaNacimiento.getText().equalsIgnoreCase("")
								|| txtNombre.getText().equalsIgnoreCase("")
								|| txtTelefono.getText().equalsIgnoreCase("")
								|| txtUsuario.getText().equalsIgnoreCase("")
								|| passContra.getPassword().toString().equalsIgnoreCase("")
								|| passConfContra.getPassword().toString().equalsIgnoreCase("")) {
							JOptionPane.showMessageDialog(null, "No puede dejar campos vacios", "Aviso",
									JOptionPane.WARNING_MESSAGE);
						} else {

							if (Clinica.getInstance().findByCedula(txtCedula.getText()) == null) {
								String prueba = String.valueOf(passContra.getPassword());
								String pruebaconf = String.valueOf(passConfContra.getPassword());
								if (prueba.equals(pruebaconf)
										&& (Clinica.getInstance().validarUsuario(txtUsuario.getText()) == false)) {
									Persona aux = null;
									String cedula = txtCedula.getText();
									String nombre = txtNombre.getText();
									String fechaNacimiento = txtFechaNacimiento.getText();
									String telefono = txtTelefono.getText();
									String direccion = txtDireccion.getText();
									String sexo = "";
									if (chckbxF.isSelected()) {
										sexo = "Femenino";
									}
									if (chckbxM.isSelected()) {
										sexo = "Masculino";
									}
									String usuario = txtUsuario.getText();
									String password = String.valueOf(passContra.getPassword());
									if (rdbtnMedico.isSelected()) {
										String especialidad = cbxEspecialidad.getSelectedItem().toString();
										String exequatur = txtExequatur.getText();
										int citasXdia = Integer.parseInt(spnCitasXDia.getValue().toString());
										aux = new Doctor(cedula, nombre, fechaNacimiento, telefono, direccion, sexo, usuario, password,
												exequatur, especialidad, citasXdia);
									} else
										aux = new Administrativo(cedula, nombre, fechaNacimiento, telefono, direccion, sexo, usuario,
												password);
									Clinica.getInstance().addPersona(aux);
									JOptionPane.showMessageDialog(null, "Usuario registrado", "Aviso",
											JOptionPane.INFORMATION_MESSAGE);
									clean();
									try {
										Clinica.getInstance().salvarPersonas();
									} catch (IOException e1) {
										e1.printStackTrace();
									}

								} else if (passContra.getPassword().toString()
										.equals(passConfContra.getPassword().toString()) == false) {
									JOptionPane.showMessageDialog(null,
											"Contrase�as no coinciden, favor volver a digitarlas", "Aviso",
											JOptionPane.WARNING_MESSAGE);
								} else {
									JOptionPane.showMessageDialog(null,
											"El usuario ya ha sido utilizado, favor elegir otro", "Aviso",
											JOptionPane.WARNING_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(null,
										"C�dula ingresada anteriormente; No puede haber usuarios duplicados", "Aviso",
										JOptionPane.ERROR_MESSAGE);
							}
							

						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Atras");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setIcon(new ImageIcon(RegistrarUsuario.class.getResource("/images/cancel.png")));
				cancelButton.setBackground(new Color(204, 204, 204));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void clean() {
		txtCedula.setText("");
		txtDireccion.setText("");
		cbxEspecialidad.setSelectedIndex(0);;
		txtExequatur.setText("");
		txtFechaNacimiento.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		txtUsuario.setText("");
		spnCitasXDia.setValue(1);
		rdbtnAdm.setSelected(false);
		rdbtnMedico.setSelected(false);
		cbxEspecialidad.setEnabled(false);
		txtExequatur.setEditable(false);
		spnCitasXDia.setEnabled(false);
		chckbxF.setSelected(false);
		chckbxM.setSelected(false);
		passConfContra.setText("");
		passContra.setText("");

	}
}

/*
 * Creado por: Oscar Rodriguez Fecha: 13/11/17
 * 
 * Modificacion: Oscar Rodriguez Fecha: 19/11/2017
 * 
 * Modificaciones: Oscar Rodriguez Fecha: 19/11/2017 Anotaciones: Agregar
 * funciones para guardar en archivo
 * 
 * Modificaciones: Yamilka V�squez fecha: 6/12/17 Anotaciones: Cambiando el txtEspecialidad por
 * Especialidad
 */
