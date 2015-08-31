package game.movegenerator;

import java.util.ArrayList;

import moves.Move;
	
/**
 * Generates valid moves
 */
public interface MoveGenerator {
	
	/**
	 * @return -- All moves that are currently possible
	 */
	public ArrayList<Move> getValidMoves();
	
}
