package moveoptions;

import enums.Color;
import game.Game;
import moves.ForwardDouble;
import moves.Move;
import moves.MoveSuggestion;
import board.Square;

public class PawnForwardDouble extends MoveOption {
	
	public PawnForwardDouble(Color color)	{
		super(color);
		if(color == Color.WHITE)	{
			this.setDirection(new int[]{2, 0});
		} else if (color == Color.BLACK)	{
			this.setDirection(new int[]{-2, 0});
		}
		this.setRange(1);
	}

	public boolean specificRequirementsAreMet(Game game, MoveSuggestion move) {
		boolean result = true;
		// There are no pieces blocking the move
		Square pos1 = new Square(move.getOrigin().getRank() + this.getDirection()[0]/2, move.getOrigin().getFile());
		Square pos2 = new Square(move.getOrigin().getRank() + this.getDirection()[0], move.getOrigin().getFile());
		result = result && game.getBoard().getChessPiece(pos1) == null && game.getBoard().getChessPiece(pos2) == null;
		return result;
	}
	
	@Override
	public Move generateMove(MoveSuggestion suggestion) {
		ForwardDouble result = new ForwardDouble(suggestion.getOrigin(), suggestion.getDestination());
		return result;
	}
	
}
