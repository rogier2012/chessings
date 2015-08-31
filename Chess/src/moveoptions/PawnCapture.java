package moveoptions;

import enums.Color;
import enums.Horizontal;
import game.Game;
import moves.Move;
import moves.MoveSuggestion;
import pieces.ChessPiece;

public class PawnCapture extends MoveOption {
	
	public PawnCapture(Horizontal direction, Color color) {
		super(color);
		if (color == Color.WHITE)	{
			this.setDirection(new int[]{1, direction.value()});
		} else if (color == Color.BLACK)	{
			this.setDirection(new int[]{-1, direction.value()});
		}
		this.setRange(1);
	}

	@Override
	public boolean specificRequirementsAreMet(Game game, MoveSuggestion suggestion) {
		boolean result = true;
		ChessPiece opponent = game.getBoard().getChessPiece(suggestion.getDestination());
		ChessPiece attacker = game.getBoard().getChessPiece(suggestion.getOrigin());
		// Target field is not empty
		result = result && opponent != null;
		// Target field occupied by opponent
		result = result && !(attacker.getColor() == opponent.getColor());
		return result;
	}
	
	@Override
	public Move generateMove(MoveSuggestion suggestion) {
		Move result = new Move(suggestion.getOrigin(), suggestion.getDestination());
		return result;
	}
	
}
