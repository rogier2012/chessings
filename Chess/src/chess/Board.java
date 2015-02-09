package chess;

import chess.pieces.*;

public class Board {
	private ChessPiece fields[][];
	
	public Board() {
		fields = new ChessPiece[8][8];
		
	}
	
	public void reset(){
		fields[0][0] = new Pawn();
	}
}
