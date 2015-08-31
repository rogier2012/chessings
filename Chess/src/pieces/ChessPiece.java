package pieces;

import enums.Color;

public abstract class ChessPiece {
	
	private Color color;
	
	public ChessPiece(Color color)	{
		this.color = color;
	}
	
	public abstract ChessPiece deepCopy();
	
	public Color getColor()	{
		return this.color;
	}
	
}
