import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class Concierge {
	
   // Declaration of attributes
	
   private int id ;
   private int password;
   private static final AtomicInteger count1 = new AtomicInteger(1000); 
   private static final AtomicInteger count2 = new AtomicInteger(1000);
   public List<Bavard> listeners;
   protected ArrayList<Bavard> bavardConnected = new ArrayList<Bavard>();
   // Constructors
   
   /**
    * The first constructor is used if the user wants to attribute a id and password for the concierge  
    * @param id
    * @param password
    * 
    */
	
	public Concierge(int id, int password) {
	super();
	this.id = id;
	this.password= password;
	listeners = new ArrayList<Bavard>();
}
	/**
	 * This second constructor is used if the user wants a generated password and id
	 */
	public Concierge() {
		this.password = count1.incrementAndGet();
		this.id = count2.incrementAndGet();
		listeners = new ArrayList<Bavard>();
	}
	
	public List<Bavard> getListeners() {
		return this.listeners;
	}

	
   /**
    * 
    * @param event
    * @method that sends received msgs from concierge to all other bavards
    */
	
	public void sendToAllListeners(PapotageEvent event) {
		for (Bavard listener : listeners) {
			listener.ecouteMessage(event);
		}
		
	}
	/**
	 *  This method is used to authentificate a concierge from conciergeList
	 * @param id
	 * @param password
	 * @return a booelean
	 */
	public boolean authentification(String id, String password) {
		for (int i=0;i<listeners.size();i++){
		    Bavard bavard2 = listeners.get(i);
		    String loginl = bavard2.getLogin();
		    String passwordl = bavard2.getPassword();
			if ( loginl.equals(id) && passwordl.equals(password)  ) {
			         return true; }
			
				}
		return false;
	}
	
	/**
	 * This methods return a concierge from ConciergDB that has the same (id,password) 
	 * @param id
	 * @param password
	 * @return Concierge 
	 */
	
	public Bavard getBavardAuthentification(String id, String password) {
		Bavard bavard_to_return = null;
		for (int i=0;i<listeners.size();i++){
		    Bavard bavard2 = listeners.get(i);
		    String loginl = bavard2.getLogin();
		    String passwordl = bavard2.getPassword();
			if (  loginl.equals(id) && passwordl.equals(password) ) {
			       bavard_to_return = bavard2;  
				break;  }
			
				}
		return bavard_to_return;
		
	}

	// Methods to manipulate listeners and Bavards 
	
	public void addBavard(Bavard listener) {
		listeners.add(listener);
	}
	
	public void removeBavard(Bavard listener) {
		listeners.remove(listener);
	}
	



	@Override
	public String toString() {
		return "Concierge [id=" + id + ", password=" + password + ", listeners=" + listeners + "]";
	}
	
	public String toString2() {
		return " Concierge: " + id + " est crée, son mp:" + password ;
	}
	
	
	// getters and setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
		
	}
	
	 // Methods for handling Login and LogOut notification
	
	
	  public void setConnectedList(Bavard bavard){
		    /*
		    * sets the list of connected person
		    */
		    this.bavardConnected.add(bavard);
		    for (Bavard b : this.getListeners()){
		      b.notifyMe();
		    }
		  }

	  public void addNewBavardConnected(Bavard bavard){
		    this.bavardConnected.add(bavard);
		  }


		  public ArrayList<Bavard> getListBavardConnected(){
		    return bavardConnected;
		  }
		  public void deleteFromList(Bavard b){
		    for (int i = 0; i < this.getListBavardConnected().size(); i++){
		      if (this.getListBavardConnected().get(i) == b){
		        this.getListBavardConnected().remove(i);
		        b.turnCapteurOff();
		      }
		    }
		  }

		  // public PapotageSource getClass
		  public void logOut(Bavard bavard){
		    // remove the bavard from the list of connected baverd
		    this.deleteFromList(bavard);
		    // send the notification to each bavard in the group
		    for (Bavard b : this.getListeners()){
		        b.logOutNotification(bavard);
		    }
		  }

	
}
