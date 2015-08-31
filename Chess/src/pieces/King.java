package pieces;

import enums.Color;

public class King extends ChessPiece {

	public King(Color color) {
		super(color);
	}
	
	@Override
	public King deepCopy() {
		return new King(this.getColor());
	}
	
}
