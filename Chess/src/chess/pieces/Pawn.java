package chess.pieces;

import chess.*;

public class Pawn extends ChessPiece {
	private boolean firstMoveMade;
	private boolean isWhite;

	@Override
	public boolean isValidMove(Move move) {
		Position initialPoint = move.getInitial();
		Position endPoint = move.getEnd();
		if ((initialPoint.getRank() == endPoint.getRank() - 1) && initialPoint.getFile() == endPoint.getFile()) {
			return true;
		} else if (initialPoint.getRank() == endPoint.getRank() - 1) {
			
		}
		return false;
	}

	public Pawn(Color color, int rank, int file) {
		super(color, rank, file);
		firstMoveMade = false;
	}

	public String toString() {
		return "Pawn ";
	}

}
