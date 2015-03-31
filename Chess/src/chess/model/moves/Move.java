package chess.model.moves;

import chess.model.Position;

public class Move {
	
	private Position initialPoint;
	private Position endPoint;
	
	public Move(Position initialPoint, Position endPoint) {
		this.initialPoint = initialPoint;
		this.endPoint = endPoint;
	}
	
	public void setInitial(Position pos)	{
		this.initialPoint = pos;
	}
	
	public void setEnd(Position pos)	{
		this.endPoint = pos;
	}
	
	public Position getInitial() {
		return initialPoint;
	}
	public Position getEnd() {
		return endPoint;
	}
}
