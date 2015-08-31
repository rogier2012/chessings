package pieces;

import enums.Color;

public class Knight extends ChessPiece {

	public Knight(Color color) {
		super(color);
	}

	@Override
	public Knight deepCopy() {
		return new Knight(this.getColor());
	}
	
}
