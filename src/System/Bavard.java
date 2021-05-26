import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import src.System.Events.*;
import src.System.Listeners.*;

public   class Bavard implements PapotageListener,OnLineListener, OffLineListener {
		private String login;
		private String password;
		private Messagerie mess;
		private String ok;
		protected boolean capteur = false;
	    protected OnLineEvent connectionEvent;
	    protected OffLineEvent logOutEvent;
        private Concierge concierge; 
	    private ArrayList<Bavard> listeners = new ArrayList<>();
		
		
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
		
		public String toString3() {
			return login+"\n"; 
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
		
		public Concierge getConcierge() {
			return this.concierge;
		}
		
		// Handle LogIn and LogOut 
		
		public boolean identical(Bavard bavard){
		    if (bavard.getLogin() == this.getLogin()){
		      return true;
		    }
		    else {
		      return false;
		    }
		  }
		 @Override
	
		 public void notifyMe(){
			    for (Bavard b: this.getConcierge().getListBavardConnected()){
			      if (listeners.contains(b)){
			        // do nothing
			      }

			      else{
			        notificateConnection(b);
			        listeners.add(b);
			      }
			    }
			  }
		 public OffLineEvent getLogOutEvent(){
		    return this.logOutEvent;
		  }

		  @Override
		  public void setLogOutEvent(){
		    this.logOutEvent = new OffLineEvent(this);
		  }

		  public void deleteFromList(Bavard b){
		    for (int i = 0; i < this.listeners.size(); i++){
		      if (b.identical(this.listeners.get(i))){
		        this.listeners.remove(i);
		      }
		    }
		  }

		  @Override
		  /**
		    * send the notification
		    */
		  public void logOutNotification(Bavard b){
		    
		    this.deleteFromList(b);
		    if (this.identical(b)){
		        // do nothing
		      }
		      else{
		    	  //refresh the page
		    	  
		      }
		  }
		
}
		




