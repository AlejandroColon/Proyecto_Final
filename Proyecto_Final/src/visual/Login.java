package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Clinica;
import logical.Persona;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class Login extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -339133479221982755L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JPasswordField passContra;

	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/icon.png")));
		setTitle("Acceso al usuario");
		setBounds(100, 100, 265, 333);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblUsuario.setBounds(46, 161, 56, 14);
		contentPanel.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(46, 176, 157, 20);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblContrasea.setBounds(46, 201, 86, 14);
		contentPanel.add(lblContrasea);

		JPanel panel = new JPanel();
		panel.setBounds(63, 21, 125, 125);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/images/user.png")));
		panel.add(lblNewLabel, BorderLayout.CENTER);

		passContra = new JPasswordField();
		passContra.setBounds(46, 215, 157, 20);
		contentPanel.add(passContra);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnIniciarSesion = new JButton("Iniciar sesion");
				btnIniciarSesion.setIcon(new ImageIcon(Login.class.getResource("/images/001-login.png")));
				btnIniciarSesion.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
				btnIniciarSesion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String user = txtUsuario.getText();
						String password = String.valueOf(passContra.getPassword());
						if (Clinica.getInstance().validarLogin(user, password)) {
							Persona usuario = Clinica.getInstance().buscarTrabajador(user);
							if (usuario != null) {
								Principal frame = new Principal(usuario);
								frame.setVisible(true);
								Toolkit tk = Toolkit.getDefaultToolkit();
								int xSize = ((int) tk.getScreenSize().getWidth());
								int ySize = ((int) tk.getScreenSize().getHeight());
								frame.setSize(xSize, ySize - 40);
								frame.setLocationRelativeTo(null);
								dispose();
							}
						} else {
							JOptionPane.showMessageDialog(null, "Usuario o contraseña Inválido", "Advertencia",
									JOptionPane.WARNING_MESSAGE);
						}
					}
				});
				btnIniciarSesion.setActionCommand("OK");
				buttonPane.add(btnIniciarSesion);
				getRootPane().setDefaultButton(btnIniciarSesion);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setIcon(new ImageIcon(Login.class.getResource("/images/003-logout-1.png")));
				btnCancelar.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
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
 * 
 * Creado Por: Oscar Rodriguez. Fecha: 12/11/17 Anotaciones:
 * Modificaciones: Yamilka 02/12/17 Anotaciones: Cambiar los formatos de letra
 * y agregar iconos a los btn
 * 
 */