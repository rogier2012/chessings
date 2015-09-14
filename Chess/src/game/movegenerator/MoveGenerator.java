package game.movegenerator;

import java.util.List;

import moves.Move;
	
/**
 * Generates valid moves
 */
public interface MoveGenerator {
	
	/**
	 * @return -- All moves that are currently possible
	 */
	public List<Move> getValidMoves();
	
}
