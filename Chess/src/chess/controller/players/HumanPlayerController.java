package chess.controller.players;

import chess.InputForMove;
import chess.model.Board;
import chess.model.Position;
import chess.model.moves.Move;

public class HumanPlayerController extends PlayerController {
	
	//TODO make controller
	@Override
	public Move determineMove(Board board) {
		InputForMove input = new InputForMove();
		Position[] positions = input.input();
		
		return new Move(positions[0], positions[1]);
	}
	
}
