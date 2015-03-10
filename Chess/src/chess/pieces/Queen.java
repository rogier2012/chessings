package chess.pieces;

import chess.*;

public class Queen extends ChessPiece {
	
	public Queen(Color color, int rank, int file) {
		super(color, rank, file);
	}

	public boolean isValidMove(Move move) {
		return false;
	}

	public String toString() {
		return "Queen ";
	}
	

}
