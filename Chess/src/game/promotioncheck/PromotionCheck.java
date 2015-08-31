package game.promotioncheck;

import moves.Move;
import players.Player;

/**
 * Checks if a move results in pawn promotion. Asks the player to which piece a pawn should be promoted if this is required.
 */
public interface PromotionCheck {
	
	/**
	 * Checks if a move results in pawn promotion. Asks the player to which piece a pawn should be promoted if this is required.
	 * @param move -- move that was just executed
	 * @param player -- player that did the move
	 */
	public void promotionCheck(Move move, Player player);
	
}
