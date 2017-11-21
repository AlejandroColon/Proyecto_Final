package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Administrativo;
import logical.Clinica;
import logical.Doctor;
import logical.Persona;

import java.awt.Toolkit;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2338171001859749383L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					Thread.sleep(3000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Persona p = new Doctor("050-0021076-4","Dr. Maunel Perez",10,"809-","casa","m","doctor","123","abc","Cirujano",3);
				Clinica.getInstance().addPersona(p);
				Persona p2 = new Administrativo("402-8566965-3","Lic. Manuela Pereza",15,"829","la casa de manuel","F","secre","abc");
				Clinica.getInstance().addPersona(p2);
				
				RegUsuario rUsuario = new RegUsuario();
				rUsuario.setVisible(true);
				rUsuario.setLocationRelativeTo(null);
				
				ListaTrabajadores lista = new ListaTrabajadores();
				lista.setVisible(true);
				lista.setLocationRelativeTo(null);
				
				
				/*Login log = new Login();
				log.setVisible(true);
				log.setLocationRelativeTo(null);*/
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setResizable(false);
		setTitle("OMEGA");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/images/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
