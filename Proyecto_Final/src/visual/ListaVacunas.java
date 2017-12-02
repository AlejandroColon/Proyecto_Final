package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logical.Clinica;

import logical.Vacuna;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;

public class ListaVacunas extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4210123578828595912L;
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
			ListaVacunas dialog = new ListaVacunas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaVacunas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaVacunas.class.getResource("/images/icon.png")));
		setTitle("Listado de Vacunas");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 414, 206);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					table = new JTable();
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					String[] columnNames = { "Código", "Nombre", "Descripción" };
					model = new DefaultTableModel();
					model.setColumnIdentifiers(columnNames);
					table.setModel(model);
					loadTable();
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAtras = new JButton("Atr\u00E1s");
				btnAtras.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
				btnAtras.setIcon(new ImageIcon(ListaVacunas.class.getResource("/images/back.png")));
				btnAtras.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnAtras.setActionCommand("Cancel");
				buttonPane.add(btnAtras);
			}
		}
	}

	public void loadTable() {

		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];

		for (Vacuna aux : Clinica.getInstance().getMisVacunas()) {
			fila[0] = aux.getCodigo();
			fila[1] = aux.getNombre();
			fila[2] = aux.getDescricion();
			model.addRow(fila);

		}
	}

}
/*
 *Creado por: Yamilka 02/12/17 
 * */
