package chess;

public class Twello {

	public static void main(String[] args) {
		Ron ron = new Ron();
		
		ron.watIsRon();
	}

	/*
	 * Uw uitlaatklep voor alle grappen, grollen, meligheden en gedoe. Klasse.
	 */

}

class Ron {

	private String antwoord = "aardbei";
	private boolean isRonDood;

	public Ron() {

	}

	public String waaromTwello() {
		return antwoord;
	}
	

	// Tip van bob voor GUI: libgdx

	public void moveRon(int rageLvl){
		if (rageLvl > 10 ){
			isRonDood = true;
		} else {
			rageLvl++;
		}

	}
	public void watIsRon() {
		System.out.println("Wat ben je?");
		try {
			Thread.sleep(2234);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("een beunhaas");
		
		weetjeWatJijBent();
	}
	public void weetjeWatJijBent() {
		try {
			Thread.sleep(2234);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Beunhaaas beunhaas jij bent een beunhaasss.......");
		// Copyright RvB
		
		weetjeWatJijBent();

	}
}
