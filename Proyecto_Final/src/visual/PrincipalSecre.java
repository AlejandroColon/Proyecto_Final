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

import logical.Clinica;
import logical.Doctor;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalSecre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3289679350861074097L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	// private static Object[] fila;
	private JComboBox <String> cbxDoctor;
	private JComboBox<String> cbxFecha;

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
		setBounds(100, 100, 533, 324);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JLabel labelHora = new JLabel("00:00 a.m.");
		labelHora.setFont(new Font("Cambria Math", Font.PLAIN, 25));
		labelHora.setBounds(384, 46, 123, 22);
		contentPanel.add(labelHora);
		// Dando formato a la tabla
		{
			String[] columnNames = { "ID", "Fecha", "Doctor", "Persona" };
			model = new DefaultTableModel();
			model.setColumnIdentifiers(columnNames);
		}

		JLabel label = new JLabel("01/01/17");
		label.setBounds(384, 71, 66, 14);
		contentPanel.add(label);

		
			JPanel panelTablaCitas = new JPanel();
			panelTablaCitas
					.setBorder(new TitledBorder(null, "Citas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelTablaCitas.setBounds(10, 96, 497, 155);
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
		lblFecha.setBounds(10, 52, 46, 14);
		contentPanel.add(lblFecha);

		cbxFecha = new JComboBox<String>();
		cbxFecha.setModel(new DefaultComboBoxModel<String>(new String[] { "<Seleccione>" }));
		cbxFecha.setBounds(66, 49, 123, 20);
		contentPanel.add(cbxFecha);

		JLabel lblDoctor = new JLabel("Doctor:");
		lblDoctor.setBounds(209, 51, 46, 14);
		contentPanel.add(lblDoctor);

		cbxDoctor = new JComboBox<String>();
		cbxDoctor.setModel(new DefaultComboBoxModel<String>(new String[] { "<Seleccione>" }));
		cbxDoctor.setBounds(253, 48, 121, 20);
		contentPanel.add(cbxDoctor);
		llenarCMB();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 527, 21);
		contentPanel.add(menuBar);
		
		JMenu mnRegistrar = new JMenu("Registrar");
		menuBar.add(mnRegistrar);
		
		JMenuItem mntmRegistrarCita = new JMenuItem("Registrar Cita");
		mntmRegistrarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegCita frame =  new RegCita();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		mnRegistrar.add(mntmRegistrarCita);
		
		JMenuItem mntmRegistrarOtra = new JMenuItem("Registrar otra ");
		mnRegistrar.add(mntmRegistrarOtra);
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

	private void llenarCMB() {
		boolean encontrado = false;
		cbxDoctor.removeAllItems();  	//limpiando la info del cmb
		
		try{
			for (int i = 0; i < Clinica.getInstance().getMisPersonas().size(); i++){
				if(Clinica.getInstance().getMisPersonas().get(i) instanceof Doctor){
					cbxDoctor.addItem(new String(Clinica.getInstance().getMisPersonas().get(i).getNombre() + "(" + Clinica.getInstance().getMisPersonas().get(i).getCedula() + ") " ));
					encontrado = true;
				}
			}
			
			if (encontrado){
				//CMBSuministrador.insertItemAt("<Seleccione>", 0);
				cbxDoctor.setSelectedItem(0);
			}else{
			cbxDoctor.removeAllItems();
			cbxDoctor.addItem(new String("<sin doctores>"));
			}
		}catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "EL PROGRAMA HA EXPLOTADO INESPERADAMENTE", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}

/*
 * Creado por: Yamilka 13/11/17
 * Modificaciones:
 * Yamilka le dio formato al btnRegistrar para que se guarden los consultantes y las citas
 * 
 */
