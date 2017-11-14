package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -339133479221982755L;	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JTextField txtContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/icon.png")));
		setTitle("Acceso al usuario");
		setBounds(100, 100, 265, 333);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(46, 161, 56, 14);
		contentPanel.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(46, 176, 157, 20);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(46, 201, 86, 14);
		contentPanel.add(lblContrasea);
		
		txtContrasena = new JTextField();
		txtContrasena.setBounds(46, 216, 157, 20);
		contentPanel.add(txtContrasena);
		txtContrasena.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(63, 21, 125, 125);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/images/user.png")));
		panel.add(lblNewLabel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnIniciarSesion = new JButton("Iniciar sesion");
				btnIniciarSesion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				btnIniciarSesion.setActionCommand("OK");
				buttonPane.add(btnIniciarSesion);
				getRootPane().setDefaultButton(btnIniciarSesion);
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
 * 
 * Creado Por: Oscar Rodriguez.
 * Fecha: 12/11/17
 * Anotaciones:
 * 
 * 
 */