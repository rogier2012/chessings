package chess.pieces;

import chess.*;

public class Pawn extends ChessPiece {

	@Override
	public boolean isValidMove() {
		// TODO Auto-generated method stub
		return false;
	}

	public Pawn(Color color, int rank, int file, boolean firstMoveMade) {
		super(color, rank, file, firstMoveMade);
	}


}
