package board.versions;

import java.util.ArrayList;

import board.ChessBoard;
import board.Square;
import pieces.ChessPiece;
import pieces.King;
import enums.Color;

public class StandardBoard implements ChessBoard {
	
	@Override
	public ChessPiece getChessPiece(Square position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Square getPosition(ChessPiece piece) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isOccupied(Square position) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOccupiedBy(Color color, Square position) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<ChessPiece> getAllChessPiecesOf(Color color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChessBoard deepCopy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear(Square position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPiece(Square position, ChessPiece piece) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public King getKing(Color color) {
		// TODO Auto-generated method stub
		return null;
	}

}
