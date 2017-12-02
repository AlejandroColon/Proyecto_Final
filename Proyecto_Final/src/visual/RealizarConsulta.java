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
import javax.swing.table.DefaultTableModel;

import logical.Cita;
import logical.Clinica;
import logical.Consulta;
import logical.Enfermedad;
import logical.Historial;
import logical.Paciente;
import logical.Persona;
import logical.Vacuna;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class RealizarConsulta extends JDialog {

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
	JComboBox<String> cmbSangre;
	private JTable tableHsitoriaClinica;
	private static DefaultTableModel model;
	private static Object[] fila;
	private static DefaultTableModel model2;
	private static Object[] fila2;
	private JTable tableVacuna;
	
	private ArrayList<Vacuna> vacunasAplicadas = new ArrayList<>();

	public RealizarConsulta(Persona p) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RealizarConsulta.class.getResource("/images/icon.png")));
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
		JPanel historia = new JPanel(); // Creando los tabs
		JPanel vacunas = new JPanel();
		// JPanel panel_4 = new JPanel();
		// JPanel panel_5 = new JPanel();

		informacion.addTab("Datos de Consulta", consulta);
		consulta.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos de Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 354, 166);
		consulta.add(panel);
		panel.setLayout(null);

		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(10, 21, 46, 14);
		panel.add(lblCdula);

		txtCedula = new JTextField();
		txtCedula.setEditable(false);
		txtCedula.setBounds(10, 34, 143, 20);
		panel.add(txtCedula);
		txtCedula.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(10, 69, 143, 20);
		panel.add(txtNombre);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 56, 65, 14);
		panel.add(lblNombre);

		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(10, 104, 143, 20);
		panel.add(txtTelefono);

		JLabel lblTelfono_1 = new JLabel("Tel\u00E9fono:");
		lblTelfono_1.setBounds(10, 91, 65, 14);
		panel.add(lblTelfono_1);

		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
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
		txtEdad.setEditable(false);
		txtEdad.setBounds(189, 69, 65, 20);
		panel.add(txtEdad);
		txtEdad.setColumns(10);

		JLabel lblTipoDeSangre = new JLabel("Tipo Sangre:");
		lblTipoDeSangre.setBounds(261, 56, 71, 14);
		panel.add(lblTipoDeSangre);

		cmbSangre = new JComboBox<String>();
		cmbSangre.setModel(new DefaultComboBoxModel<String>(
				new String[] { "--", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));
		cmbSangre.setBounds(261, 69, 71, 20);
		panel.add(cmbSangre);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Datos de Consulta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 188, 354, 267);
		consulta.add(panel_1);
		panel_1.setLayout(null);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
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
		cmbEnfermedad.setModel(new DefaultComboBoxModel<String>(new String[] { "<Ninguna>" }));
		cmbEnfermedad.setBounds(181, 152, 163, 20);
		panel_1.add(cmbEnfermedad);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 76, 334, 52);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPaneSintomas = new JScrollPane();
		panel_2.add(scrollPaneSintomas, BorderLayout.CENTER);
		scrollPaneSintomas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // Codigo para
																										// textArea
		txtSintomas = new JTextArea();
		txtSintomas.setLineWrap(true);
		scrollPaneSintomas.setViewportView(txtSintomas);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 192, 334, 64);
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPaneTratamiento = new JScrollPane();
		panel_3.add(scrollPaneTratamiento, BorderLayout.CENTER);
		scrollPaneTratamiento.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // Codigo para
																											// textArea
		txtTratamiento = new JTextArea();
		txtTratamiento.setLineWrap(true);
		scrollPaneTratamiento.setViewportView(txtTratamiento);

		informacion.addTab("Historia Clinica", historia); // Agregando los tabs a la ventana
		historia.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(
				new TitledBorder(null, "Historia Cl\u00EDnica", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 28, 350, 404);
		historia.add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(10, 25, 330, 336);
		panel_4.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_5.add(scrollPane, BorderLayout.CENTER);

		tableHsitoriaClinica = new JTable();
		String[] columnNames = { "ID", "Fecha" };
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		tableHsitoriaClinica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableHsitoriaClinica.setModel(model);
		scrollPane.setViewportView(tableHsitoriaClinica);

		JButton btnVerHistoriaClnica = new JButton("Ver Historia Cl\u00EDnica");
		btnVerHistoriaClnica.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnVerHistoriaClnica.setBounds(219, 372, 121, 23);
		panel_4.add(btnVerHistoriaClnica);
		informacion.addTab("Control de Vacunas", vacunas);
		vacunas.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Vacunas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(10, 29, 350, 405);
		vacunas.add(panel_6);
		panel_6.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(10, 21, 330, 342);
		panel_6.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_7.add(scrollPane_1, BorderLayout.CENTER);

		tableVacuna = new JTable();
		String[] columnNames2 = { "C�digo", "Nombre", "Estado" };
		model2 = new DefaultTableModel();
		model2.setColumnIdentifiers(columnNames2);
		tableVacuna.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableVacuna.setModel(model2);
		scrollPane_1.setViewportView(tableVacuna);
		
		JButton btnVacunaAplicada = new JButton("Vacuna Aplicada");
		btnVacunaAplicada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarVacuna();
			}
		});
		btnVacunaAplicada.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnVacunaAplicada.setBounds(219, 371, 121, 23);
		panel_6.add(btnVacunaAplicada);

		// informacion.addTab("Panel 4", panel_4);
		// informacion.addTab("Panel 5", panel_5);

		loadConsulta(p);
		txtCodigo.setText("CON-" + (Clinica.getInstance().getMisConsultas().size() + 1));
		llenarCMBEnfermedad();
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistar = new JButton("Guardar");
				btnRegistar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Enfermedad enf = null;
						
						try {
							if(Clinica.getInstance().findPacienteByCedula(txtCedula.getText()) == null) {
								String cedula = p.getCedula();
								String nombre = p.getNombre();
								String sexo = p.getSexo();
								int edad = Integer.parseInt(txtEdad.getText());
								String tipoSangre = cmbSangre.getSelectedItem().toString();
								String telefono = p.getTelefono();
								String direccion = p.getDireccion();
								String numeroAfiliado = txtNumAfiliado.getText();
								String aseguradora = cmbAseguradora.getSelectedItem().toString();

								Paciente aux = new Paciente(cedula, nombre, edad, tipoSangre, telefono, direccion, sexo,
										numeroAfiliado, aseguradora);
								Clinica.getInstance().addPaciente(aux);
							}
							
							String codigo = detCodigoHistoria(Clinica.getInstance().findPacienteByCedula(txtCedula.getText()));
							String fecha = fechaActual();
							String sintomas = txtSintomas.getText();
							String diagnostico = txtDiagnostico.getText();
							String tratamiento = txtTratamiento.getText();

							if (chckbxAgregarAHistoria.isSelected()) {
								if (!cmbEnfermedad.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>")) {
									enf = Clinica.getInstance().findEnfermedadByCodigo(determCodigoEnfermedad());
								}
								
								Historial hist = new Historial(codigo, fecha, sintomas, diagnostico, tratamiento, enf);

								Clinica.getInstance().addHistoriaPaciente(txtCedula.getText(), hist);

							}
							
							Consulta c = new Consulta(codigo, fecha, sintomas, diagnostico, tratamiento, enf, Clinica.getInstance().findPacienteByCedula(txtCedula.getText()));
							Clinica.getInstance().addConsulta(c);
							Clinica.getInstance().salvarConsultas();
							Clinica.getInstance().salvarPacientes();
							
							JOptionPane.showMessageDialog(null, "Consulta realizada exitosamente", "Informaci�n",
									JOptionPane.INFORMATION_MESSAGE);
							
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "TAMO ZUPENSO", "ERROR",
									JOptionPane.ERROR_MESSAGE);
							
						}
						

					}

					private String determCodigoEnfermedad() {
						String codigo = "";
						int size = cmbEnfermedad.getSelectedItem().toString().length(); 
						
						if(Clinica.getInstance().getMisEnfermedades().size()<10) {
							codigo = (cmbEnfermedad.getSelectedItem().toString()).substring(size - 6, size - 1);
						}else {
							codigo = (cmbEnfermedad.getSelectedItem().toString()).substring(size - 7, size - 1);
							
						}
						return codigo;
					}

					private String detCodigoHistoria(Paciente aux) {
						return "HIST-" + (aux.getMiHistorial().size() + 1);
					}

					private String fechaActual() {
						DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
						Date date = new Date();
						return dateFormat.format(date);
					}
				});
				btnRegistar.setActionCommand("OK");
				buttonPane.add(btnRegistar);
				getRootPane().setDefaultButton(btnRegistar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}

	private void llenarCMBEnfermedad() {
		boolean encontrado = false;
		cmbEnfermedad.removeAllItems(); // limpiando la info del cmb

		try {
			
			cmbEnfermedad.addItem(new String("<Seleccione>"));
			
			for (int i = 0; i < Clinica.getInstance().getMisEnfermedades().size(); i++) {
					cmbEnfermedad.addItem(new String(Clinica.getInstance().getMisEnfermedades().get(i).getNombre() + "  (" + 
							Clinica.getInstance().getMisEnfermedades().get(i).getCodigo() + ")"));
					encontrado = true;
				
			}

			if (encontrado) {
				//cmbEnfermedad.insertItemAt("<Seleccione>", 0);
				cmbEnfermedad.setSelectedItem(0);
				cmbEnfermedad.setSelectedItem(0);
			} else {
				cmbEnfermedad.removeAllItems(); 
				cmbEnfermedad.insertItemAt("<Seleccione>", 0);
				cmbEnfermedad.setSelectedItem(0);
				dispose();
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "EL PROGRAMA HA EXPLOTADO INESPERADAMENTE", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}

	private void loadConsulta(Persona p) {
		/*
		 * la idea es que hay una lista de consultantes y de pacientes. dependiendo si
		 * la persoan pasada por parametro es paciente o no, se procede de manera
		 * distinta (al momento de cargar info)...
		 * 
		 */

		if (p != null) {

			Paciente person = Clinica.getInstance().findPacienteByCedula(p.getCedula());
			
			if (person != null) {
				txtCedula.setText(p.getCedula());
				txtNombre.setText(p.getNombre());
				txtDireccion.setText(p.getDireccion());
				txtEdad.setText("" + p.getEdad());
				txtTelefono.setText(p.getTelefono());
				txtNumAfiliado.setText(person.getNumeroAfiliado());
				cmbAseguradora.setSelectedIndex(determinarAseguradora(person));
				cmbSangre.setSelectedIndex(determinarSangre(person));
				cargarHistoriaClinica(person);
				cargarVacunas(person);
			} else {
				txtCedula.setText(p.getCedula());
				txtNombre.setText(p.getNombre());
				txtDireccion.setText(p.getDireccion());
				txtEdad.setText("" + p.getEdad());
				txtTelefono.setText(p.getTelefono());
				llenarTablaVacunas();
			}

		} else {

		}

	}

	private void llenarTablaVacunas() {
		model2.setRowCount(0);
		fila2 = new Object[model2.getColumnCount()];
		Vacuna v = null;

		for (int i = 0; i < Clinica.getInstance().getMisVacunas().size(); i++) {
			v = Clinica.getInstance().getMisVacunas().get(i);
			fila2[0] = v.getCodigo();
			fila2[1] = v.getNombre();
			fila2[2] = "No Aplicada";

			model2.addRow(fila2);
		}
	}

	private void cargarVacunas(Persona p) {
		model2.setRowCount(0);
		fila2 = new Object[model2.getColumnCount()];
		Vacuna v = null;

		vacunasAplicadas = ((Paciente) p).getMisVacunas();
		
		for (int i = 0; i < Clinica.getInstance().getMisVacunas().size(); i++) {
			boolean encontrado = false;
			v = Clinica.getInstance().getMisVacunas().get(i);

			fila2[0] = v.getCodigo();
			fila2[1] = v.getNombre();

			for (int j = 0; j < ((Paciente) p).getMisVacunas().size(); j++) {
				if (((Paciente) p).getMisVacunas().get(j).getCodigo().equalsIgnoreCase(v.getCodigo())) {
					encontrado = true;
				}
			}

			if (encontrado)
				fila2[2] = "Aplicada";
			else
				fila2[2] = "No Aplicada";

			model2.addRow(fila2);
		}
	}

	private void cargarHistoriaClinica(Persona p) {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		Historial h = null;

		for (int i = 0; i < ((Paciente) p).getMiHistorial().size(); i++) {
			h = ((Paciente) p).getMiHistorial().get(i);

			fila[0] = h.getCodigo();
			fila[1] = h.getFecha();
			model.addRow(fila);
		}

	}

	private int determinarSangre(Paciente p) {
		int i = 0;
		boolean encontrado = false;

		while (!encontrado && i < 9) {
			if (p.getTipoSangre().equalsIgnoreCase(cmbSangre.getItemAt(i).toString())) {
				encontrado = true;
			}
			i++;
		}

		return i - 1;
	}

	private int determinarAseguradora(Paciente p) {
		int i = 0;
		boolean encontrado = false;

		while (!encontrado && i < 6) {
			if (p.getAseguradora().equalsIgnoreCase(cmbAseguradora.getItemAt(i).toString())) {
				encontrado = true;
			}
			i++;
		}

		return i - 1;
	}
	
	private void agregarVacuna() {
		int column = 0;
		int row = tableVacuna.getSelectedRow();
		String value = tableVacuna.getModel().getValueAt(row, column).toString();
		
		if(value.equalsIgnoreCase("No Aplicada")) {
			vacunasAplicadas.add(Clinica.getInstance().findVacunaByCodigo(value));
		}
	}
}

/*
 * 
 * Creado Por: Alejandro Col�n. Fecha: 12/11/17 Anotaciones:
 * 
 * 
 * Creado Por: Alejandro Col�n. Fecha: 30/11/17 Anotaciones: agregar paciente
 *
 */