package chess.boards;

import chess.Color;

public class ChessPieceMethods {
	
	public String toString(ChessPiece piece) {
		String result;
		if (piece.getColor().equals(Color.WHITE)) {
			result = "| W";
		} else if (piece.getColor().equals(Color.BLACK)) {
			result = "| B";
		} else {
			result = "Unknown!";
		}

		return result;
	}
	
	
}
