package moves;

import board.Square;

public class ForwardDouble extends Move {
	
	public ForwardDouble(Square origin, Square destination)	{
		super(origin, destination);
	}
	
	@Override
	public Move deepCopy()	{
		ForwardDouble copy = new ForwardDouble(this.getOrigin().deepCopy(), this.getDestination().deepCopy());
		return copy;
	}
	
}
