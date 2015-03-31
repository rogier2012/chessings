package chess.controller.players;

import chess.model.Board;
import chess.model.moves.Move;
import chess.model.players.*;

public class ComputerPlayerController {

	public Move determineMove(Board board, ComputerPlayer player) {
		return player.getStrategy().determineMove(board, player.getColor());
	}
	
}
