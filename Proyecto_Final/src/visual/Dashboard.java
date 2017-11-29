package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import logical.Administrativo;
import logical.Cita;
import logical.Clinica;
import logical.Doctor;
import logical.Persona;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Dashboard extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1265006742634726451L;
	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel model;
	private static Object[] fila;
	private JTable tableCitas;
	private TableRowSorter<TableModel> trsFiltro;
	private JComboBox<String> cbxFiltro1;
	private JComboBox<String> cbxFiltro2;

	/**
	 * Launch the application.
	 */

	/*
	 * public static void main(String[] args) { try { Dashboard dialog = new
	 * Dashboard(); dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 * 
	 * /** Create the dialog.
	 */
	public Dashboard(Persona persona) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/images/icon.png")));
		setTitle("Principal");
		setBounds(100, 100, 987, 738);
		getContentPane().setLayout(new BorderLayout());

		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));

		JMenuBar menuBar = new JMenuBar();
		panel_3.add(menuBar);
		{
			JMenu mnInicio = new JMenu("Inicio");
			menuBar.add(mnInicio);
			{
				JMenuItem mntmCambiarUsuario = new JMenuItem("Cambiar usuario");
				mnInicio.add(mntmCambiarUsuario);
			}
			{
				JMenuItem mntmSalir = new JMenuItem("Salir");
				mnInicio.add(mntmSalir);
			}
		}
		{
			JMenu mnAdministrador = new JMenu("Administrador");
			menuBar.add(mnAdministrador);

			JMenuItem mntmRegistrarTrabajador = new JMenuItem("Registrar Trabajador");
			mntmRegistrarTrabajador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegUsuario frame =  new RegUsuario();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				
				}
			});
			mnAdministrador.add(mntmRegistrarTrabajador);

			JMenuItem mntmVerLista = new JMenuItem("Ver lista");
			mntmVerLista.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListaTrabajadores frame = new ListaTrabajadores();
					frame.setVisible(true);
				}
			});
			mnAdministrador.add(mntmVerLista);
		}
		{
			JMenu mnCitas = new JMenu("Citas");
			menuBar.add(mnCitas);

			JMenuItem mntmRegistrar = new JMenuItem("Registrar");
			mnCitas.add(mntmRegistrar);

			JMenuItem mntmModificarConsultante = new JMenuItem("Modificar Consultante");
			mnCitas.add(mntmModificarConsultante);
		}
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		{
			JPanel panelCita1 = new JPanel();
			panelCita1.setBackground(SystemColor.control);
			contentPanel.add(panelCita1);
			panelCita1.setLayout(new BorderLayout(0, 0));
			{
				JPanel panelCita2 = new JPanel();
				panelCita2.setBorder(
						new TitledBorder(null, "Citas para Hoy", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panelCita1.add(panelCita2);
				panelCita2.setLayout(null);
				{
					JPanel panel_TablaCita = new JPanel();
					panel_TablaCita.setBounds(10, 67, 440, 205);
					panelCita2.add(panel_TablaCita);
					panel_TablaCita.setLayout(new BorderLayout(0, 0));
					{
						JScrollPane scrollPane = new JScrollPane();
						panel_TablaCita.add(scrollPane, BorderLayout.CENTER);
						{
							tableCitas = new JTable();
							String[] columnNames = { "ID", "Feha", "Nombre" };
							model = new DefaultTableModel();
							model.setColumnIdentifiers(columnNames);
							tableCitas.setModel(model);
							LoadTable();
							scrollPane.setViewportView(tableCitas);

						}
					}
				}
				{
					JButton btnRealizarConsulta = new JButton("Realizar Consulta");
					btnRealizarConsulta.setFont(new Font("Tahoma", Font.PLAIN, 9));
					btnRealizarConsulta.setBounds(322, 283, 128, 23);
					panelCita2.add(btnRealizarConsulta);
					if (persona instanceof Administrativo) {
						btnRealizarConsulta.setVisible(false);
					}
				}

				trsFiltro = new TableRowSorter<TableModel>(tableCitas.getModel());
				tableCitas.setRowSorter(trsFiltro);

				JPanel panel_Filtro = new JPanel();
				panel_Filtro.setBounds(10, 22, 440, 34);
				panelCita2.add(panel_Filtro);
				panel_Filtro.setLayout(null);

				JLabel lblFiltro = new JLabel("Filtro:");
				lblFiltro.setBounds(10, 11, 46, 14);
				panel_Filtro.add(lblFiltro);

				cbxFiltro1 = new JComboBox<String>();
				cbxFiltro1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						filtro1();
					}
				});
				cbxFiltro1.setModel(new DefaultComboBoxModel<String>(new String[] { "<Seleccione>" }));
				cbxFiltro1.setBounds(84, 8, 116, 20);
				panel_Filtro.add(cbxFiltro1);

				cbxFiltro2 = new JComboBox<String>();
				cbxFiltro2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						filtro2();
					}
				});
				cbxFiltro2.setModel(new DefaultComboBoxModel<String>(new String[] { "<Seleccione>" }));
				cbxFiltro2.setBounds(210, 8, 116, 20);
				panel_Filtro.add(cbxFiltro2);

				JButton btnModificarCita = new JButton("Modificar cita");
				btnModificarCita.setFont(new Font("Tahoma", Font.PLAIN, 9));
				btnModificarCita.setBounds(322, 283, 128, 23);
				panelCita2.add(btnModificarCita);
				if (persona instanceof Doctor) {
					panel_Filtro.setVisible(false);
				} else if (persona instanceof Administrativo) {
					panel_Filtro.setVisible(true);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 102, 204));
			contentPanel.add(panel);
			panel.setLayout(null);

			JButton btnNewButton = new JButton("New button");
			btnNewButton.setBounds(118, 122, 89, 23);
			panel.add(btnNewButton);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 204, 204));
			contentPanel.add(panel);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(51, 255, 0));
			contentPanel.add(panel);
		}
		setLocationRelativeTo(null);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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

	private void LoadTable() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		Cita c = null;

		for (int i = 0; i < Clinica.getInstance().getMisCitas().size(); i++) {
			c = Clinica.getInstance().getMisCitas().get(i);

			fila[0] = c.getId();
			fila[1] = c.getFecha();
			fila[2] = c.getCitado().getNombre();
			model.addRow(fila);
		}

	}

	public void filtro1() {

		int columnaABuscar = 0;
		trsFiltro.setRowFilter(RowFilter.regexFilter(cbxFiltro1.getSelectedItem().toString(), columnaABuscar));
	}

	public void filtro2() {

		int columnaABuscar = 3;
		trsFiltro.setRowFilter(RowFilter.regexFilter(cbxFiltro2.getSelectedItem().toString(), columnaABuscar));
	}

}

/*
 * Creado por: Yamilka 12/11/17
 * 
 * Modificado por: Yamilka 27/11/2017
 * Anotaciones: agregar los fitros a la tabla de citas y el btnModifcarCitas, así como hacer que estos se deshabiliten o habiliten
 * dependiendo de quien está entrando(doctor o secre).
 */