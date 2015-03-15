package chess.model.players;

import chess.*;
import chess.model.*;
import chess.model.moves.*;

public class HumanPlayer extends Player{

	public HumanPlayer(String aName, Color aColor) {
		super(aName, aColor);
	}

	
	//TODO make controller
	@Override
	public Move determineMove(Board board) {
		InputForMove input = new InputForMove();
		Position[] positions = input.input();
		
		return new Move(positions[0], positions[1]);
	}
}
