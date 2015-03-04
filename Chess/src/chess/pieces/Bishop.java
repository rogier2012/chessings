package chess.pieces;

import chess.*;

public class Bishop extends ChessPiece {
	
	public Bishop(Color color, int rank, int file){
		super(color,rank,file);
	}

	@Override
	public boolean isValidMove() {
		return false;
	}
	
	public String toString() {
		return "Bishop";
	}
	

}
