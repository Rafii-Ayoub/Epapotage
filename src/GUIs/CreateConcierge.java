import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import src.System.*;


public class CreateConcierge extends JFrame implements ActionListener{
	private JPanel pan = new JPanel();
	private JButton boutton = new JButton("cliquez pour creer un Concierge");
	private JPanel container = new JPanel();
	private JLabel label = new JLabel("Bienvenue sur l'applications");
	private String text;
	private JTextField textField = new JTextField(20);
	private JTextField textField2 = new JTextField(20);
	private  JRadioButton generate = new JRadioButton("generate concierge");
	private ConciergeDB conciergeDB;
	
	public CreateConcierge(ConciergeDB conciergeDB){
		this.setTitle("La fenetre de Creation de Bavard");
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); 
		this.conciergeDB=conciergeDB;
		this.setResizable(false);
		
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());

		container.add(pan, BorderLayout.CENTER);

  
		JLabel label1 = new JLabel("Login");
		pan.add(label1);
		textField.setToolTipText(" Saisissez un int ");
		pan.add(textField);

		JLabel label2 = new JLabel("Password");
		pan.add(label2);

		textField2.setToolTipText("Saisissez un int");
		pan.add(textField2);
		pan.add(boutton);
		
		generate.setText("Generer le ID et le password");
		container.add(pan, BorderLayout.CENTER);   
		container.add(generate, BorderLayout.SOUTH);

		Font police = new Font("Tahoma", Font.BOLD, 16);
		label.setFont(police);  
		label.setForeground(Color.blue); 
		label.setHorizontalAlignment(JLabel.CENTER);
		container.add(label, BorderLayout.NORTH);


		this.setContentPane(container);
		this.setVisible(true);

		
		boutton.addActionListener(this) ;
		
        generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generate_passwordActionPerformed(evt);
            }
        });

	
		
	}


	 private void generate_passwordActionPerformed(ActionEvent evt) {                                                  
		   textField.setEnabled(false);
	       textField2.setEnabled(false);
	       textField.setBackground(Color.gray);
	       textField2.setBackground(Color.gray);
	       generate.setSelected(true);
	    }         
	public void actionPerformed(ActionEvent e) {
		
		String component=e.getActionCommand();
		
		if (component=="cliquez pour creer un Concierge") {
			
			
			if(textField.getDragEnabled()==true) {
			      int id = Integer.parseInt(textField.getText());
			      int password = Integer.parseInt(textField.getText());
			      Concierge A= new Concierge(id,password);
			      label.setText(A.toString2());
			      this.conciergeDB.addConcierge(A);
			      System.out.println(conciergeDB.toString());
			      ConciergeConnexion C = new ConciergeConnexion(conciergeDB);
			      
			}
			
			
			else{
				Concierge generated_concierge = new Concierge();
				label.setText("Vous avez Ajouter un nouveau Bavard ");
			     this.conciergeDB.addConcierge(generated_concierge);
			     System.out.println(conciergeDB.toString());
			     ConciergeConnexion A = new ConciergeConnexion(conciergeDB);
			     label.setText(generated_concierge.toString2());
			}
			
			
			
		
		}
		
	}



}



