package chess.pieces;

import chess.*;

public class Pawn extends ChessPiece {
	private boolean firstMoveMade;
	@Override
	public boolean isValidMove() {
		// TODO Auto-generated method stub
		return false;
	}

	public Pawn(Color color, int rank, int file) {
		super(color, rank, file);
		firstMoveMade = false;
	}


}
