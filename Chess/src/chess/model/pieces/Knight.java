package chess.model.pieces;

import chess.model.Color;
import chess.model.Position;
import chess.model.moveoptions.MoveOption;

public class Knight extends ChessPiece {
	
	private boolean firstMoveDone;
	
	public Knight(Color color, Position position)	{
		super(color, position);
		
		// Set MoveOptions
		this.getMoveOptions().add(new MoveOption(1, 2, 1));
		this.getMoveOptions().add(new MoveOption(2, 1, 1));
		this.getMoveOptions().add(new MoveOption(-1, 2, 1));
		this.getMoveOptions().add(new MoveOption(2, -1, 1));
		this.getMoveOptions().add(new MoveOption(1, -2, 1));
		this.getMoveOptions().add(new MoveOption(-2, 1, 1));
		this.getMoveOptions().add(new MoveOption(-1, -2, 1));
		this.getMoveOptions().add(new MoveOption(-2, -1, 1));
		
		this.firstMoveDone = false;
	}

	public boolean isFirstMoveDone() {
		return firstMoveDone;
	}

	public void setFirstMoveDone(boolean firstMoveDone) {
		this.firstMoveDone = firstMoveDone;
	}
	
}
