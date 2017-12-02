package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logical.Clinica;
import logical.Enfermedad;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class ListarEnfermedades extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2447461608294750823L;
	/**
	 * 
	 */

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object[] fila;
	private static DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarEnfermedades dialog = new ListarEnfermedades();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarEnfermedades() {
		setTitle("Listado de Enfermedades");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarEnfermedades.class.getResource("/images/icon.png")));
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
			String[] columnNames = {"Código", "Nombre","Descripción"};
			model = new DefaultTableModel();
			model.setColumnIdentifiers(columnNames);
			table.setModel(model);
			loadTable();
			scrollPane.setViewportView(table);
		}
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCancelar = new JButton("Atr\u00E1s");
				btnCancelar.setIcon(new ImageIcon(ListarEnfermedades.class.getResource("/images/back.png")));
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
	
	public void loadTable(){
		
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		
		for (Enfermedad aux : Clinica.getInstance().getMisEnfermedades()) {
			fila[0]= aux.getCodigo();
			fila[1]= aux.getNombre();
			fila[2]= aux.getDescricion();
			model.addRow(fila);
			
		}
	}
}

/*
 * Creado por: Yamilka 02/12/17
 * 
 * 
 */
