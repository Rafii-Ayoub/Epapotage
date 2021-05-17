import java.util.ArrayList;

public class Concierge {

	private String sujet;
	
	
	private ArrayList<PapotageListener> listeners;
	
	
	public Concierge (String sujet) {
		this.setListeners(new ArrayList<PapotageListener>());
		this.sujet = sujet;
	}
	
	
	public void addListener(PapotageListener listener) {
		listeners.add(listener);
	}
	
	public void removeListener(PapotageListener listener) {
		listeners.remove(listener);
	}
	
	/*public void listenersConnected() {
		for (PapotageListener l : listeners) {
			System.out.println(getsujet() + " dit que le listener " + l.getsujet () + " est connecte");
		}
	}*/

	public String getsujet() {
		return sujet;
	}

	public void setsujet(String sujet) {
		this.sujet =sujet;
	}

	public ArrayList<PapotageListener> getListeners() {
		return this.listeners;
	}

	public void setListeners(ArrayList<PapotageListener> listeners) {
		this.listeners = listeners;
	}

	
	public void EnvoiMessageAtoutleslistener(String sujet, String corps) {
		PapotageEvent event = null;
		for (PapotageListener listener : listeners) {
			listener.ecouteMessage(event);
		}
		
	}
}
