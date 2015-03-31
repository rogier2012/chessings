package chess.model.strategies;

import chess.model.Board;
import chess.model.Color;
import chess.model.moves.Move;
import chess.model.*;

public class TestStrategy implements Strategy {
	
	private String name;
	
	public TestStrategy()	{
		this.name = "Barry";
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Move determineMove(Board board, Color color) {
		
		Position begin;
		Position end;
		
		begin = new Position( (int)(Math.random()*8), (int)(Math.random()*8));
		end = new Position( (int)(Math.random()*8), (int)(Math.random()*8));
		
		Move move = new Move(begin, end);
		return move;
	}
	
}
