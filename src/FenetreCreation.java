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

import javax.swing.JTextField;


public class FenetreCreation extends JFrame implements ActionListener{
	private JPanel pan = new JPanel();
	private JButton bouton = new JButton("cliquez pour creer un bavard");
	private JButton bouton2 = new JButton("se connecter");
	private JPanel container = new JPanel();
	private JLabel label = new JLabel("Bienvenue sur l'applications");
	private String text;
	private JTextField textField = new JTextField(20);
	private JTextField textField2 = new JTextField(20);
	private Concierge cons;
	public FenetreCreation(Concierge cons){
		this.setTitle("La fenetre de Creation de Bavard");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); 
		this.cons=cons;
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
		pan.add(textField2);
		pan.add(bouton2, BorderLayout.CENTER); 

		container.add(pan, BorderLayout.CENTER);


		container.add(bouton, BorderLayout.SOUTH);    



		Font police = new Font("Tahoma", Font.BOLD, 16);
		label.setFont(police);  
		label.setForeground(Color.blue); 
		label.setHorizontalAlignment(JLabel.CENTER);
		container.add(label, BorderLayout.NORTH);


		this.setContentPane(container);
		this.setVisible(true);

		
		bouton.addActionListener(this);
		bouton2.addActionListener(this);
		
	}



	public void actionPerformed(ActionEvent e) {
		String component=e.getActionCommand();
		if (component=="cliquez pour creer un bavard") {
			
			String login = textField.getText();
			String motpasse = textField2.getText();
			Bavard A=new Bavard(login,motpasse);
			label.setText("Vous avez Ajouter un nouveau Bavard ");
			this.cons.addBavard(A);
			System.out.println(cons);
		}
		if (component=="se connecter") {
			FenetreConnexion A=new FenetreConnexion(this.cons);

		}
	}
}















