package moves;

import board.Square;

public class CastleShort extends Castle {

	public CastleShort(Square initialPoint, Square endPoint) {
		super(initialPoint, endPoint);
		// Determine Rook's move
		Square pos1 = new Square(endPoint.getRank(), endPoint.getFile() - 1); // Original place of the rook
		Square pos2 = new Square(initialPoint.getRank(), initialPoint.getFile() - 1); // End point of the rook
		Move rookMove = new Move(pos1, pos2);
		this.setRookMove(rookMove);
	}
	
	@Override
	public CastleShort deepCopy()	{
		CastleShort copy = new CastleShort(this.getOrigin().deepCopy(), this.getDestination().deepCopy());
		return copy;
	}
	
}
