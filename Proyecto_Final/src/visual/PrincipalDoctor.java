package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import logical.Cita;
import logical.Clinica;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.SystemColor;
import javax.swing.JMenuBar;

public class PrincipalDoctor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1265006742634726451L;
	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel model;
	private static Object[] fila;
	private JTable tableCitas;

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
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalDoctor.class.getResource("/images/icon.png")));
		setTitle("Principal");
		setBounds(100, 100, 987, 675);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		panel_3.add(menuBar);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.control);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "Citas para Hoy", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBounds(10, 25, 440, 215);
					panel_1.add(panel_2);
					panel_2.setLayout(new BorderLayout(0, 0));
					{
						JScrollPane scrollPane = new JScrollPane();
						panel_2.add(scrollPane, BorderLayout.CENTER);
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
					btnRealizarConsulta.setBounds(322, 251, 128, 23);
					panel_1.add(btnRealizarConsulta);
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
}

/*
 * Creado por: Yamilka 12/11/17
 * 
 */