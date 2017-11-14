package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;

public class RegCita extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7211512533171783862L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField textField_3;
	private JTextField txtDireccion;
	private JTextField txtID;
	private JTextField txtFecha;
	private JComboBox<String> cbxDoctor; //OJO AQUÍ, al cbx le puse un tipo string para que se quitara el warning meanwhile

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
		setBounds(100, 100, 528, 359);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panelDatosPersona = new JPanel();
		panelDatosPersona.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de la persona a consultar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDatosPersona.setBounds(10, 11, 492, 152);
		contentPanel.add(panelDatosPersona);
		panelDatosPersona.setLayout(null);
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(10, 22, 46, 14);
		panelDatosPersona.add(lblCdula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(90, 19, 109, 20);
		panelDatosPersona.add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 47, 46, 14);
		panelDatosPersona.add(lblNombre);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(10, 72, 46, 14);
		panelDatosPersona.add(lblEdad);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(90, 44, 109, 20);
		panelDatosPersona.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(90, 69, 46, 20);
		panelDatosPersona.add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblAos = new JLabel("a\u00F1os");
		lblAos.setBounds(146, 72, 46, 14);
		panelDatosPersona.add(lblAos);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(227, 72, 46, 14);
		panelDatosPersona.add(lblSexo);
		
		JCheckBox chckbxM = new JCheckBox("M");
		chckbxM.setBounds(279, 69, 33, 23);
		panelDatosPersona.add(chckbxM);
		
		JCheckBox chckbxF = new JCheckBox("F");
		chckbxF.setBounds(314, 69, 33, 23);
		panelDatosPersona.add(chckbxF);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(227, 47, 46, 14);
		panelDatosPersona.add(lblApellido);
		
		textField_3 = new JTextField();
		textField_3.setBounds(283, 44, 109, 20);
		panelDatosPersona.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar...");
		btnBuscar.setBounds(227, 18, 89, 23);
		panelDatosPersona.add(btnBuscar);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(10, 97, 46, 14);
		panelDatosPersona.add(lblTelfono);
		
		JFormattedTextField formattedTextFldTelefono = new JFormattedTextField();
		formattedTextFldTelefono.setText("(   )  -     - ");
		formattedTextFldTelefono.setBounds(90, 94, 109, 20);
		panelDatosPersona.add(formattedTextFldTelefono);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(10, 122, 67, 14);
		panelDatosPersona.add(lblDireccin);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(90, 119, 382, 20);
		panelDatosPersona.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JPanel panelDatosCita = new JPanel();
		panelDatosCita.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de la cita", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDatosCita.setBounds(10, 174, 492, 80);
		contentPanel.add(panelDatosCita);
		panelDatosCita.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 23, 46, 14);
		panelDatosCita.add(lblId);
		
		txtID = new JTextField();
		txtID.setBounds(90, 20, 106, 20);
		panelDatosCita.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(227, 23, 46, 14);
		panelDatosCita.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(283, 20, 86, 20);
		panelDatosCita.add(txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lblDoctor = new JLabel("Doctor:");
		lblDoctor.setBounds(10, 48, 46, 14);
		panelDatosCita.add(lblDoctor);
		
		 cbxDoctor = new JComboBox<String>();//lo mismo aquí le agregué tipo argumento como String para que se quitara el warning
		cbxDoctor.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>"}));
		cbxDoctor.setBounds(90, 45, 106, 20);
		panelDatosCita.add(cbxDoctor);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancel");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
