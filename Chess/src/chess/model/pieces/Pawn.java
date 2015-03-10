package chess.model.pieces;

import chess.*;
import chess.Position;

public class Pawn extends ChessPiece{
	
	private boolean firstMoveDone;
	private boolean secondMoveDone;
	
	public Pawn(Color color, int rank, int file)	{
		super(color, rank, file);
		firstMoveDone = false;
		secondMoveDone = false;
	}
	
	public boolean isFirstMoveDone()	{
		return this.firstMoveDone;
	}

	public boolean isSecondMoveDone() {
		return secondMoveDone;
	}

	public void setSecondMoveDone(boolean b) {
		this.secondMoveDone = b;
	}

	public void setFirstMoveDone(boolean b) {
		this.firstMoveDone = b;
	}
}
