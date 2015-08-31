package moves;

import board.ChessBoard;
import board.Square;

public class Move {
	
	/*
	 * Instance variables
	 */
	
	private Square origin;
	private Square destination;
	
	/*
	 * Constructors
	 */
	
	public Move(Square initialPoint, Square endPoint) {
		this.origin = initialPoint;
		this.destination = endPoint;
	}
	
	/*
	 * Queries
	 */
	
	public Move deepCopy()	{
		Move copy = new Move(this.origin.deepCopy(), this.destination.deepCopy());
		return copy;
	}
	
	@Override
	public String toString()	{
		return this.origin.toString() + " to " + this.destination.toString();
	}
	
	/*
	 * Commands
	 */
	
	public void executeOn(ChessBoard board)	{
		board.setPiece(this.destination, board.getChessPiece(this.origin));
		board.clear(this.origin);
	}
	
	/*
	 * Getters and Setters
	 */
	
	public void setOrigin(Square pos)	{
		this.origin = pos;
	}
	
	public void setDestination(Square pos)	{
		this.destination = pos;
	}
	
	public Square getOrigin() {
		return origin;
	}
	public Square getDestination() {
		return destination;
	}
}