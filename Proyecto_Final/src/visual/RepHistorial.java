package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RepHistorial extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static String cedula = "";
	private JTextArea textArea;
	private String storeAllString = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RepHistorial dialog = new RepHistorial(cedula);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
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
		 // Construye un BufferedReader
	   /* BufferedReader lectorcito;
	    boolean eof = false;
	    String linea = "";
		try {
			lectorcito = new BufferedReader(new FileReader(cedula+".txt"));
			 while (!eof)
		        {
		            linea = lectorcito.readLine();
		            if( linea != null )
		                textArea.setText(linea);      
		            else
		                eof = true;
		        }

		        
		        lectorcito.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		contentPanel.add(textArea);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void leer(){
        try{    
          FileReader read = new FileReader(cedula+".txt");
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