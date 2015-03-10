package chess.pieces;

import chess.*;

public class Pawn extends ChessPiece {
	private boolean firstMoveMade;
	private boolean isWhite;

	public Pawn(Color color, int rank, int file) {
		super(color, rank, file);
		firstMoveMade = false;
	}

	public String toString() {
		return "Pawn ";
	}

	public boolean isFirstMove() {
		return firstMoveMade;
	}

}
