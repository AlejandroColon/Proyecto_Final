package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class PrincipalSecre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3289679350861074097L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	// private static Object[] fila;
	private JComboBox <String> cbxDoctor;//OJO AQUÍ, al cbx le puse un tipo string para que se quitara el warning meanwhile
	private JComboBox<String> cbxFecha;//OJO AQUÍ, al cbx le puse un tipo string para que se quitara el warning meanwhile

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PrincipalSecre dialog = new PrincipalSecre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PrincipalSecre() {
		setTitle("Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalSecre.class.getResource("/images/icon.png")));
		setResizable(false);
		setBounds(100, 100, 533, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JLabel labelHora = new JLabel("00:00 a.m.");
		labelHora.setFont(new Font("Cambria Math", Font.PLAIN, 25));
		labelHora.setBounds(384, 12, 123, 22);
		contentPanel.add(labelHora);
		// Dando formato a la tabla
		{
			String[] columnNames = { "ID", "Fecha", "Doctor", "Persona" };
			model = new DefaultTableModel();
			model.setColumnIdentifiers(columnNames);
		}

		JLabel label = new JLabel("01/01/17");
		label.setBounds(384, 37, 66, 14);
		contentPanel.add(label);

		
			JPanel panelTablaCitas = new JPanel();
			panelTablaCitas
					.setBorder(new TitledBorder(null, "Citas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelTablaCitas.setBounds(10, 62, 497, 155);
			contentPanel.add(panelTablaCitas);
			panelTablaCitas.setLayout(new BorderLayout(0, 0));

			JScrollPane scrollPane = new JScrollPane();
			panelTablaCitas.add(scrollPane, BorderLayout.CENTER);

			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//aqui lo que hago es quedarse con el indetificador de lo que tengo seleccionado y con este string busco el objt				
				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//se crea un arreglo de string con los nombres de la col de mi tabla
			table.setModel(model);
			//loadTable();
			scrollPane.setViewportView(table);
		

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 18, 46, 14);
		contentPanel.add(lblFecha);

		cbxFecha = new JComboBox<String>();
		cbxFecha.setModel(new DefaultComboBoxModel<String>(new String[] { "<Seleccione>" }));
		cbxFecha.setBounds(66, 15, 123, 20);
		contentPanel.add(cbxFecha);

		JLabel lblDoctor = new JLabel("Doctor:");
		lblDoctor.setBounds(209, 17, 46, 14);
		contentPanel.add(lblDoctor);

		cbxDoctor = new JComboBox<String>();
		cbxDoctor.setModel(new DefaultComboBoxModel<String>(new String[] { "<Seleccione>" }));
		cbxDoctor.setBounds(253, 14, 121, 20);
		contentPanel.add(cbxDoctor);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOk = new JButton("OK");
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
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
 * Creado por: Yamilka 13/11/17
 * 
 */
