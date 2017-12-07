package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.ImageIcon;
import java.awt.Color;

public class RepHistorial extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static String cedula = "";
	private JTextArea textArea;
	private String storeAllString = "";

	
	
	@SuppressWarnings("static-access")
	public RepHistorial(String cedula) {
		this.cedula = cedula;
		setTitle("Reporte de historial");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RepHistorial.class.getResource("/images/icon.png")));
		setBounds(100, 100, 648, 366);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(0, 0, 632, 294);
		
		leer();		

		
		contentPanel.add(textArea);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(102, 153, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAtras = new JButton("Atr\u00E1s");
				btnAtras.setBackground(new Color(240,240,240));
				btnAtras.setIcon(new ImageIcon(RepHistorial.class.getResource("/images/back.png")));
				btnAtras.setActionCommand("Cancel");
				buttonPane.add(btnAtras);
			}
		}
	}
	
	public void leer(){
        try{    
          FileReader read = new FileReader(cedula + ".txt");
          Scanner scan = new Scanner(read);
             while(scan.hasNextLine()){
              String temp=scan.nextLine()+"\n";
              storeAllString=storeAllString+temp;
             }
             textArea.setText(storeAllString);
             
             scan.close();
      }
        catch (Exception exception)
         {
         exception.printStackTrace();
         }
    }
}
/*
*
*Creado por: Oscar Rodriguez
*Fecha: 06/12/2017
*
*Anotaciones:
*
*/