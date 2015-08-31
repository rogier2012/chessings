package moveoptions;

import enums.Color;

public abstract class Castling extends MoveOption {
	
	public Color color;
	
	public Castling(Color color) {
		super(color);
		this.color = color;
		this.setRepeatable(false);
		this.setRange(1);
	}
	
	public Color getColor() {
		return color;
	}

}
