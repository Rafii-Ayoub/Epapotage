import java.util.ArrayList;
import java.util.List;

public class Bavard implements PapotageListener {
	
		private String sujet;
		
		public Bavard (String sujet) {
			this.sujet = sujet;
		}

		public void setsujet(String sujet) {
			this.sujet = sujet;
		}

	
		
		public String getsujet() {
			return this.sujet;
		}
		
		@Override
		public void ecouteMessage(PapotageEvent even) {
			System.out.println(this.sujet + "A recu: " + sujet + " " + event);
		}
	}
