package chess;

import chess.pieces.*;

public class Field {
	private Color color;
	private ChessPiece piece;

	public Field(Color aColor)	{
		this.color = aColor;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public ChessPiece getPiece() {
		return piece;
	}

	public void setPiece(ChessPiece piece) {
		this.piece = piece;
	}
}
