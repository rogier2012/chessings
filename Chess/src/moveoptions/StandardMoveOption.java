package moveoptions;

import enums.Color;
import game.Game;
import moves.Move;
import moves.MoveSuggestion;

public class StandardMoveOption extends MoveOption {

	public StandardMoveOption(int rankStep, int fileStep, int range) {
		super(rankStep, fileStep, range);
	}

	public StandardMoveOption(Color color) {
		super(color);
	}

	@Override
	public boolean specificRequirementsAreMet(Game game, MoveSuggestion move) {
		// No requirements specific to this type of moveoption
		return true;
	}

	@Override
	public Move generateMove(MoveSuggestion suggestion) {
		Move result = new Move(suggestion.getOrigin(), suggestion.getDestination());
		return result;
	}
	
}
