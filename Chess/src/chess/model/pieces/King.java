package chess.model.pieces;

import chess.model.*;

public class King extends ChessPiece {
	
	private boolean firstMoveDone;
	
	public King(Color color, int rank, int file)	{
		super(color, rank, file);
		
		firstMoveDone = false;
	}

	public boolean isFirstMoveDone() {
		return firstMoveDone;
	}

	public void setFirstMoveDone(boolean firstMoveDone) {
		this.firstMoveDone = firstMoveDone;
	}
	
}
