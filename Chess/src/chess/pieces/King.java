package chess.pieces;

import chess.*;

public class King extends ChessPiece {
	private boolean firstMoveMade;

	public King(Color color, int rank, int file) {
		super(color, rank, file);
		firstMoveMade = false;
	}

	@Override
	public boolean isValidMove(Move move) {
		return false;
	}
	
	public String toString() {
		return "King ";
	}


}
