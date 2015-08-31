package pieces;

import enums.Color;

public class Bishop extends ChessPiece {

	public Bishop(Color color) {
		super(color);
	}

	@Override
	public Bishop deepCopy() {
		return new Bishop(this.getColor());
	}
	
}
