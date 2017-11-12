package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class PrincipalDoctor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1265006742634726451L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PrincipalDoctor dialog = new PrincipalDoctor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PrincipalDoctor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalDoctor.class.getResource("/images/Omega-01-128.png")));
		setResizable(false);
		setTitle("Principal Doctor");
		setBounds(100, 100, 510, 382);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(398, 11, 46, 14);
		contentPanel.add(lblHora);
		
		JLabel lblCitas = new JLabel("Citas:");
		lblCitas.setBounds(10, 64, 46, 14);
		contentPanel.add(lblCitas);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 89, 474, 149);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		//Dando formato a la tabla
		{
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//aqui lo que hago es quedarse con el indetificador de lo que tengo seleccionado y con este string busco el objt				
				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//se crea un arreglo de string con los nombres de la col de mi tabla
			String[] columnNames = {"ID", "Fecha", "Doctor", "Persona"};
			model = new DefaultTableModel();
			model.setColumnIdentifiers(columnNames);
			table.setModel(model);
	        //loadTable();
			scrollPane.setViewportView(table);
		
	}
		
		JButton btnRealizarConsulta = new JButton("Realizar consulta");
		btnRealizarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRealizarConsulta.setBounds(332, 249, 152, 23);
		contentPanel.add(btnRealizarConsulta);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

/*
Creado por: Yamilka 12/11/17

*/