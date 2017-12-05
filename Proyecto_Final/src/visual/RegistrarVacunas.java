package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logical.Clinica;
import logical.Vacuna;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;



public class RegistrarVacunas extends JDialog {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -752769533108807772L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	JTextArea txtDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarVacunas dialog = new RegistrarVacunas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarVacunas() {
		setBackground(Color.WHITE);
		setTitle("Registrar Vacuna");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarVacunas.class.getResource("/images/icon.png")));
		setResizable(false);
		setBounds(100, 100, 327, 241);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Vacuna", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(0, 0, 321, 171);
		contentPanel.add(panel);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(10, 21, 46, 14);
		panel.add(label);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("EBV-1");
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(10, 35, 95, 28);
		panel.add(txtCodigo);
		txtCodigo.setText("VAC-" + (Clinica.getInstance().getMisVacunas().size() + 1));
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(155, 35, 138, 28);
		panel.add(txtNombre);
		
		JLabel label_1 = new JLabel("Nombre:");
		label_1.setBounds(155, 21, 67, 14);
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 81, 299, 69);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
		txtDescripcion = new JTextArea();
		txtDescripcion.setLineWrap(true);
		scrollPane.setViewportView(txtDescripcion);
		
		JLabel label_2 = new JLabel("Descripi\u00F3n:");
		label_2.setBounds(10, 66, 67, 14);
		panel.add(label_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(102, 153, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setIcon(new ImageIcon(RegistrarVacunas.class.getResource("/images/002-login-1.png")));
				btnRegistrar.setBackground(new Color(204, 204, 204));
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!txtCodigo.getText().equalsIgnoreCase("") && !txtNombre.getText().equalsIgnoreCase("") && !txtDescripcion.getText().equalsIgnoreCase("")) {
							Vacuna v = new Vacuna(txtCodigo.getText(), txtNombre.getText(),
									txtDescripcion.getText());
							Clinica.getInstance().addVacunas(v);
							try {
								Clinica.getInstance().salvarVacunas();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, " Vacuna agregada existosamente",
									"Vacuna", JOptionPane.INFORMATION_MESSAGE);
							clear();
						} else {
							JOptionPane.showMessageDialog(null, "No pueden haber campos vacios", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
					}

					private void clear() {
						txtCodigo.setText("VAC-" + (Clinica.getInstance().getMisVacunas().size() + 1));
						txtNombre.setText("");
						txtDescripcion.setText("");
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setIcon(new ImageIcon(RegistrarVacunas.class.getResource("/images/back.png")));
				btnCancelar.setBackground(new Color(204, 204, 204));
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
}
/*
 * Creado por: Alejandro Colón Fecha: 13/11/17 Anotaciones:
 * 
 * Modificado: Oscar Rodriguez
 * Fecha: 27/11/2017
 * Anotaciones: Llamada a las funciones para guardar en archivo
 * 
 */
