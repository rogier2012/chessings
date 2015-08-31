package moveoptions;

import enums.Color;
import enums.Horizontal;
import game.Game;
import moves.EnPassantCapture;
import moves.ForwardDouble;
import moves.Move;
import moves.MoveSuggestion;
import pieces.ChessPiece;
import board.Square;

public class PawnEnPassant extends MoveOption {
	
	/*
	 * Instance Variables
	 */
	
	private Horizontal direction;
	
	/*
	 * Constructors
	 */
	
	public PawnEnPassant(Horizontal direction, Color color) {
		super(color);
		if (color == Color.WHITE)	{
			this.setDirection(new int[]{1, direction.value()});
		} else if (color == Color.BLACK)	{
			this.setDirection(new int[]{-1, direction.value()});
		}
		this.setRange(1);
		
		this.direction = direction;
	}
	
	/*
	 * Queries
	 */
	
	@Override
	public boolean specificRequirementsAreMet(Game game, MoveSuggestion suggestion) {
		boolean result;
		ChessPiece opponent = game.getBoard().getChessPiece(suggestion.getDestination());
		// Target field is empty
		result = opponent == null;
		result = result && game.getHistory().getAllMoves().size() > 0; 										/* En Passant can't occur at the first move */
		if (result)	{
			Move previousMove = game.getHistory().getMove(game.getMoveIndex() - 1);
			Square origin = suggestion.getOrigin();
			Square adjacent = new Square(origin.getRank(), origin.getFile() + direction.value()); 			/* Square adjacent to the attacking pawn */
			result = result && previousMove instanceof ForwardDouble; 										/* Previous move was double forward */
			result = result && previousMove.getDestination().isEqual(adjacent);								/* double forward was adjacent to attacking pawn */
		}
		return result;
	}
	
	@Override
	public Move generateMove(MoveSuggestion suggestion) {
		EnPassantCapture result = new EnPassantCapture(suggestion.getOrigin(), suggestion.getDestination());
		return result;
	}
	
}
