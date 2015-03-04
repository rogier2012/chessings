package chess.pieces;

import chess.*;

public class Queen extends ChessPiece {
	
	public Queen(Color color, int rank, int file) {
		super(color, rank, file);
	}

	@Override
	public boolean isValidMove() {
		return false;
	}

	

}
