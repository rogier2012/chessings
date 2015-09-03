package moveoptions;

import enums.Color;

public abstract class Castling extends MoveOption {
	
	private Color color;
	
	public Castling(Color color) {
		super(color);
		this.color = color;
		this.setRepeatable(false);
		this.setRange(1);
	}
	
	@Override
	public String toString()	{
		return "" + this.getClass();
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color)	{
		this.color = color;
	}

}
