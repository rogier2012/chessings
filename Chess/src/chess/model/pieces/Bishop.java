package chess.model.pieces;

import chess.model.Board;
import chess.model.Color;
import chess.model.Position;
import chess.model.moveoptions.MoveOption;

public class Bishop extends ChessPiece {
	
	public Bishop(Color color, Position position)	{
		super(color, position);
		
		// Set moveOptions
		this.getMoveOptions().add(new MoveOption(1, 1, Board.RANKS));
		this.getMoveOptions().add(new MoveOption(1, -1, Board.RANKS));
		this.getMoveOptions().add(new MoveOption(-1, 1, Board.RANKS));
		this.getMoveOptions().add(new MoveOption(-1, -1, Board.RANKS));
		
	}
}
