
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

public class PrincipalGUI extends JFrame implements ActionListener {
	
	// declaration of the attributes of the elements of our Frame
	private JPanel pan = new JPanel();
	private JButton bouton = new JButton("Creer un Concierge");
	private JButton bouton2 = new JButton("Connexion Concierge");
	private JPanel container = new JPanel();

	// declaration of the conciergeDB and a default value of a concierge
	private  ConciergeDB conciergeDB = new ConciergeDB() ;
    private Concierge default_concierge = new Concierge(1000,1000);
    
    /**
     * construct the frame
     * @param conciergeDB
     * @returns frame
     */
 
    PrincipalGUI (ConciergeDB conciergeDB){
    	conciergeDB.addConcierge(default_concierge);
		this.setTitle("La fenetre Principal");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
		
		
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());

		container.add(pan, BorderLayout.CENTER);

		
		pan.add(bouton2, BorderLayout.CENTER); 
		container.add(pan, BorderLayout.CENTER); 
		container.add(bouton, BorderLayout.SOUTH);    



		Font police = new Font("Tahoma", Font.BOLD, 16);


		this.setContentPane(container);
		this.setVisible(true);		
		bouton.addActionListener(this);
		bouton2.addActionListener(this);
		
	}



	public void actionPerformed(ActionEvent e) {
		String component=e.getActionCommand();
		if (component=="Creer un Concierge") {
			CreateConcierge A = new CreateConcierge(this.conciergeDB);
	
		}
		else if (component=="Connexion Concierge") {
			Concierge default_concierge = new Concierge();
			
			ConciergeConnexion B =new ConciergeConnexion(this.conciergeDB);
			
		}
	}
	

}
