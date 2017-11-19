package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Consulta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2527505680250980586L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtNumAfiliado;
	private JTextField txtEdad;
	private JTextField txtCodigo;
	private JTextField txtDiagnostico;
	JComboBox<String> cmbEnfermedad;
	JComboBox<String> cmbAseguradora;
	JTextArea txtSintomas;
	JTextArea txtTratamiento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Consulta dialog = new Consulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Consulta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Consulta.class.getResource("/images/icon.png")));
		setResizable(false);
		setTitle("Consulta");
		setBounds(100, 100, 400, 572);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTabbedPane informacion = new JTabbedPane(JTabbedPane.TOP);
		informacion.setBounds(10, 11, 375, 488);
		contentPanel.add(informacion);
		
		JPanel consulta = new JPanel();
		JPanel historia = new JPanel();								//Creando los tabs
		JPanel vacunas = new JPanel();
		//JPanel panel_4 = new JPanel();
		//JPanel panel_5 = new JPanel();
		
		informacion.addTab("Datos de Consulta", consulta);
		consulta.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos de Cliente",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 354, 166);
		consulta.add(panel);
		panel.setLayout(null);
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(10, 21, 46, 14);
		panel.add(lblCdula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(10, 34, 143, 20);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(10, 69, 143, 20);
		panel.add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 56, 65, 14);
		panel.add(lblNombre);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(10, 104, 143, 20);
		panel.add(txtTelefono);
		
		JLabel lblTelfono_1 = new JLabel("Tel\u00E9fono:");
		lblTelfono_1.setBounds(10, 91, 65, 14);
		panel.add(lblTelfono_1);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(189, 104, 143, 20);
		panel.add(txtDireccion);
		
		JLabel lblApellido = new JLabel("Direcci\u00F3n:");
		lblApellido.setBounds(189, 91, 59, 14);
		panel.add(lblApellido);
		
		JLabel lblDireccin = new JLabel("Aseguradora:");
		lblDireccin.setBounds(189, 126, 83, 14);
		panel.add(lblDireccin);
		
		txtNumAfiliado = new JTextField();
		txtNumAfiliado.setColumns(10);
		txtNumAfiliado.setBounds(10, 139, 143, 20);
		panel.add(txtNumAfiliado);
		
		JLabel lblTelfono = new JLabel("N\u00FAmero Afiliado:");
		lblTelfono.setBounds(10, 126, 110, 14);
		panel.add(lblTelfono);
		
		cmbAseguradora = new JComboBox<String>();
		cmbAseguradora.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Senasa", "ARS Palic Salud", "ARS Humano", "ARS Monumental", "Semma"}));
		cmbAseguradora.setBounds(189, 139, 143, 20);
		panel.add(cmbAseguradora);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(187, 56, 46, 14);
		panel.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(189, 69, 65, 20);
		panel.add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblTipoDeSangre = new JLabel("Tipo Sangre:");
		lblTipoDeSangre.setBounds(261, 56, 71, 14);
		panel.add(lblTipoDeSangre);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<...>", "A+", "A-", "B-", "O-", "O+", "AB+", "AB-"}));
		comboBox.setBounds(261, 69, 71, 20);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos de Consulta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 188, 354, 267);
		consulta.add(panel_1);
		panel_1.setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(10, 34, 100, 20);
		panel_1.add(txtCodigo);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 21, 46, 14);
		panel_1.add(lblCdigo);
		
		JCheckBox chckbxAgregarAHistoria = new JCheckBox("Agregar a Historia Cl\u00EDnica");
		chckbxAgregarAHistoria.setBounds(144, 17, 178, 23);
		panel_1.add(chckbxAgregarAHistoria);
		
		JLabel lblSntomas = new JLabel("S\u00EDntomas:");
		lblSntomas.setBounds(10, 57, 72, 14);
		panel_1.add(lblSntomas);
		
		txtDiagnostico = new JTextField();
		txtDiagnostico.setColumns(10);
		txtDiagnostico.setBounds(10, 152, 161, 20);
		panel_1.add(txtDiagnostico);
		
		JLabel lblDiagnstico = new JLabel("Diagn\u00F3stico:");
		lblDiagnstico.setBounds(10, 139, 72, 14);
		panel_1.add(lblDiagnstico);
		
		JLabel lblTratamiento = new JLabel("Tratamiento:");
		lblTratamiento.setBounds(10, 176, 72, 14);
		panel_1.add(lblTratamiento);
		
		JLabel lblEnfermedadBajoVigilancia = new JLabel("Enfermedad bajo Vigilancia:");
		lblEnfermedadBajoVigilancia.setBounds(183, 139, 165, 14);
		panel_1.add(lblEnfermedadBajoVigilancia);
		
		cmbEnfermedad = new JComboBox<String>();
		cmbEnfermedad.setModel(new DefaultComboBoxModel<String>(new String[] {"<Ninguna>"}));
		cmbEnfermedad.setBounds(181, 152, 163, 20);
		panel_1.add(cmbEnfermedad);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 76, 334, 52);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneSintomas = new JScrollPane();
		panel_2.add(scrollPaneSintomas, BorderLayout.CENTER);
		scrollPaneSintomas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // Codigo para textArea
		txtSintomas = new JTextArea();
		txtSintomas.setLineWrap(true);
		scrollPaneSintomas.setViewportView(txtSintomas);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 192, 334, 64);
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneTratamiento = new JScrollPane();
		panel_3.add(scrollPaneTratamiento, BorderLayout.CENTER);
		scrollPaneTratamiento.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // Codigo para textArea
		txtTratamiento = new JTextArea();
		txtTratamiento.setLineWrap(true);
		scrollPaneTratamiento.setViewportView(txtTratamiento);
		
		
		informacion.addTab("Historia Clinica", historia);		// Agregando los tabs a la ventana
		historia.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Historia Cl\u00EDnica", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 28, 350, 404);
		historia.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(10, 25, 330, 336);
		panel_4.add(panel_5);
		
		JButton btnVerHistoriaClnica = new JButton("Ver Historia Cl\u00EDnica");
		btnVerHistoriaClnica.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnVerHistoriaClnica.setBounds(219, 372, 121, 23);
		panel_4.add(btnVerHistoriaClnica);
		informacion.addTab("Control de Vacunas", vacunas);
		vacunas.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Vacunas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(10, 53, 350, 364);
		vacunas.add(panel_6);
		panel_6.setLayout(null);
		//informacion.addTab("Panel 4", panel_4);
		//informacion.addTab("Panel 5", panel_5);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistar = new JButton("Guardar");
				btnRegistar.setActionCommand("OK");
				buttonPane.add(btnRegistar);
				getRootPane().setDefaultButton(btnRegistar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}


/*
 * 
 * Creado Por: Alejandro Col�n.
 * Fecha: 12/11/17
 * Anotaciones:
 */