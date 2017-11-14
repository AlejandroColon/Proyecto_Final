package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;

import logical.Administrativo;
import logical.Clinica;
import logical.Doctor;
import logical.Persona;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class RegUsuario extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3374135961528682571L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtExequatur;
	private JTextField txtEspecialidad;
	private JTextField txtUsuario;
	private JPasswordField passContra;
	private JPasswordField passConfContra;
	private JComboBox<String> cbxSexo;
	private JRadioButton rdbtnMedico;
	private JRadioButton rdbtnAdministrativo;
	private JSpinner spnCitasXDia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegUsuario dialog = new RegUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegUsuario() {
		setTitle("Registro de usuarios");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegUsuario.class.getResource("/images/icon.png")));
		setBounds(100, 100, 450, 488);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 414, 264);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(212, 24, 60, 14);
		panel.add(lblNombre);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(10, 24, 60, 14);
		panel.add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(10, 37, 192, 20);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(212, 37, 192, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(10, 68, 46, 14);
		panel.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(10, 82, 76, 20);
		panel.add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(212, 68, 86, 14);
		panel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(212, 82, 192, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(96, 68, 46, 14);
		panel.add(lblSexo);
		
		cbxSexo = new JComboBox<String>();
		cbxSexo.setModel(new DefaultComboBoxModel<String> (new String[] {"<Seleccione>", "Masculino", "Femenino", "Otro"}));
		cbxSexo.setBounds(96, 82, 106, 20);
		panel.add(cbxSexo);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(10, 113, 76, 14);
		panel.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(10, 126, 394, 20);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		rdbtnMedico = new JRadioButton("Medico");
		rdbtnMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMedico.isSelected()) {
					txtEspecialidad.setEditable(true);
					txtExequatur.setEditable(true);
					spnCitasXDia.setEnabled(true);
				}
			}
		});
		rdbtnMedico.setBounds(65, 215, 109, 23);
		panel.add(rdbtnMedico);
		
		rdbtnAdministrativo = new JRadioButton("Administrativo");
		rdbtnAdministrativo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEspecialidad.setEditable(false);
				txtExequatur.setEditable(false);
				spnCitasXDia.setEnabled(false);
			}
		});
		rdbtnAdministrativo.setBounds(239, 215, 109, 23);
		panel.add(rdbtnAdministrativo);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 157, 60, 14);
		panel.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(14, 175, 86, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(114, 157, 76, 14);
		panel.add(lblContrasea);
		
		passContra = new JPasswordField();
		passContra.setBounds(114, 175, 135, 20);
		panel.add(passContra);
		
		JLabel lblConfirmarContrase = new JLabel("Confirmar contrase\u00F1a:");
		lblConfirmarContrase.setBounds(263, 157, 148, 14);
		panel.add(lblConfirmarContrase);
		
		passConfContra = new JPasswordField();
		passConfContra.setBounds(263, 175, 135, 20);
		panel.add(passConfContra);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos Medicos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 286, 414, 122);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblExequatur = new JLabel("Exequatur:");
		lblExequatur.setBounds(10, 21, 100, 14);
		panel_1.add(lblExequatur);
		
		txtExequatur = new JTextField();
		txtExequatur.setEditable(false);
		txtExequatur.setBounds(10, 35, 191, 20);
		panel_1.add(txtExequatur);
		txtExequatur.setColumns(10);
		
		JLabel lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setBounds(211, 21, 92, 14);
		panel_1.add(lblEspecialidad);
		
		txtEspecialidad = new JTextField();
		txtEspecialidad.setEditable(false);
		txtEspecialidad.setBounds(211, 35, 191, 20);
		panel_1.add(txtEspecialidad);
		txtEspecialidad.setColumns(10);
		
		spnCitasXDia = new JSpinner();
		spnCitasXDia.setEnabled(false);
		spnCitasXDia.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCitasXDia.setBounds(157, 80, 100, 20);
		panel_1.add(spnCitasXDia);
		
		JLabel lblCitasPorDia = new JLabel("Citas por dia:");
		lblCitasPorDia.setBounds(157, 66, 100, 14);
		panel_1.add(lblCitasPorDia);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(passContra.getPassword().toString().equalsIgnoreCase(passConfContra.getPassword().toString())) {
							Persona aux = null;
							String cedula = txtCedula.getText();
							String nombre = txtNombre.getText();
							int edad = Integer.valueOf(txtEdad.getText());
							String telefono = txtTelefono.getText();
							String direccion = txtDireccion.getText();
							String sexo = cbxSexo.getSelectedItem().toString();
							String usuario = txtUsuario.getText();
							String password = passContra.getPassword().toString();
							if(rdbtnMedico.isSelected()) {
								String especialidad =txtEspecialidad.getText();
								String exequatur = txtExequatur.getText();
								int citasXdia = Integer.valueOf(spnCitasXDia.getValue().toString());
								aux = new Doctor(cedula, nombre, edad, telefono, direccion, sexo, usuario, password, exequatur, especialidad, citasXdia);
							}else
								aux = new Administrativo(cedula, nombre, edad, telefono, direccion, sexo, usuario, password);
							Clinica.getInstance().addPersona(aux);
							try {
								Clinica.getInstance().salvarPersonas();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}else {
							JOptionPane.showMessageDialog(null, "Contraseñas no coincide, favor volver a digitarlas", "Aviso", JOptionPane.WARNING_MESSAGE);
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

/*
 * Creado por: Oscar Rodriguez
 * Fecha: 13/11/17
 */
