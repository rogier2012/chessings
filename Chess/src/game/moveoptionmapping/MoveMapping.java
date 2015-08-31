package game.moveoptionmapping;

import moves.Move;

/**
 * Maps MoveOptions to ChessPieces
 */
public interface MoveMapping {
	
	/**
	 * Removes piece from mapping if it is captured
	 * Removes move options from pieces if the move dictates this (e.g. castling removed after king movement)
	 * @param move -- move that was just done
	 */
	public void update(Move move);
	
	/**
	 * Reset move option mapping to default configuration
	 */
	public void reset();
	
}
