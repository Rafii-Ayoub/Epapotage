import java.util.ArrayList;
import java.util.Random;



public class ConciergeDB {
	
	// Declaration of attributes
	ArrayList<Concierge> conciergeDB ;
    
	
	// constructor
	public ConciergeDB() {
		super();
		this.conciergeDB = new ArrayList<>();
	}
	
	
	
	/**
	 * 
	 * @return a random concierge
	 */
	
	public Concierge getRandomConcierge() {
				
	Random rand = new Random();
    Concierge randomConcierge = conciergeDB.get(rand.nextInt(conciergeDB.size()));
    return randomConcierge;
    
	}
	
	/**
	 *  This method is used to authentificate a concierge from conciergeList
	 * @param id
	 * @param password
	 * @return a booelean
	 */
	public boolean authentification(int id, int password) {
		for (int i=0;i<conciergeDB.size();i++){
		    Concierge concierge2 = conciergeDB.get(i);
		    int idl = concierge2.getId();
		    int passwordl = concierge2.getPassword();
			if ( idl==id && passwordl== password ) {
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
	
	public Concierge getConciergeAuthentification(int id, int password) {
		Concierge concierge_to_return = null;
		for (int i=0;i<conciergeDB.size();i++){
		    Concierge concierge2 = conciergeDB.get(i);
		    int idl = concierge2.getId();
		    int passwordl = concierge2.getPassword();
			if ( idl==id && passwordl== password ) {
			       concierge_to_return = concierge2;  
				break;  }
			
				}
		return concierge_to_return;
		
	}
	
	// methods to manipulate Concierge object in the ConciergeDB ArrayList
	 
	public void addConcierge(Concierge concierge) {
		conciergeDB.add(concierge);
	}
	
	public void removeBavard(Concierge concierge) {
		conciergeDB.remove(concierge);
	}
	
	
	
	// Getters and setters
	
	public ArrayList<Concierge> getConcierges(){
		return conciergeDB;
	}
	

	public ArrayList<Concierge> getDB() {
		return this.conciergeDB;
	}
 
	public String toString() {
		return  "ConciergeDB : " + conciergeDB;
	}
	
	
}
