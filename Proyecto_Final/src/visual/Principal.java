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
import logical.Persona;

import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2338171001859749383L;
	private JPanel contentPane;
	private JTable tableCitas;
	private static DefaultTableModel model;
	private static Object[] fila;
	JComboBox<String> cmbFiltro;

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
				//Persona aux = Clinica.getInstance().getMisPersonas().get(1);
				//Principal frame = new Principal(aux);
				//frame.setVisible(true);
				//frame.setLocationRelativeTo(null);
				/*
				  Persona p = new Doctor("050-0022526-4","Dr. Maunel Perez",10,"809-","casa","m","doctor","123"
				  ,"abc","Cirujano",3); 
				  Clinica.getInstance().addPersona(p); 
				  Persona p2 = new  Administrativo("402-8566965-3","Lic. Manuela Pereza",15,
				  "829","la casa de manuel","F","secre","abc");
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
		menuBar.add(mnInicio);

		JMenuItem mntmCambiarDeUsuario = new JMenuItem("Cambiar de Usuario");
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
		mnInicio.add(mntmCerrarSesin);

		JMenu mnAdministrativo = new JMenu("Administrativo");
		menuBar.add(mnAdministrativo);

		JMenuItem mntmRegistrarEmpleado = new JMenuItem("Registrar Empleado");
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
		mnAdministrativo.add(mntmModificarEmpleado);
		
		JMenuItem mntmListaDeEmpleados = new JMenuItem("Lista de Empleados");
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
		menuBar.add(mnCitas);

		JMenuItem mntmRegistrarCita = new JMenuItem("Registrar Cita");
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
		mnCitas.add(mntmModificarCita);
		
		JMenu mnControl = new JMenu("Control");
		menuBar.add(mnControl);
		
		JMenuItem mntmRegistrarEnfermedad = new JMenuItem("Registrar Enfermedad");
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
		mntmRegistrarVacuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarVacunas frame = new RegistrarVacunas();
				//frame.dispose();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		mnControl.add(mntmRegistrarVacuna);
		
		JMenuItem mntmModificiarEnfermedad = new JMenuItem("Modificiar Enfermedad");
		mnControl.add(mntmModificiarEnfermedad);
		
		JMenuItem mntmModificarVacuna = new JMenuItem("Modificar Vacuna");
		mnControl.add(mntmModificarVacuna);
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
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int column = 0;
				int row = tableCitas.getSelectedRow();
				String value = tableCitas.getModel().getValueAt(row, column).toString();
				Cita c = Clinica.getInstance().findCitaByID(value);
				RealizarConsulta frame = new RealizarConsulta(c.getCitado());
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
		panelFiltro.setBounds(20, 23, 259, 38);
		panelCitas.add(panelFiltro);
		panelFiltro.setLayout(null);
		
		if (p instanceof Administrativo) {
			panelFiltro.setVisible(true);
		} else {
			panelFiltro.setVisible(false);
		}

		JLabel lblFiltrarCitas = new JLabel("Filtrar Citas:");
		lblFiltrarCitas.setBounds(10, 11, 76, 14);
		panelFiltro.add(lblFiltrarCitas);

		cmbFiltro = new JComboBox<String>();
		cmbFiltro.setBounds(96, 8, 125, 19);
		panelFiltro.add(cmbFiltro);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.ORANGE);
		panel.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.MAGENTA);
		panel.add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.CYAN);
		panel.add(panel_4);
	}

	private void LoadTableAdministrativo() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		Cita c = null;

		for (int i = 0; i < Clinica.getInstance().getMisCitas().size(); i++) {
			c = Clinica.getInstance().getMisCitas().get(i);

			fila[0] = c.getId();
			fila[1] = c.getFecha();
			fila[2] = c.getCitado().getNombre();
			fila[3] = c.getDoctor().getNombre();
			model.addRow(fila);
		}

	}

	public void LoadTableDoctor(Persona p) {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		Cita c = null;

		for (int i = 0; i < Clinica.getInstance().getMisCitas().size(); i++) {
			c = Clinica.getInstance().getMisCitas().get(i);
			if (c.getDoctor().getCedula().equalsIgnoreCase(p.getCedula())) {
				fila[0] = c.getId();
				fila[1] = c.getFecha();
				fila[2] = c.getCitado().getNombre();
				model.addRow(fila);
			}
		}
	}
}
