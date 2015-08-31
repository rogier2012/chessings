package pieces;

import enums.Color;

public class Queen extends ChessPiece {

	public Queen(Color color) {
		super(color);
	}
	
	@Override
	public Queen deepCopy() {
		return new Queen(this.getColor());
	}
	
}
