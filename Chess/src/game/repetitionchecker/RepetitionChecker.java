package game.repetitionchecker;

/**
 *  Checks the following condition:
 *  3 Subsequent moves of a certain player result in the same board configuration*.
 *  
 *  	*The amount of possibilities for moves should be the same as well in each configuration!
 */
public interface RepetitionChecker {
	
	/**
	 * @return -- 3 Subsequent moves resulted in the same board configuration
	 */
	public boolean threefoldRepetition();
	
}
