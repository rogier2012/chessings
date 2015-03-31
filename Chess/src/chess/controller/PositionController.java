package chess.controller;

import chess.model.Board;
import chess.model.Position;

public class PositionController {
	
	public static boolean isWithinRange(Position pos) {
		boolean result = false;
		if (pos.getFile() < Board.FILES && pos.getRank() < Board.RANKS) {
			result = true;
		}
		return result;
	}
}
