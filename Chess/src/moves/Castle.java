package moves;

import board.ChessBoard;
import board.Square;

public abstract class Castle extends Move {
	
	/*
	 * Instance Variables
	 */
	
	private Move rookMove;
	
	/*
	 * Constructors
	 */
	
	public Castle(Square initialPoint, Square endPoint) {
		super(initialPoint, endPoint);
	}
	
	/*
	 * Queries
	 */
	
	@Override
	public Move deepCopy()	{
		CastleLong copy = new CastleLong(this.getOrigin().deepCopy(), this.getDestination().deepCopy());
		copy.setRookMove(this.getRookMove().deepCopy());
		return copy;
	}
	
	/*
	 * Commands
	 */
	
	@Override
	public void executeOn(ChessBoard board)	{
		board.setPiece(this.getDestination(), board.getChessPiece(this.getOrigin()));
		board.clear(this.getOrigin());
		this.rookMove.executeOn(board);
	}
	
	/*
	 * Getters and Setters
	 */
	
	public Move getRookMove() {
		return rookMove;
	}

	public void setRookMove(Move rookMove) {
		this.rookMove = rookMove;
	}

	
}
