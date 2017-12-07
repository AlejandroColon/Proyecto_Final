package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import logical.Clinica;
import logical.Enfermedad;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class RegistrarEnfermedad extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3139685405715440498L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	JTextArea txtDescripcion;

	
	
	public RegistrarEnfermedad() {
		setBackground(Color.WHITE);
		setTitle("Registrar Enfermedad");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarEnfermedad.class.getResource("/images/icon.png")));
		setBounds(100, 100, 330, 241);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(new TitledBorder(null, "Enfermedad Bajo Vigilancia", TitledBorder.LEADING, TitledBorder.TOP,
					null, null));
			panel.setBounds(10, 11, 302, 160);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblCdigo = new JLabel("C\u00F3digo:");
				lblCdigo.setBounds(10, 21, 46, 14);
				panel.add(lblCdigo);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
				txtCodigo.setEditable(false);
				txtCodigo.setBounds(10, 35, 95, 20);
				panel.add(txtCodigo);
				txtCodigo.setColumns(10);
				txtCodigo.setText("EBV-" + (Clinica.getInstance().getMisEnfermedades().size() + 1));
			}
			{
				txtNombre = new JTextField();
				txtNombre.setColumns(10);
				txtNombre.setBounds(155, 35, 138, 20);
				panel.add(txtNombre);
			}
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(155, 21, 67, 14);
				panel.add(lblNombre);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(10, 81, 283, 69);
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));

				JScrollPane scrollPane = new JScrollPane();
				panel_1.add(scrollPane, BorderLayout.CENTER);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // Codigo para textArea
				txtDescripcion = new JTextArea();
				txtDescripcion.setLineWrap(true);
				scrollPane.setViewportView(txtDescripcion);

			}
			{
				JLabel lblDescripin = new JLabel("Descripi\u00F3n:");
				lblDescripin.setBounds(10, 66, 67, 14);
				panel.add(lblDescripin);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(102, 153, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setBackground(new Color(204, 204, 204));
				btnRegistrar.setIcon(new ImageIcon(RegistrarEnfermedad.class.getResource("/images/checked (1).png")));
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!txtCodigo.getText().equalsIgnoreCase("") && !txtNombre.getText().equalsIgnoreCase("") && !txtDescripcion.getText().equalsIgnoreCase("")) {
							Enfermedad p = new Enfermedad(txtCodigo.getText(), txtNombre.getText(),
									txtDescripcion.getText());
							Clinica.getInstance().addEnfermedades(p);
							try {
								Clinica.getInstance().salvarEnfermedades();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "Enfermedad agregada existosamente",
									"Enfermedad Bajo Vigilancia", JOptionPane.INFORMATION_MESSAGE);
							clear();
						} else {
							JOptionPane.showMessageDialog(null, "No puede dejar campos vacios", "Aviso",
									JOptionPane.WARNING_MESSAGE);
						}

					}

					public void clear() {
						txtCodigo.setText("EBV-" + (Clinica.getInstance().getMisEnfermedades().size() + 1));
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
				btnCancelar.setBackground(new Color(204, 204, 204));
				btnCancelar.setIcon(new ImageIcon(RegistrarEnfermedad.class.getResource("/images/cancel.png")));
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtNombre.setText("");
						txtDescripcion.setText("");
						dispose();
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
