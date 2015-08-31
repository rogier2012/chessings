package pieces;

import enums.Color;

public class Pawn extends ChessPiece {
	
	public Pawn(Color color) {
		super(color);
	}
	
	@Override
	public Pawn deepCopy() {
		return new Pawn(this.getColor());
	}
	
}
