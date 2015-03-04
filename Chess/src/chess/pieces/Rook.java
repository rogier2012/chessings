package chess.pieces;

import chess.*;

public class Rook extends ChessPiece {
	
	private boolean firstMoveMade;
	
	public Rook(Color color, int rank, int file) {
		super(color, rank, file);
		firstMoveMade = false;
	}

	public boolean isValidMove() {
		return true;
	}
	
	public void setFirstMoveMade() {
		firstMoveMade = true;
	}


}
