package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Administrativo;
import logical.Clinica;
import logical.Doctor;
import logical.Persona;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -339133479221982755L;	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JPasswordField passContra;

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
				btnIniciarSesion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String user = txtUsuario.getText();
						String password = String.valueOf(passContra.getPassword());
						if(Clinica.getInstance().validarLogin(user, password)) {
							Persona usuario = Clinica.getInstance().buscarTrabajador(user);
							if(usuario instanceof Doctor) {
								PrincipalDoctor doctor = new PrincipalDoctor();
								doctor.setVisible(true);
								Toolkit tk = Toolkit.getDefaultToolkit();  
							     int xSize = ((int) tk.getScreenSize().getWidth());  
							     int ySize = ((int) tk.getScreenSize().getHeight());  
							     doctor.setSize(xSize,ySize - 40);
							     doctor.setLocationRelativeTo(null);
							}else if(usuario instanceof Administrativo) {
								PrincipalSecre secre = new PrincipalSecre();
								secre.setVisible(true);
								Toolkit tk = Toolkit.getDefaultToolkit();  
							     int xSize = ((int) tk.getScreenSize().getWidth());  
							     int ySize = ((int) tk.getScreenSize().getHeight());  
							     secre.setSize(xSize,ySize - 40);
							     secre.setLocationRelativeTo(null);
								
							}
						}else {
							JOptionPane.showMessageDialog(null, "Usuario o contraseña Inválido", "Advertencia", JOptionPane.WARNING_MESSAGE);
						}
					}
				});
				btnIniciarSesion.setActionCommand("OK");
				buttonPane.add(btnIniciarSesion);
				getRootPane().setDefaultButton(btnIniciarSesion);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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
 * 
 * Creado Por: Oscar Rodriguez.
 * Fecha: 12/11/17
 * Anotaciones:
 * 
 * 
 */