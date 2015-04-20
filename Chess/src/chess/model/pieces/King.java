package chess.model.pieces;

import chess.model.Color;
import chess.model.Position;
import chess.model.moveoptions.MoveOption;

public class King extends ChessPiece {
	
	private boolean firstMoveDone;
	
	public King(Color color, Position position)	{
		super(color, position);
		firstMoveDone = false;
		
		// Set MoveOptions
		this.getMoveOptions().add(new MoveOption(1, 1, 1));
		this.getMoveOptions().add(new MoveOption(1, 0, 1));
		this.getMoveOptions().add(new MoveOption(0, 1, 1));
		this.getMoveOptions().add(new MoveOption(1, -1, 1));
		this.getMoveOptions().add(new MoveOption(-1, 1, 1));
		this.getMoveOptions().add(new MoveOption(-1, -1, 1));
		this.getMoveOptions().add(new MoveOption(-1, 0, 1));
		this.getMoveOptions().add(new MoveOption(0, -1, 1));
		// Castle TODO
		this.getMoveOptions().add(new MoveOption(0, 3, 1));
		this.getMoveOptions().add(new MoveOption(0, -2, 1));
		
	}

	public boolean isFirstMoveDone() {
		return firstMoveDone;
	}

	public void setFirstMoveDone(boolean firstMoveDone) {
		this.firstMoveDone = firstMoveDone;
	}
	
}
