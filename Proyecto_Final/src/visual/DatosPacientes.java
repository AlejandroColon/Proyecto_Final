package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Clinica;
import logical.Paciente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class DatosPacientes extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6649797359453722763L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtNumeroAfiliado;
	private JTextField txtEdad;
	private JTextField txtTipoSangre;
	private JTextField txtDireccion;
	private JTextField txtAseguradora;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public DatosPacientes(String cedula) {
		setTitle("Datos de Paciente");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DatosPacientes.class.getResource("/images/icon.png")));
		setBounds(100, 100, 375, 256);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		
		
		JLabel lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setBounds(10, 11, 70, 14);
		contentPanel.add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setEditable(false);
		txtCedula.setBounds(10, 25, 143, 20);
		contentPanel.add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 48, 70, 14);
		contentPanel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(10, 63, 143, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(10, 86, 70, 14);
		contentPanel.add(lblTelfono);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(10, 102, 143, 20);
		contentPanel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblNmeroAfiliado = new JLabel("N\u00FAmero afiliado:");
		lblNmeroAfiliado.setBounds(10, 125, 92, 14);
		contentPanel.add(lblNmeroAfiliado);
		
		txtNumeroAfiliado = new JTextField();
		txtNumeroAfiliado.setEditable(false);
		txtNumeroAfiliado.setBounds(10, 142, 143, 20);
		contentPanel.add(txtNumeroAfiliado);
		txtNumeroAfiliado.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(189, 48, 46, 14);
		contentPanel.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setEditable(false);
		txtEdad.setBounds(189, 63, 65, 20);
		contentPanel.add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblTipoDeSangre = new JLabel("Tipo de sangre:");
		lblTipoDeSangre.setBounds(257, 48, 92, 14);
		contentPanel.add(lblTipoDeSangre);
		
		txtTipoSangre = new JTextField();
		txtTipoSangre.setEditable(false);
		txtTipoSangre.setBounds(261, 63, 71, 20);
		contentPanel.add(txtTipoSangre);
		txtTipoSangre.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(189, 86, 70, 14);
		contentPanel.add(lblDireccin);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(189, 102, 143, 20);
		contentPanel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblAseguradora = new JLabel("Aseguradora:");
		lblAseguradora.setBounds(189, 125, 86, 14);
		contentPanel.add(lblAseguradora);
		
		txtAseguradora = new JTextField();
		txtAseguradora.setEditable(false);
		txtAseguradora.setBounds(189, 142, 143, 20);
		contentPanel.add(txtAseguradora);
		txtAseguradora.setColumns(10);
		
		//cargando los datos
				Paciente p = Clinica.getInstance().findPacienteByCedula(cedula);
				if(p==null) {
					JOptionPane.showMessageDialog(null, "Historial Clínico exportado exitosamente", "Información",
							JOptionPane.INFORMATION_MESSAGE);

				}
				txtCedula.setText("123");
				txtNombre.setText(p.getNombre());
				LocalDate birthday = LocalDate.of(readAno(p.getFechaNacimiento()), readMes(p.getFechaNacimiento()), readDia(p.getFechaNacimiento()));
				txtEdad.setText(""+Clinica.getInstance().calcularEdad(birthday));
				txtDireccion.setText(p.getDireccion());
				txtNumeroAfiliado.setText(p.getNumeroAfiliado());
				txtTelefono.setText(p.getTelefono());
				txtTipoSangre.setText(p.getTipoSangre());
				txtAseguradora.setText(p.getAseguradora());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(102, 153, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnVerHistorial = new JButton("Ver Historial");
				btnVerHistorial.setBackground(new Color(204, 204, 204));
				btnVerHistorial.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Clinica.getInstance().generarHistorial(p.getCedula());
							JOptionPane.showMessageDialog(null, "Historial Clínico exportado exitosamente", "Información",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (IOException e1) {
						}
						RepHistorial repo = new RepHistorial(p.getCedula());
						repo.dispose();
						repo.setVisible(true);
						repo.setLocationRelativeTo(null);
						dispose();
					}
				});
				btnVerHistorial.setIcon(new ImageIcon(DatosPacientes.class.getResource("/images/magnifying-glass.png")));
				btnVerHistorial.setActionCommand("OK");
				buttonPane.add(btnVerHistorial);
				getRootPane().setDefaultButton(btnVerHistorial);
			}
			{
				JButton btnAtras = new JButton("Atr\u00E1s");
				btnAtras.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnAtras.setBackground(new Color(204, 204, 204));
				btnAtras.setIcon(new ImageIcon(DatosPacientes.class.getResource("/images/back.png")));
				btnAtras.setActionCommand("Cancel");
				buttonPane.add(btnAtras);
			}
		}
	}
	
	private int readMes(String fechaNacimiento) {
		return Integer.parseInt(fechaNacimiento.substring(3, 5));
	}

	private int readDia(String fechaNacimiento) {
		return Integer.parseInt(fechaNacimiento.substring(0, 2));
	}

	private int readAno(String fechaNacimiento) {
		return Integer.parseInt(fechaNacimiento.substring(6, 10));
	}
}

/*
 * Creado por Yamilka 06/12/17
 */
