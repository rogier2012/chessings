package pieces;

import enums.Color;

public class Rook extends ChessPiece {

	public Rook(Color color) {
		super(color);
	}
	
	@Override
	public Rook deepCopy() {
		return new Rook(this.getColor());
	}
	
}
