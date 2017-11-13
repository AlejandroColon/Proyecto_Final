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
import java.awt.Font;
import javax.swing.border.TitledBorder;

public class PrincipalDoctor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1265006742634726451L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	//private static Object[] fila;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalDoctor.class.getResource("/images/icon.png")));
		setResizable(false);
		setTitle("Principal Doctor");
		setBounds(100, 100, 526, 366);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblHora = new JLabel("00:00 a.m.");
		lblHora.setFont(new Font("Cambria Math", Font.PLAIN, 25));
		lblHora.setBounds(332, 11, 152, 30);
		contentPanel.add(lblHora);
		//Dando formato a la tabla
		{
			String[] columnNames = {"ID", "Fecha", "Doctor", "Persona"};
			model = new DefaultTableModel();
			model.setColumnIdentifiers(columnNames);
		
	}
		
		JLabel label = new JLabel("01/01/2017");
		label.setBounds(332, 41, 78, 14);
		contentPanel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Citas de Hoy:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 61, 500, 216);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 474, 149);
		panel_1.add(scrollPane);
		
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
			
			JButton btnRealizarConsulta = new JButton("Realizar Consulta");
			btnRealizarConsulta.setBounds(332, 184, 152, 23);
			panel_1.add(btnRealizarConsulta);
			btnRealizarConsulta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}

/*
Creado por: Yamilka 12/11/17

*/