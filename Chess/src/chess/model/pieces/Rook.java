package chess.model.pieces;

import chess.model.*;

public class Rook extends ChessPiece{
	
	private boolean firstMoveDone;
	
	public Rook(Color color, Position position)	{
		super(color, position);
		
		this.firstMoveDone = false;
	}

	public boolean isFirstMoveDone() {
		return firstMoveDone;
	}

	public void setFirstMoveDone(boolean firstMoveDone) {
		this.firstMoveDone = firstMoveDone;
	}
}
