package chess.model.pieces;

import chess.model.*;

public class Knight extends ChessPiece {
	
	private boolean firstMoveDone;
	
	public Knight(Color color, int rank, int file)	{
		super(color, rank, file);
		
		this.firstMoveDone = false;
	}

	public boolean isFirstMoveDone() {
		return firstMoveDone;
	}

	public void setFirstMoveDone(boolean firstMoveDone) {
		this.firstMoveDone = firstMoveDone;
	}
	
}
