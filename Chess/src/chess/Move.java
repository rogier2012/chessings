package chess;

public class Move {
	
	private Position initialPoint;
	private Position endPoint;
	
	public Move(Position initialPoint, Position endPoint) {
		this.initialPoint = initialPoint;
		this.endPoint = endPoint;
	}
	public Position getInitial() {
		return initialPoint;
	}
	public Position getEnd() {
		return endPoint;
	}
}
