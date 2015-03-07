package chess.boards;

import chess.Color;
import chess.Position;

public class Pawn extends ChessPiece{
	
	public Pawn(Color color, int rank, int file)	{
		super(color, rank, file);
	}

	@Override
	public boolean isValidMove() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
