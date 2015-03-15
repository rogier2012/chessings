package chess.model.strategies;

import chess.model.moves.*;
import chess.model.*;

public interface Strategy {
	public String getName();
	public Move determineMove(Board board, Color color);
}