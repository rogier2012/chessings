package chess.pieces;

import chess.*;

public class Knight extends ChessPiece {

	public Knight(Color color, int rank, int file) {
		super(color, rank, file);
	}

	@Override
	public boolean isValidMove() {
		return false;
	}

	public String toString() {
		return "Knight";
	}
	
}
