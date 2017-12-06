package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logical.Clinica;
import logical.Paciente;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class VerRegPacientes extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6413522761755484805L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object[] fila;
	private static DefaultTableModel model;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public VerRegPacientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerRegPacientes.class.getResource("/images/icon.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 206);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		{   table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String[] columnNames = {"Cédula","Nombre"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		loadTable();
		scrollPane.setViewportView(table);
	}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(102, 153, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnVerPaciente = new JButton("Ver paciente");
				btnVerPaciente.setIcon(new ImageIcon(VerRegPacientes.class.getResource("/images/magnifying-glass.png")));
				btnVerPaciente.addActionListener(new ActionListener() {
				
					public void actionPerformed(ActionEvent e) {
						
						int column = 0;
						int row = table.getSelectedRow();
						String value = table.getModel().getValueAt(row, column).toString();
						JOptionPane.showMessageDialog(null, value, "Advertencia",
								JOptionPane.WARNING_MESSAGE);
						DatosPacientes aux = new DatosPacientes(value);
						aux.setVisible(true);
						aux.setLocationRelativeTo(null);
						
					
					}
				
				});
				btnVerPaciente.setActionCommand("OK");
				buttonPane.add(btnVerPaciente);
				getRootPane().setDefaultButton(btnVerPaciente);
			}
			{
				JButton btnAtrás = new JButton("Atr\u00E1s");
				btnAtrás.setIcon(new ImageIcon(VerRegPacientes.class.getResource("/images/back.png")));
				btnAtrás.setActionCommand("Cancel");
				buttonPane.add(btnAtrás);
			}
		}
	}
	
	public void loadTable(){
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Paciente miPaciente : Clinica.getInstance().getMisPacientes()) {
			fila[0]= miPaciente.getCedula();
			fila[1]= miPaciente.getNombre();
			model.addRow(fila);

		}
	}
}
/*
 * Creado por Yamilka 06/12/17
 */
