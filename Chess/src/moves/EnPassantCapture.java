package moves;

import board.ChessBoard;
import board.Square;
import enums.Horizontal;

public class EnPassantCapture extends Move {
	
	/*
	 * Constructors
	 */
	
	public EnPassantCapture(Square origin, Square destination)	{
		super(origin, destination);
	}
	
	/*
	 * Queries
	 */
	
	public Horizontal getDirection()	{ // TODO check if this method is necessary
		int fileDifference = this.getOrigin().getFile() - this.getDestination().getFile();
		return (fileDifference == -1)? Horizontal.RIGHT:Horizontal.LEFT;
	}
	
	@Override
	public Move deepCopy()	{
		EnPassantCapture copy = new EnPassantCapture(this.getOrigin().deepCopy(), this.getDestination().deepCopy());
		return copy;
	}
	
	/*
	 * Commands
	 */
	
	@Override
	public void executeOn(ChessBoard board)	{
		board.setPiece(this.getDestination(), board.getChessPiece(this.getOrigin()));
		board.clear(this.getOrigin());
		board.clear(this.getTarget());
	}
	
	/*
	 * Help methods
	 */
	
	/**
	 * @return Position of piece that is to be captured
	 */
	private Square getTarget()	{
		return new Square(this.getOrigin().getRank(), this.getOrigin().getFile() + this.getDirection().value());
	}
	
	
}
