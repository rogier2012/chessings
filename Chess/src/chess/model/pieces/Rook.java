package chess.model.pieces;

import chess.model.Board;
import chess.model.Color;
import chess.model.Position;
import chess.model.moveoptions.MoveOption;

public class Rook extends ChessPiece{
	
	private boolean firstMoveDone;
	
	public Rook(Color color, Position position)	{
		super(color, position);
		
		// Set MoveOptions
		this.getMoveOptions().add(new MoveOption(1, 0, Board.RANKS));
		this.getMoveOptions().add(new MoveOption(0, 1, Board.RANKS));
		this.getMoveOptions().add(new MoveOption(-1, 0, Board.RANKS));
		this.getMoveOptions().add(new MoveOption(0, -1, Board.RANKS));
		
		this.firstMoveDone = false;
	}

	public boolean isFirstMoveDone() {
		return firstMoveDone;
	}

	public void setFirstMoveDone(boolean firstMoveDone) {
		this.firstMoveDone = firstMoveDone;
	}
}
