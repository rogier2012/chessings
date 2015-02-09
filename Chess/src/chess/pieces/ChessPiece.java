package chess.pieces;

import chess.*;

public interface ChessPiece {
	public Field getPosition();
	
	public void setPosition();
	
	public void move();
	
	public boolean isValidMove();
}
