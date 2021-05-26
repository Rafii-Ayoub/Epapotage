
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

 



public class FenetreConnexion extends JFrame {
	  
	  private JPanel pan = new JPanel();
	  
	  public static ArrayList<String> onlineUsers=new ArrayList<String>();
	  
	  private JButton bouton2 = new JButton("cliquez pour vous connecter");
	  public static String onlineUsers2 ="";
	  
	  private JPanel container = new JPanel();
	  private JLabel label = new JLabel("Veuillez vous connectez");
	  private String text;
	  private JTextField textField = new JTextField(20);
	  private JTextField textField2 = new JTextField(20);  
	  private Concierge concierge;
	  
	  
	  public FenetreConnexion(Concierge concierge){
	    this.setTitle("La fenetre de connexion");
	    this.setSize(500, 300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null); 
	    this.concierge =concierge;
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
	    
	    
	    Font police = new Font("Tahoma", Font.BOLD, 16);
	    label.setFont(police);  
	    label.setForeground(Color.blue); 
	    label.setHorizontalAlignment(JLabel.CENTER);
	    container.add(label, BorderLayout.NORTH);
	    
	    
	    this.setContentPane(container);
	    this.setVisible(true);
	    
	    
	    
	    Concierge cons1=this.concierge;
	    bouton2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		boolean x=false;
	    		String login = textField.getText();
				String password =textField2.getText();
				boolean authentification = cons1.authentification ( login,  password) ;
				if (authentification== true) {
					Bavard connected_bavard =  cons1.getBavardAuthentification(login,  password);
					label.setText("Connexion Reussi ");
					Messagerie m= new Messagerie (connected_bavard,cons1);
					for (int j=0;j<FenetreConnexion.onlineUsers.size();j++){
						if (FenetreConnexion.onlineUsers.get(j)==connected_bavard.toString()){
							x=true;
						}
					}
					if (x==false) {
						onlineUsers.add(connected_bavard.toString3());
						String str =  connected_bavard.toString3();
						onlineUsers2.concat(str);
					
						Messagerie.area2.setText(String.valueOf(FenetreConnexion.onlineUsers));
					}
				}
				else {
					label.setText("Connexion Echoué, login ou mp incorrect ");
				}
				
			
				}
	    	
	    	
	    });
	    
	  }
}
	    
