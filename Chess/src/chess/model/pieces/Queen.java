package chess.model.pieces;

import chess.model.*;
import chess.model.moveoptions.MoveOption;

public class Queen extends ChessPiece{
	
	public Queen(Color color, Position position)	{
		super(color, position);
		
		// Set MoveOptions
		this.getMoveOptions().add(new MoveOption(1, 1, Board.RANKS));
		this.getMoveOptions().add(new MoveOption(1, 0, Board.RANKS));
		this.getMoveOptions().add(new MoveOption(0, 1, Board.RANKS));
		this.getMoveOptions().add(new MoveOption(1, -1, Board.RANKS));
		this.getMoveOptions().add(new MoveOption(-1, 1, Board.RANKS));
		this.getMoveOptions().add(new MoveOption(-1, -1, Board.RANKS));
		this.getMoveOptions().add(new MoveOption(-1, 0, Board.RANKS));
		this.getMoveOptions().add(new MoveOption(0, -1, Board.RANKS));
	}
	
}
