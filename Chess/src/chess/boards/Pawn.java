package chess.boards;

import chess.*;
import chess.Position;

public class Pawn extends ChessPiece{
	
	private boolean isFirstMove;
	private boolean isSecondMove;
	
	public Pawn(Color color, int rank, int file)	{
		super(color, rank, file);
		isFirstMove = true;
		isSecondMove = false;
	}
	
	public boolean isFirstMove()	{
		return this.isFirstMove;
	}
	
}
