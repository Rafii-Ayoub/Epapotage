
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import src.System.*;





public class Messagerie extends JFrame implements PapotageListener,ActionListener{
	private JPanel pan = new JPanel();
	
	private JButton bouton = new JButton("Envoyez le message aux utilisateurs connectes");
	
	
	private JButton bouton1 = new JButton("Deconnexion");
	
	private JPanel container = new JPanel();
	
	private JLabel label = new JLabel("Bienvenue sur la fenetre de messagerie");
	public  JLabel label4 = new JLabel("Label-UsersOffline");
	
	private String text;
	
	private JTextField textField = new JTextField(20);
	private JTextArea textField2=new JTextArea();
	
	private JTextArea area=new JTextArea();
	public static JTextArea area2=new JTextArea();
	
	
    
	
	private Bavard A;
	private Concierge cons;
	public ArrayList<String> lesmess=new ArrayList<String>();
	
	public Messagerie(Bavard B,Concierge cons){
		this.A=B;
		this.cons=cons;
		
		this.setTitle("vous etes connecte au nom de "+A.login);
		this.setSize(350,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
		
		
		

		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());

		container.add(pan, BorderLayout.CENTER);


		JLabel label1 = new JLabel("le sujet");
		
		textField.setBounds(25,140,280,20);
		textField.setToolTipText("Saisissez le sujet du message");
		pan.add(textField);

		JLabel label2 = new JLabel("le corps du message");
		pan.add(label2);
		
		textField2.setLineWrap(true);
		textField2.setWrapStyleWord(true);
		textField2.setBounds(30,75,280,80); 
		textField2.setToolTipText("Saisissez le message");
		container.add(textField2);
		

		bouton.setBounds(25,170,280,20);
		container.add(bouton, BorderLayout.CENTER); 
		container.add(bouton1, BorderLayout.SOUTH); 
		
		Font police = new Font("Tahoma", Font.BOLD, 16);
		label.setFont(police);  
		label.setForeground(Color.blue); 
		label.setHorizontalAlignment(JLabel.CENTER);
		container.add(label, BorderLayout.NORTH);

		
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		area.setEditable(false);
		Color c = new Color(200,200,200);
		area.setBackground(c);
		area.setForeground(Color.black);
		area.setBounds(30,200, 280,280); 
		container.add(area);
		
		
		JLabel label3 = new JLabel("Les utilisateurs connectes");
		label3.setBounds(30,483,280,20);
		container.add(label3);
		
		area2.setLineWrap(true);
		area2.setWrapStyleWord(true);
		area2.setEditable(false);
		area2.setForeground(Color.RED);
		area2.setBounds(30,500,280,80);
		container.add(area2);
		
		pan.add(label1);
		label4.setBounds(30,585,280,20);
		container.add(label4);
		
		container.add(pan, BorderLayout.CENTER);
		this.setContentPane(container);
		this.setVisible(true);

		bouton1.addActionListener(this);
		bouton.addActionListener(this);
		
		
	}

	public String affichageabel() {
		return (String.valueOf(A.login)+" is deconnected");
	}
	
	
	/**
	 * Methode pour la gestion des evenements 
	 */
	
	public void actionPerformed(ActionEvent e){
		String component=e.getActionCommand();
		if (component=="Envoyez le message aux utilisateurs connectes") {
			String sujet = textField.getText();
			String corps = textField2.getText();
			
			cons.EnvoiMessageAtoutleslistener(A.generEvent(sujet,corps));
			
			
			label.setText("le message a ete envoye");
			}
		if (component=="Deconnexion") {
			setVisible(false);
			FenetreConnexion.onlineUsers.remove(A.login);
			this.area2.setText(String.valueOf(FenetreConnexion.onlineUsers));
			this.label4.setText(affichageabel());

		}
		
		
}



	@Override
	public void ecouteMessage(PapotageEvent event) {
		lesmess.add(A.login+" a envoye, Sujet: " + event.getSujet()+" Corps: " +event.getCorps()+"\n");
		area.setText(String.valueOf(lesmess));
	}
	
	
}










