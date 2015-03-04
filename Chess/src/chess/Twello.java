package chess;

public class Twello {
	
	private String antwoord = "";
	private boolean isRonDood;
	/*
	 * Uw uitlaatklep voor alle grappen, grollen, meligheden en gedoe. Klasse.
	 */
	public String waaromTwello() {
		return antwoord;
	}
	
	public void moveRon(int rageLvl){
		if (rageLvl > 10 ){
			isRonDood = true;
		} else {
			rageLvl++;
		}
		
	}
	
}
