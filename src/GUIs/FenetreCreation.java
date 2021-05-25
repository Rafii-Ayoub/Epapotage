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


public class FenetreCreation extends JFrame implements ActionListener{
	private JPanel pan = new JPanel();
	private JButton bouton = new JButton("cliquez pour creer un bavard");
	private JButton bouton2 = new JButton("Connecter un bavard");
	private JPanel container = new JPanel();
	private JLabel label = new JLabel("Bienvenue sur l'applications");
	private String text;
	private JTextField textField = new JTextField(20);
	private JTextField textField2 = new JTextField(20);
	private  JRadioButton generate = new JRadioButton("generate concierge");
	private Concierge concierge;
	public FenetreCreation(Concierge concierge){
		this.setTitle("La fenetre de Creation de Bavard");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); 
		this.concierge=concierge;
		this.setResizable(false);
		
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());

		container.add(pan, BorderLayout.CENTER);


		JLabel label1 = new JLabel("Login  ");
		pan.add(label1);
		textField.setToolTipText("Saisissez le login");
		pan.add(textField);

		JLabel label2 = new JLabel("Password");
		pan.add(label2);
		textField2.setToolTipText("Saisissez le password");
		generate.setText("Generer le ID et le password");
		pan.add(textField2);
		pan.add(bouton); 
		pan.add(generate);
		
		container.add(pan, BorderLayout.CENTER); 
		container.add(bouton2, BorderLayout.SOUTH);    

		
		container.add(pan, BorderLayout.CENTER);   




		Font police = new Font("Tahoma", Font.BOLD, 16);
		label.setFont(police);  
		label.setForeground(Color.blue); 
		label.setHorizontalAlignment(JLabel.CENTER);
		container.add(label, BorderLayout.NORTH);


		this.setContentPane(container);
		this.setVisible(true);
		

		
		bouton.addActionListener(this);
		bouton2.addActionListener(this);
	    generate.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                generateActionPerformed(evt);
	            }
	        });
		
	}

	 private void generateActionPerformed(ActionEvent evt) {                                                  
		   textField.setEnabled(false);
	       textField2.setEnabled(false);
	       textField.setBackground(Color.gray);
	       textField2.setBackground(Color.gray);
	       generate.setSelected(true);
	    }         


	public void actionPerformed(ActionEvent e) {
		String component=e.getActionCommand();
		if (component=="cliquez pour creer un bavard" || component=="creer un autre bavard") {
			if (textField.getDragEnabled()==true) {
			
			String login = textField.getText();
			String motpasse = textField2.getText();
			Bavard A=new Bavard(login,motpasse);
			label.setText("Bavard" +login+"de mp"+motpasse+"crée avec succes");
			this.concierge.addBavard(A);
			System.out.println(concierge);
			}
			else{
				Bavard generated_bavard = new Bavard();
				label.setText("Bavard "+generated_bavard.toString() );
			     this.concierge.addBavard(generated_bavard);
			     System.out.println(concierge.toString());
			     label.setText(generated_bavard.toString2());
			     textField.setEnabled(true);
			     textField2.setEnabled(true);
			     textField.setBackground(Color.white);
			     textField2.setBackground(Color.white);
			     generate.setSelected(false);
			     
			}
			bouton.setText("creer un autre bavard");
			
		}
		
		if (component=="Connecter un bavard") {
			FenetreConnexion A=new FenetreConnexion(this.concierge);

		}
	}
}



















