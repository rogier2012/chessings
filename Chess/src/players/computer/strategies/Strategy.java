package players.computer.strategies;

import enums.Color;
import game.Game;

import java.util.List;

import moves.Move;
import board.Square;

public interface Strategy {
	public String getName();
	
	public Move determineMove(List<Move> options, Game game, Color color);
	
	public String determinePromotion(Square position, Game game);
	
	public boolean remise(Color color, Game game);
	
}