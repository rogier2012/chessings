package moveoptions;

import enums.Color;
import game.Game;
import moves.Move;
import moves.MoveSuggestion;
import board.Square;

public class PawnForwardSingle extends MoveOption {

	public PawnForwardSingle(Color color) {
		super(color);
		if (color == Color.WHITE)	{
			this.setDirection(new int[]{1, 0});
		} else if (color == Color.BLACK)	{
			this.setDirection(new int[]{-1, 0});
		}
		this.setRange(1);
	}
	
	@Override
	public boolean specificRequirementsAreMet(Game game, MoveSuggestion move)	{
		Square check = new Square(move.getOrigin().getRank() + this.getDirection()[0], move.getOrigin().getFile());		
		return game.getBoard().getChessPiece(check) == null;
	}
	
	@Override
	public Move generateMove(MoveSuggestion suggestion) {
		Move result = new Move(suggestion.getOrigin(), suggestion.getDestination());
		return result;
	}
	
}
