package game.fiftymoverule;

/**
 *  Represents the fifty-move rule in chess
 */
public interface FiftyMoveRuleCheck {
	
	/**
	 * @return -- In 50 subsequent moves no pawns were moved or pieces were captured
	 */
	public boolean remise();
	
}
