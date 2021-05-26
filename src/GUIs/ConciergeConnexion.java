
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import src.System.*;
import src.System.Events.*;
import src.System.Listeners.*;


 



public class ConciergeConnexion extends JFrame {
	  
	  private JPanel pan = new JPanel();
	  
	  private JButton bouton2 = new JButton("cliquez pour vous connecter");
	  
	  private JPanel container = new JPanel();
	  private JLabel label = new JLabel("Veuillez vous connectez");
	  private String text;
	  private JTextField textField = new JTextField(20);
	  private JTextField textField2 = new JTextField(20);
	  private ConciergeDB conciergeDB;
	  
	  
	  public ConciergeConnexion(ConciergeDB conciergeDB){
	    this.setTitle("La connexion du concierge");
	    this.setSize(500, 300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null); 
	    this.conciergeDB =conciergeDB;
	    this.setResizable(false);

	    
	    container.setBackground(Color.white);
	    container.setLayout(new BorderLayout());
	    
	    
	    container.add(pan, BorderLayout.CENTER);
	    
	    
	    JLabel label1 = new JLabel("Login  ");
	    pan.add(label1);
	    textField.setToolTipText("Saisissez int");
	    pan.add(textField);
	    
	    JLabel label2 = new JLabel("Password");
	    pan.add(label2);
	    
	    textField2.setToolTipText("Saisissez un int");
	    pan.add(textField2);
	   
	    pan.add(bouton2, BorderLayout.CENTER);  
	    
	    container.add(pan, BorderLayout.CENTER);
	    
	    
	    Font police = new Font("Tahoma", Font.BOLD, 16);
	    label.setFont(police);  
	    label.setForeground(Color.blue); 
	    label.setHorizontalAlignment(JLabel.CENTER);
	    container.add(label, BorderLayout.NORTH);
	    
	    
	    this.setContentPane(container);
	    this.setVisible(true);
	    
	    
	    
	    ConciergeDB consDB =this.conciergeDB;
	    bouton2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		boolean x=false;
	    		int id = Integer.parseInt( textField.getText());
				int password = Integer.parseInt( textField.getText());
				boolean authentification = consDB.authentification ( id,  password) ;
				if (authentification== true) {
					Concierge connected_concierge =  consDB.getConciergeAuthentification(id,  password);
					label.setText("Connexion Reussi ");
					FenetreCreation m= new FenetreCreation (connected_concierge);
					
					}
				
					else {
						label.setText("Connexion Echoué, login ou mp incorrect ");
					}
					
				
				 }
				
	
	    });
	    
	  }
}
	    
