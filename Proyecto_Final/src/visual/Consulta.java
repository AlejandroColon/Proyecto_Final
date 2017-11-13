package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

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
	private JTextField txtTipoSangre;
	private JTextField txtCodigo;
	private JTextField txtSintoma;
	private JTextField txtDiagnostico;
	private JTextField txtTratamiento;
	JComboBox<String> cmbEnfermedad;
	JComboBox<String> cmbAseguradora;

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
		setBounds(100, 100, 450, 572);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTabbedPane informacion = new JTabbedPane(JTabbedPane.TOP);
		informacion.setBounds(10, 11, 424, 488);
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
		panel.setBounds(10, 11, 399, 166);
		consulta.add(panel);
		panel.setLayout(null);
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(10, 21, 46, 14);
		panel.add(lblCdula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(10, 34, 100, 20);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(45, 69, 143, 20);
		panel.add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(45, 56, 46, 14);
		panel.add(lblNombre);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(45, 104, 143, 20);
		panel.add(txtTelefono);
		
		JLabel lblTelfono_1 = new JLabel("Tel\u00E9fono:");
		lblTelfono_1.setBounds(45, 91, 65, 14);
		panel.add(lblTelfono_1);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(217, 104, 143, 20);
		panel.add(txtDireccion);
		
		JLabel lblApellido = new JLabel("Direcci\u00F3n:");
		lblApellido.setBounds(217, 91, 59, 14);
		panel.add(lblApellido);
		
		JLabel lblDireccin = new JLabel("Aseguradora:");
		lblDireccin.setBounds(217, 126, 83, 14);
		panel.add(lblDireccin);
		
		txtNumAfiliado = new JTextField();
		txtNumAfiliado.setColumns(10);
		txtNumAfiliado.setBounds(45, 139, 143, 20);
		panel.add(txtNumAfiliado);
		
		JLabel lblTelfono = new JLabel("N\u00FAmero Afiliado:");
		lblTelfono.setBounds(45, 126, 89, 14);
		panel.add(lblTelfono);
		
		cmbAseguradora = new JComboBox<String>();
		cmbAseguradora.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Senasa", "ARS Palic Salud", "ARS Humano", "ARS Monumental", "Semma"}));
		cmbAseguradora.setBounds(217, 139, 143, 20);
		panel.add(cmbAseguradora);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(217, 56, 46, 14);
		panel.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(214, 69, 30, 20);
		panel.add(txtEdad);
		txtEdad.setColumns(10);
		
		txtTipoSangre = new JTextField();
		txtTipoSangre.setColumns(10);
		txtTipoSangre.setBounds(295, 69, 30, 20);
		panel.add(txtTipoSangre);
		
		JLabel lblTipoDeSangre = new JLabel("Tipo de Sangre:");
		lblTipoDeSangre.setBounds(276, 56, 84, 14);
		panel.add(lblTipoDeSangre);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos de Consulta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 188, 399, 267);
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
		chckbxAgregarAHistoria.setBounds(248, 17, 145, 23);
		panel_1.add(chckbxAgregarAHistoria);
		
		txtSintoma = new JTextField();
		txtSintoma.setHorizontalAlignment(SwingConstants.TRAILING);
		txtSintoma.setColumns(10);
		txtSintoma.setBounds(10, 70, 383, 66);
		panel_1.add(txtSintoma);
		
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
		
		txtTratamiento = new JTextField();
		txtTratamiento.setColumns(10);
		txtTratamiento.setBounds(10, 189, 383, 66);
		panel_1.add(txtTratamiento);
		
		JLabel lblTratamiento = new JLabel("Tratamiento:");
		lblTratamiento.setBounds(10, 176, 72, 14);
		panel_1.add(lblTratamiento);
		
		JLabel lblEnfermedadBajoVigilancia = new JLabel("Enfermedad bajo Vigilancia:");
		lblEnfermedadBajoVigilancia.setBounds(228, 139, 145, 14);
		panel_1.add(lblEnfermedadBajoVigilancia);
		
		cmbEnfermedad = new JComboBox<String>();
		cmbEnfermedad.setBounds(226, 152, 147, 20);
		panel_1.add(cmbEnfermedad);
		
		
		informacion.addTab("Historia Clinica", historia);		// Agregando los tabs a la ventana
		informacion.addTab("Control de Vacunas", vacunas);
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
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}


/*
 * 
 * Creado Por: Alejandro Colón.
 * Fecha: 12/11/17
 * Anotaciones:
 */