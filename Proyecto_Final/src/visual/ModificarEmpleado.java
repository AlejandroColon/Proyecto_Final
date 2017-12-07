package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import logical.Clinica;
import logical.Doctor;
import logical.Persona;
import logical.Trabajador;

public class ModificarEmpleado extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5273979479288675217L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDireccion;
	private JTextField txtExequatur;
	private JSpinner spnCitasXDia;
	private JPasswordField passContra;
	private JTextField txtUsuario;
	private JCheckBox chckbxM;
	private JCheckBox chckbxF;
	private JFormattedTextField txtFechaNacimiento;
	private JFormattedTextField txtTelefono;
	private JTextField txtNombre;
	private JFormattedTextField txtCedula;
	private JComboBox<String> cbxEspecialidad;
	

	public ModificarEmpleado(Persona empleado) {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setTitle("Modificar usuario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarUsuario.class.getResource("/images/icon.png")));
		setBounds(100, 100, 423, 506);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Datos personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 386, 176);
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
		txtDireccion.setText(empleado.getDireccion());
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
		
		if(empleado.getSexo().equalsIgnoreCase("Masculino")) {
			chckbxM.setSelected(true);
			chckbxF.setSelected(false);
		}
		
		if(empleado.getSexo().equalsIgnoreCase("Femenino")) {
			chckbxM.setSelected(false);
			chckbxF.setSelected(true);
		}

		MaskFormatter maskDate = null;
		try {
			maskDate = new MaskFormatter("##/##/####");
			maskDate.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtFechaNacimiento = new JFormattedTextField(maskDate);
		txtFechaNacimiento.setText(empleado.getFechaNacimiento());
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
		txtTelefono.setText(empleado.getTelefono());
		panel.add(txtTelefono);

		/*MaskFormatter maskName = null;
		try {
			maskName = new MaskFormatter("************************************");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		maskName.setValidCharacters(
				"qwertyuiopasdfghjklzxcvbnÒm" + "           QWERTYUIOPASDFGHJKLZXCVBN—M " + "¡·…ÈÕÌ⁄˙");
		maskName.setPlaceholderCharacter(' ');*/

		txtNombre = new JTextField();
		txtNombre.setBounds(212, 37, 164, 20);
		txtNombre.setText(empleado.getNombre());
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
		txtCedula.setText(empleado.getCedula());
		txtCedula.setBounds(10, 37, 164, 20);
		panel.add(txtCedula);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Datos Medicos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 300, 386, 123);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblExequatur = new JLabel("Exequatur:");
		lblExequatur.setBounds(10, 29, 100, 14);
		panel_1.add(lblExequatur);

		txtExequatur = new JTextField();
		txtExequatur.setEditable(false);
		if(empleado instanceof Doctor) {
		txtExequatur.setEditable(true);
		txtExequatur.setText(((Doctor)empleado).getCodigo());
		}
		txtExequatur.setBounds(10, 46, 164, 20);
		panel_1.add(txtExequatur);
		txtExequatur.setColumns(10);

		JLabel lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setBounds(212, 29, 92, 14);
		panel_1.add(lblEspecialidad);

		spnCitasXDia = new JSpinner();
		spnCitasXDia.setBackground(Color.WHITE);
		spnCitasXDia.setEnabled(false);
		spnCitasXDia.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCitasXDia.setBounds(10, 91, 164, 20);
		panel_1.add(spnCitasXDia);

		JLabel lblCitasPorDia = new JLabel("Citas por dia:");
		lblCitasPorDia.setBounds(10, 77, 100, 14);
		panel_1.add(lblCitasPorDia);
		
		cbxEspecialidad = new JComboBox<String>();
		cbxEspecialidad.setEnabled(false);
		if(empleado instanceof Doctor) {
			cbxEspecialidad.setEnabled(true);
			cbxEspecialidad.setSelectedItem(((Doctor) empleado).getEspecialidad());
		}
		cbxEspecialidad.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Cirujano General", "Ginec\u00F3logo", "Cardi\u00F3logo", "Neur\u00F3logo", "Ur\u00F3logo", "Pediatra", "Dermat\u00F3logo", "Oftalm\u00F3logo"}));
		cbxEspecialidad.setBounds(212, 46, 164, 20);
		panel_1.add(cbxEspecialidad);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(
				new TitledBorder(null, "Datos de usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 196, 386, 93);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);

		passContra = new JPasswordField();
		passContra.setBounds(212, 46, 164, 20);
		passContra.setText(((Doctor)empleado).getPassword());
		panel_2.add(passContra);

		JLabel label_1 = new JLabel("Contrase\u00F1a:");
		label_1.setBounds(212, 29, 76, 14);
		panel_2.add(label_1);

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setText(((Doctor)empleado).getUsuario());
		txtUsuario.setBounds(11, 46, 164, 20);
		panel_2.add(txtUsuario);

		JLabel label_2 = new JLabel("Usuario:");
		label_2.setBounds(11, 29, 60, 14);
		panel_2.add(label_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(102, 153, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Guardar");
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
								|| passContra.getPassword().toString().equalsIgnoreCase("")) {
							JOptionPane.showMessageDialog(null, "No puede dejar campos vacios", "Aviso",
									JOptionPane.WARNING_MESSAGE);
						} else {
								
									empleado.setCedula(txtCedula.getText());
									empleado.setNombre(txtNombre.getText());
									empleado.setFechaNacimiento(txtFechaNacimiento.getText());
									empleado.setTelefono(txtTelefono.getText());
									empleado.setDireccion(txtDireccion.getText());
									if (chckbxF.isSelected()) {
										empleado.setSexo("Femenino");
									}
									if (chckbxM.isSelected()) {
										empleado.setSexo("Masculino");
									}
									((Trabajador) empleado).setUsuario(txtUsuario.getText());
									
									if (empleado instanceof Doctor) {
										((Doctor)empleado).setEspecialidad(cbxEspecialidad.getSelectedItem().toString());
										((Doctor)empleado).setCodigo(txtExequatur.getText());
										((Doctor)empleado).setCitasXdia(Integer.parseInt(spnCitasXDia.getValue().toString()));
									}
									JOptionPane.showMessageDialog(null, "Usuario modificado", "Aviso",
											JOptionPane.INFORMATION_MESSAGE);
									try {
										Clinica.getInstance().salvarPersonas();
									} catch (IOException e1) {
										e1.printStackTrace();
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
}


/*
 * Creado por: Oscar Rodriguez Fecha: 6/12/17
 * 
 */
