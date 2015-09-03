package game.moveoptionmapping;

import java.util.Set;

import moveoptions.MoveOption;
import moves.Move;
import pieces.ChessPiece;
import enums.Color;

/**
 * Maps MoveOptions to ChessPieces
 */
public interface MoveMapping {
	
	public Set<MoveOption> getOptions(ChessPiece piece);
	
	public Set<MoveOption> getColorOptions(Color color);
	
	public Set<MoveOption> getAllOptions();
	
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
