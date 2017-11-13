package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Consulta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2527505680250980586L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Consulta dialog = new Consulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Consulta() {
		setResizable(false);
		setTitle("Consulta");
		setBounds(100, 100, 450, 431);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTabbedPane informacion = new JTabbedPane(JTabbedPane.TOP);
		informacion.setBounds(10, 37, 424, 304);
		contentPanel.add(informacion);
		
		JPanel consulta = new JPanel();
		JPanel historia = new JPanel();								//Creando los tabs
		JPanel vacunas = new JPanel();
		//JPanel panel_4 = new JPanel();
		//JPanel panel_5 = new JPanel();
		
		informacion.addTab("Datos de Consulta", consulta);
		consulta.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos de Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 399, 140);
		consulta.add(panel);
		panel.setLayout(null);
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(10, 21, 46, 14);
		panel.add(lblCdula);
		
		textField = new JTextField();
		textField.setBounds(10, 34, 100, 20);
		panel.add(textField);
		textField.setColumns(10);
		informacion.addTab("Historia Clinica", historia);			// Agregando los tabs a la ventana
		informacion.addTab("Control de Vacunas", vacunas);
		//informacion.addTab("Panel 4", panel_4);
		//informacion.addTab("Panel 5", panel_5);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistar = new JButton("Guardar");
				btnRegistar.setActionCommand("OK");
				buttonPane.add(btnRegistar);
				getRootPane().setDefaultButton(btnRegistar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
