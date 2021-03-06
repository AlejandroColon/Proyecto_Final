package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Administrativo;
import logical.Cita;
import logical.Clinica;
import logical.Doctor;
import logical.Enfermedad;
import logical.Paciente;
import logical.Persona;
import logical.Vacuna;

import java.awt.Toolkit;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Principal extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2338171001859749383L;
	private JPanel contentPane;
	private JTable tableCitas;
	private static DefaultTableModel model;
	private static DefaultTableModel model2;
	private static Object[] fila;
	private static Object[]fila2;
	JComboBox<String> cbxFiltro;
	private JTable tableEnfermedades;
	public static JPanel panel_4;
	public static JPanel panel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					Clinica.getInstance().leerCitas();
					Clinica.getInstance().leerConsultas();
					Clinica.getInstance().leerEnfermedades();
					Clinica.getInstance().leerPersonas();
					Clinica.getInstance().leerVacunas();
					Clinica.getInstance().leerPacientes();
					// Thread.sleep(3000);
				} catch (ClassNotFoundException | IOException e) {

				}
				
				/*
				  Persona p = new Doctor("050-0022526-4","Dr. Maunel Perez","25/11/1980","809-589-9858","Padre las casas, No 1","M","doctor","123"
				  ,"DC859588","Cirujano General",3); 
				  Clinica.getInstance().addPersona(p); 
				  Persona p2 = new  Administrativo("402-8566965-3","Lic. Manuela Pereza","12/05/1990",
				  "829-987-1782","Calle , Esq 4 No2 (La loteria)","F","secre","123");
				  Clinica.getInstance().addPersona(p2);
			*/
				
				Login log = new Login();
				log.setVisible(true);
				log.setLocationRelativeTo(null);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal(Persona person) {

		Persona p = person;

		setResizable(false);
		setTitle("Dashboard Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/images/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1101, 731);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnInicio = new JMenu("Inicio");
		mnInicio.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		mnInicio.setIcon(new ImageIcon(Principal.class.getResource("/images/001-caduceus-1.png")));
		menuBar.add(mnInicio);

		JMenuItem mntmCambiarDeUsuario = new JMenuItem("Cambiar de Usuario");
		mntmCambiarDeUsuario.setIcon(new ImageIcon(Principal.class.getResource("/images/switch.png")));
		mntmCambiarDeUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		mntmCambiarDeUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Login frame = new Login();
					frame.dispose();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					dispose();
			}
		});
		mnInicio.add(mntmCambiarDeUsuario);

		JMenuItem mntmCerrarSesin = new JMenuItem("Salir del Programa");
		mntmCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmCerrarSesin.setIcon(new ImageIcon(Principal.class.getResource("/images/exit.png")));
		mntmCerrarSesin.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		mnInicio.add(mntmCerrarSesin);

		JMenu mnAdministrativo = new JMenu("Administrativo");
		mnAdministrativo.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		mnAdministrativo.setIcon(new ImageIcon(Principal.class.getResource("/images/nurse.png")));
		
		if(p instanceof Administrativo) {
			menuBar.add(mnAdministrativo);
		}
		

		JMenuItem mntmRegistrarEmpleado = new JMenuItem("Registrar Empleado");
		mntmRegistrarEmpleado.setIcon(new ImageIcon(Principal.class.getResource("/images/worker.png")));
		mntmRegistrarEmpleado.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		mntmRegistrarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarUsuario frame = new RegistrarUsuario();
				frame.dispose();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		mnAdministrativo.add(mntmRegistrarEmpleado);

		JMenuItem mntmModificarEmpleado = new JMenuItem("Modificar Empleado");
		mntmModificarEmpleado.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		mntmModificarEmpleado.setIcon(new ImageIcon(Principal.class.getResource("/images/003-edit.png")));
		//mnAdministrativo.add(mntmModificarEmpleado);
		
		JMenuItem mntmListaDeEmpleados = new JMenuItem("Lista de Empleados");
		mntmListaDeEmpleados.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		mntmListaDeEmpleados.setIcon(new ImageIcon(Principal.class.getResource("/images/004-notepad.png")));
		mntmListaDeEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaTrabajadores frame = new ListaTrabajadores();
				frame.dispose();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		mnAdministrativo.add(mntmListaDeEmpleados);

		JMenu mnCitas = new JMenu("Citas");
		mnCitas.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		mnCitas.setIcon(new ImageIcon(Principal.class.getResource("/images/stethoscope.png")));
		
		if(p instanceof Administrativo) {
		menuBar.add(mnCitas);
		}

		JMenuItem mntmRegistrarCita = new JMenuItem("Registrar Cita");
		mntmRegistrarCita.setIcon(new ImageIcon(Principal.class.getResource("/images/note.png")));
		mntmRegistrarCita.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		mntmRegistrarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCita frame = new RegistrarCita();
				frame.dispose();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		mnCitas.add(mntmRegistrarCita);

		JMenuItem mntmModificarCita = new JMenuItem("Modificar Cita");
		mntmModificarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarCita mCita = new ModificarCita();
				mCita.setVisible(true);
				mCita.setLocationRelativeTo(null);
			}
		});
		mntmModificarCita.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		mntmModificarCita.setIcon(new ImageIcon(Principal.class.getResource("/images/003-edit.png")));
		mnCitas.add(mntmModificarCita);
		
		JMenu mnControl = new JMenu("Control");
		mnControl.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		mnControl.setIcon(new ImageIcon(Principal.class.getResource("/images/002-notepad.png")));
		menuBar.add(mnControl);
		
		JMenuItem mntmRegistrarEnfermedad = new JMenuItem("Registrar Enfermedad");
		mntmRegistrarEnfermedad.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		mntmRegistrarEnfermedad.setIcon(new ImageIcon(Principal.class.getResource("/images/biohazard.png")));
		mntmRegistrarEnfermedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarEnfermedad frame = new RegistrarEnfermedad();
				frame.dispose();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		mnControl.add(mntmRegistrarEnfermedad);
		
		JMenuItem mntmRegistrarVacuna = new JMenuItem("Registrar Vacuna");
		mntmRegistrarVacuna.setIcon(new ImageIcon(Principal.class.getResource("/images/012-syringe.png")));
		mntmRegistrarVacuna.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		mntmRegistrarVacuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarVacunas frame = new RegistrarVacunas();
				//frame.dispose();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		mnControl.add(mntmRegistrarVacuna);
		
		JMenuItem mntmModificiarEnfermedad = new JMenuItem("Ver Enfermedades");
		mntmModificiarEnfermedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarEnfermedades lEnf = new ListarEnfermedades();
				lEnf.setVisible(true);
				lEnf.setLocationRelativeTo(null);
			}
		});
		mntmModificiarEnfermedad.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		mntmModificiarEnfermedad.setIcon(new ImageIcon(Principal.class.getResource("/images/003-edit.png")));
		mnControl.add(mntmModificiarEnfermedad);
		
		JMenuItem mntmModificarVacuna = new JMenuItem("Ver Vacunas");
		mntmModificarVacuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaVacunas lVacuna = new ListaVacunas();
				lVacuna.setVisible(true);
				lVacuna.setLocationRelativeTo(null);
			}
		});
		mntmModificarVacuna.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		mntmModificarVacuna.setIcon(new ImageIcon(Principal.class.getResource("/images/003-edit.png")));
		mnControl.add(mntmModificarVacuna);
		
		JMenu mnPacientes = new JMenu("Pacientes");
		mnPacientes.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		mnPacientes.setIcon(new ImageIcon(Principal.class.getResource("/images/002-paciente-1.png")));
		
		if(p instanceof Doctor) {
			menuBar.add(mnPacientes);
		}
		
		
		JMenuItem mntmVerPacientes = new JMenuItem("Ver pacientes");
		mntmVerPacientes.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		mntmVerPacientes.setIcon(new ImageIcon(Principal.class.getResource("/images/001-lista.png")));
		mntmVerPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerRegPacientes aux = new VerRegPacientes();
				aux.setVisible(true);
				aux.setLocationRelativeTo(null);
			}
		});
		mnPacientes.add(mntmVerPacientes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panelCitas = new JPanel();
		panelCitas.setBackground(Color.WHITE);
		panelCitas.setBorder(new TitledBorder(null, "Citas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panelCitas, BorderLayout.CENTER);
		panelCitas.setLayout(null);

		JPanel panelTabla = new JPanel();
		panelTabla.setBounds(20, 61, 512, 226);
		panelCitas.add(panelTabla);
		panelTabla.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelTabla.add(scrollPane, BorderLayout.CENTER);

		tableCitas = new JTable();
		if (p instanceof Administrativo) {
			String[] columnNames = { "ID", "Feha", "Paciente", "Doctor" };
			model = new DefaultTableModel();
			model.setColumnIdentifiers(columnNames);
			tableCitas.setModel(model);
			LoadTableAdministrativo();
			scrollPane.setViewportView(tableCitas);
		} else {
			String[] columnNames = { "ID", "Feha", "Paciente" };
			model = new DefaultTableModel();
			model.setColumnIdentifiers(columnNames);
			tableCitas.setModel(model);
			LoadTableDoctor(p);
			scrollPane.setViewportView(tableCitas);
		}
		scrollPane.setViewportView(tableCitas);

		JButton btnConsulta = new JButton("Realizar Consulta");
		btnConsulta.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int column = 0;
				int row = tableCitas.getSelectedRow();
				String value = tableCitas.getModel().getValueAt(row, column).toString();
				Cita c = Clinica.getInstance().findCitaByID(value);
				RealizarConsulta frame = new RealizarConsulta(c.getCitado(), c.getId(), p.getCedula());
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);

			}
		});
		btnConsulta.setBounds(397, 298, 135, 23);
		panelCitas.add(btnConsulta);

		if (p instanceof Administrativo) {
			btnConsulta.setVisible(false);
		} else {
			btnConsulta.setVisible(true);
		}

		JPanel panelFiltro = new JPanel();
		panelFiltro.setBackground(Color.WHITE);
		panelFiltro.setBounds(20, 23, 512, 38);
		panelCitas.add(panelFiltro);
		panelFiltro.setLayout(null);
		
		if (p instanceof Administrativo) {
			panelFiltro.setVisible(true);
		} else {
			panelFiltro.setVisible(false);
		}

		JLabel lblFiltrarCitas = new JLabel("Filtrar Citas:");
		lblFiltrarCitas.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		lblFiltrarCitas.setBounds(10, 11, 76, 14);
		panelFiltro.add(lblFiltrarCitas);

		cbxFiltro = new JComboBox<String>();
		cbxFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cbxFiltro.getSelectedIndex()==0) {
					LoadTableAdministrativo();
				}else {
					int size = cbxFiltro.getSelectedItem().toString().length(); 
					String cedula = (cbxFiltro.getSelectedItem().toString()).substring(size - 14, size - 1);
					
					loadTablaFiltrada(cedula);
				}
				
			}

			private void loadTablaFiltrada(String cedula) {
				model.setRowCount(0);
				fila = new Object[model.getColumnCount()];
				Cita c = null;

				for (int i = 0; i < Clinica.getInstance().getMisCitas().size(); i++) {
					c = Clinica.getInstance().getMisCitas().get(i);
					if(c.isEstado()) {
						if(c.getDoctor().getCedula().equalsIgnoreCase(cedula)) {
							fila[0] = c.getId();
							fila[1] = c.getFecha();
							fila[2] = c.getCitado().getNombre();
							fila[3] = c.getDoctor().getNombre();
							model.addRow(fila);
						}
					}
				}
			}
		});
		cbxFiltro.setBounds(96, 8, 125, 19);
		panelFiltro.add(cbxFiltro);
		
		if(p instanceof Administrativo) {
			cbxFiltro.removeAllItems();
			cbxFiltro.addItem(new String("<Seleccione>"));
			for(Persona aux : Clinica.getInstance().getMisPersonas()) {
				if(aux instanceof Doctor) {
					cbxFiltro.addItem(new String(aux.getNombre() + " (" + aux.getCedula() + ")"));
				}
			}
			cbxFiltro.setSelectedIndex(0);
		}
		

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Porcentaje Por Enfermedad", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(95, 62, 437, 222);
		panel_2.add(scrollPane_1);
		
		tableEnfermedades = new JTable();
		String[] columnNames = {"Codigo","Nombre","Porcetaje enfermos"};
		model2 = new DefaultTableModel();
		model2.setColumnIdentifiers(columnNames);
		tableEnfermedades.setModel(model2);
		loadTableEnfermedades();
		scrollPane_1.setViewportView(tableEnfermedades);

		panel_3 = new JPanel();
		panel_3.setBackground(Color.MAGENTA);
		panel.add(panel_3);
		
		
		

		 
        
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 11, 522, 311);
		

		panel_4 = new JPanel();
		panel_4.setBackground(Color.CYAN);
		panel.add(panel_4);
		
		crearGraficaEnfermedades();
			 crearGraficaBarras();
			
	}
	
	public static void crearGraficaEnfermedades() {
		 DefaultPieDataset data = new DefaultPieDataset();
		  for (Enfermedad aux : Clinica.getInstance().getMisEnfermedades()) {
			  data.setValue(aux.getNombre(), Clinica.getInstance().datosEstadistica(aux.getCodigo()));
		}
		  data.setValue("No enfermos", Clinica.getInstance().estadisticaNoEnfermos());
	       
	 
	        // Creando el Grafico
	        JFreeChart chart = ChartFactory.createPieChart3D(
	         "Estadística de Enfermedades Bajo Vigilancia", 
	         data, 
	         true, 
	         true, 
	         false);
	        panel_3.setLayout(null);
	        panel_3.setLayout(new BorderLayout(0, 0));
	 
	        
	        // Crear el Panel del Grafico con ChartPanel
	        ChartPanel chartPanel = new ChartPanel(chart);
	        chartPanel.setHorizontalAxisTrace(false);
	        chartPanel.setFillZoomRectangle(false);
	        chartPanel.setEnforceFileExtensions(false);
	        chartPanel.setMouseWheelEnabled(true);
	        chartPanel.setBounds(0, 0, 540, 325);
	       panel_3.add(chartPanel);
	}
	
	public static void crearGraficaBarras() {

		         
	      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );         
	     
	      llenarDataset(dataset);
	      
	      JFreeChart barChart = ChartFactory.createBarChart3D(
	         "Control de Vacunas",             
	         "Vacuna",             
	         "Cantidad",             
	         dataset,            
	         PlotOrientation.VERTICAL,             
	         true, true, false);
	      panel_4.setLayout(new BorderLayout(0, 0));
	      
	      ChartPanel chartPanel2 = new ChartPanel(barChart);
	        chartPanel2.setHorizontalAxisTrace(false);
	        chartPanel2.setFillZoomRectangle(false);
	        chartPanel2.setEnforceFileExtensions(false);
	        chartPanel2.setMouseWheelEnabled(false);
	        chartPanel2.setEnabled(false);
	        chartPanel2.setBounds(0, 0, 540, 325);
	       panel_4.add(chartPanel2);
		
	}

	public static void llenarDataset(DefaultCategoryDataset dataset) {
		int cant = 0;
		for(Vacuna aux : Clinica.getInstance().getMisVacunas()) {
			String vac = aux.getNombre();
			cant = 0;
			for(Paciente p : Clinica.getInstance().getMisPacientes()) {
				for(Vacuna vacuna : p.getMisVacunas()) {
					if(vacuna.getCodigo().equalsIgnoreCase(aux.getCodigo()))
						cant++;
				}
			}
			
			dataset.addValue( cant , "Vacunados" , vac); 
			dataset.addValue( Clinica.getInstance().getMisPacientes().size() , "Total" , vac);
		}
		
		 
	}

	public static void LoadTableAdministrativo() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		Cita c = null;

		for (int i = 0; i < Clinica.getInstance().getMisCitas().size(); i++) {
			c = Clinica.getInstance().getMisCitas().get(i);
			if(c.isEstado()) {
				fila[0] = c.getId();
			fila[1] = c.getFecha();
			fila[2] = c.getCitado().getNombre();
			fila[3] = c.getDoctor().getNombre();
			model.addRow(fila);
			}
		}

	}

	public static void LoadTableDoctor(Persona p) {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		Cita c = null;

		for (int i = 0; i < Clinica.getInstance().getMisCitas().size(); i++) {
			c = Clinica.getInstance().getMisCitas().get(i);
			if (c.getDoctor().getCedula().equalsIgnoreCase(p.getCedula())) {
				if(c.isEstado()) {
					if(c.getFecha().equalsIgnoreCase(fechaActual()))
					{
						fila[0] = c.getId();
						fila[1] = c.getFecha();
						fila[2] = c.getCitado().getNombre();
						model.addRow(fila);
					}
				}
			}
		}
	}
	public static void loadTableEnfermedades() {
		model2.setRowCount(0);
		fila2 = new Object[model2.getColumnCount()];
		Enfermedad f = null;

		for (int i = 0; i < Clinica.getInstance().getMisEnfermedades().size(); i++) {
			f = Clinica.getInstance().getMisEnfermedades().get(i);				
						fila2[0] = f.getCodigo();
						fila2[1] = f.getNombre();
						fila2[2] = Clinica.getInstance().porcentajeEnf(f.getNombre());
						model2.addRow(fila2);			
		}
	}

	private static String fechaActual() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
/*
 * Creado por: Alejandro
 * Modificaciones: Yamilka 02/12/17
 * Agregando los iconos al menu de opciones y dando formato a las letras
 */
