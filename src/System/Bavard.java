import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import src.GUIs.*;

public class Bavard implements PapotageListener {
		public String login;
		public String password;
		public Messagerie mess;
		public String ok;
	
		
		
		// Constructors
		
		Bavard(String login,String password){
			this.login=login;
			this.password=password;
			this.ok=String.valueOf(mess);
			
		}
		
		
		/**
		 * Constructor with generated login and password
		 */
		
		Bavard(){
			Random r = new Random();
			char c = (char)(r.nextInt(26) + 'a');
			String random = "";
			int n = 3;
			for(int i=0; i < n; i++) {
				  random = random + c;
			}
			
			this.login=random;
			this.password=random;
			this.ok=String.valueOf(mess);
			
		}
		
		
		public PapotageEvent generEvent(String sujet,String corps) {
			PapotageEvent P=new PapotageEvent(this,sujet,corps);
			this.login=login;
			return P;
			
		}
		
	

		@Override
		public void ecouteMessage(PapotageEvent even) {
			
			this.mess.ecouteMessage(even);
		}
		
		
		@Override
		public String toString() {
			return "["+ login + "|" + password + "]";
		}
		
		public String toString2() {
			return "Bavard "+login+" est crée son mp: "+password ; 
		}
		
		public Messagerie getMess() {
			return mess;
		}
		
		// getters and setters
		public void setMess(Messagerie mess) {
			this.mess=mess;
		}

		public String getLogin() {
			return login;
		}


		public void setLogin(String login) {
			this.login = login;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}
		
}
		



