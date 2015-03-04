package chess.pieces;

import chess.*;

public class Rook extends ChessPiece {
	
	private boolean firstMoveMade;
	
	public Rook(Color color, int rank, int file) {
		super(color, rank, file);
		firstMoveMade = false;
	}

	public boolean isValidMove() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void setFirstMoveMade() {
		firstMoveMade = true;
	}


}
