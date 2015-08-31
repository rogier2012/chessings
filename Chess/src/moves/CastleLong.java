
package moves;

import board.Square;

public class CastleLong extends Castle {
	
	public CastleLong(Square initialPoint, Square endPoint) {
		super(initialPoint, endPoint);
		// Determine Rook's move
		Square pos1 = new Square(endPoint.getRank(), endPoint.getFile() + 1); // Original place of the rook
		Square pos2 = new Square(initialPoint.getRank(), initialPoint.getFile() + 2); // End point of the rook
		Move rookMove = new Move(pos1, pos2);
		this.setRookMove(rookMove);
	}
	
	@Override
	public CastleLong deepCopy()	{
		CastleLong copy = new CastleLong(this.getOrigin().deepCopy(), this.getDestination().deepCopy());
		return copy;
	}
	
}
