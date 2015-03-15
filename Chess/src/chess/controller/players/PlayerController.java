package chess.controller.players;

import chess.model.Board;
import chess.model.players.*;
import chess.model.moves.Move;

public abstract class PlayerController {
	
	public abstract Move determineMove(Board board);
	
	//TODO
	public void makeMove(Player player, Board board)	{
		Move move = determineMove(board);
		
	}
	
}
