package chess.controller.players;

import chess.InputForMove;
import chess.model.Board;
import chess.model.Position;
import chess.model.moves.Move;
import chess.model.players.*;

public class HumanPlayerController {

	public Move determineMove(Board board, HumanPlayer human) {
		InputForMove input = new InputForMove();
		Position[] positions = input.input();
		
		return new Move(positions[0], positions[1]);
	}

}
