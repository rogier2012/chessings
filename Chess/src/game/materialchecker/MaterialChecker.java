package game.materialchecker;

/**
 *  Checks if there is enough material on the board for the game to end.
 *   - Both players don't have enough pieces if:
 *  		* King v.s. King
 *  		* King v.s. King + Knight
 *  		* King v.s. King + Bishop
 *  		* King + Bishop v.s. King + Bishop (Bishops should share tile color)
 *
 */
public interface MaterialChecker {
	
	/**
	 * @return -- There are enough pieces on the board for a check mate
	 */
	public boolean sufficientMaterial();
	
}
