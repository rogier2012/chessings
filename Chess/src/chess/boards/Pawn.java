package chess.boards;

import chess.Color;
import chess.Position;

public class Pawn extends ChessPiece{
	
	public Pawn(Color color, int rank, int file)	{
		super(color, rank, file);
	}
	
	
	@Override
	public Position getPosition() {
		// TODO Auto-generated method stub
		return super.getPosition();
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		super.setColor(color);
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return super.getColor();
	}

	@Override
	public void setPosition(int rank, int file) {
		// TODO Auto-generated method stub
		super.setPosition(rank, file);
	}

	@Override
	public boolean isValidMove() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
