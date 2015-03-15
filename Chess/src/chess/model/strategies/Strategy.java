package chess.model.strategies;

import chess.model.*;

public interface Strategy {
	public String getName();
	public int determineMove(Board board, Color color);
}