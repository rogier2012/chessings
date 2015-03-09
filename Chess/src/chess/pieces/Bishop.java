package chess.pieces;

import chess.*;
import chess.boards.*;
import chess.pieces.*;

public class Bishop extends ChessPiece {
	
	public Bishop(Color color, int rank, int file){
		super(color,rank,file);
	}

	@Override
	public boolean isValidMove(Move move) {
		return false;
	}
	
	public String toString() {
		return "Bishop ";
	}
	

}
