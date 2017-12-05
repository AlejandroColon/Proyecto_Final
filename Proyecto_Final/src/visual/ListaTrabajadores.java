package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logical.Clinica;
import logical.Doctor;
import logical.Persona;
import logical.Trabajador;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class ListaTrabajadores extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7253324665998954150L;
	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaTrabajadores dialog = new ListaTrabajadores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaTrabajadores() {
		setBackground(Color.WHITE);
		setTitle("Listado de usuarios");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaTrabajadores.class.getResource("/images/icon.png")));
		setResizable(false);
		setBounds(100, 100, 450, 393);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				String[] columnNames = {"Cédula", "Nombre","Posición","Usuario"};
				model = new DefaultTableModel();
				model.setColumnIdentifiers(columnNames);
				table.setModel(model);
				loadTable();
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(102, 153, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Atr\u00E1s");
				okButton.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
				okButton.setIcon(new ImageIcon(ListaTrabajadores.class.getResource("/images/back.png")));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

	public void loadTable() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for(Persona trabaja : Clinica.getInstance().getMisPersonas()) {
			if(trabaja instanceof Trabajador) {
				fila[0] = trabaja.getCedula();
				fila[1] = trabaja.getNombre();
					if(trabaja instanceof Doctor) {
						fila[2] = "Doctor";
					}else
						fila[2] = "Adm.";
				fila[3] = ((Trabajador) trabaja).getUsuario();
				model.addRow(fila);
			}
		}
		
	}

}
/*
 * Creado por: Oscar Rodriguez.
 * Fecha: 20/11/2017
 * 
 */
