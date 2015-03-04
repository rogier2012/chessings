package chess.pieces;

import chess.*;

public class Rook extends ChessPiece {
	
	private boolean firstMoveMade;
	
	public Rook(Color color, int rank, int file, boolean firstMoveMade) {
		super(color, rank, file, firstMoveMade);
		// TODO Auto-generated constructor stub
	}

	public boolean isValidMove() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void setFirstMoveMade() {
		firstMoveMade = true;
	}


}
