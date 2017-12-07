package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;

import logical.Cita;
import logical.Clinica;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarCita extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6555192879758628965L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCita;
	private JTextField txtNombre;
	private JTextField txtFecha;

	
	public ModificarCita() {
		setTitle("Modificar Cita");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarCita.class.getResource("/images/icon.png")));
		setResizable(false);
		setBounds(100, 100, 307, 198);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos de Cita", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 281, 114);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		txtCita = new JTextField();
		txtCita.setBounds(10, 40, 124, 20);
		panel.add(txtCita);
		txtCita.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cita:");
		lblNewLabel.setBounds(10, 22, 46, 14);
		panel.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(10, 83, 124, 20);
		panel.add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 65, 46, 14);
		panel.add(lblNombre);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(144, 83, 124, 20);
		panel.add(txtFecha);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(144, 65, 46, 14);
		panel.add(lblFecha);
		
		JButton btnBuscarCita = new JButton("Buscar Cita");
		btnBuscarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cita c = Clinica.getInstance().findCitaByID(txtCita.getText());
				
				if(c == null || c.isEstado() == false) {
					JOptionPane.showMessageDialog(null, "Cita No Existente",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				}else {
					txtNombre.setText(c.getCitado().getNombre());
					txtFecha.setText(c.getFecha());
				}
			}
		});
		btnBuscarCita.setBounds(144, 39, 124, 23);
		panel.add(btnBuscarCita);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Cita c = Clinica.getInstance().findCitaByID(txtCita.getText());
					
					c.setEstado(false);
					
					Principal.LoadTableAdministrativo();
					
					JOptionPane.showMessageDialog(null, "Cita Eliminada Exitosamente",
							"Información", JOptionPane.INFORMATION_MESSAGE);
					
				}
			});
			buttonPane.add(btnEliminar);
			{
				JButton btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Cita c = Clinica.getInstance().findCitaByID(txtCita.getText());
						
						c.setFecha(txtFecha.getText());
						
						Principal.LoadTableAdministrativo();
						
						JOptionPane.showMessageDialog(null, "Cita Modificada Exitosamente",
								"Información", JOptionPane.INFORMATION_MESSAGE);
						
					}
				});
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				JButton btnAtras = new JButton("Atras");
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
}
