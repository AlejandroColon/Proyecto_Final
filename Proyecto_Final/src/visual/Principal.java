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
import java.io.IOException;

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

					Principal frame = new Principal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					try {
						Clinica.getInstance().leerCitas();
						Clinica.getInstance().leerConsultas();
						Clinica.getInstance().leerEnfermedades();
						Clinica.getInstance().leerPersonas();
						Clinica.getInstance().leerVacunas();
						Thread.sleep(3000);
					} catch (ClassNotFoundException | IOException | InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				Persona p = new Doctor("050-0021076-4","Dr. Maunel Perez",10,"809-","casa","m","doctor","123","abc","Cirujano",3);
				Clinica.getInstance().addPersona(p);
				Persona p2 = new Administrativo("402-8566965-3","Lic. Manuela Pereza",15,"829","la casa de manuel","F","secre","abc");
				Clinica.getInstance().addPersona(p2);
				
				Login log = new Login();
				log.setVisible(true);
				log.setLocationRelativeTo(null);
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
