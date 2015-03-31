package chess.controller.piecespecific;

import chess.controller.BoardController;
import chess.controller.PositionController;
import chess.model.*;
import chess.view.*;

public class PawnConditionals {
	
	public boolean canMoveOneForward(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardController.WHITEPAWN;
		//TODO 
		return false;
	}
	
	public boolean canMoveTwoForward(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardController.WHITEPAWN;
		boolean result = false;
		
		if (isWhite) {
			Position newPosition = new Position(position.getRank() + 2, position.getFile());
			if (PositionController.isWithinRange(newPosition)) {
				if (board.getPiece(newPosition) == 0) {
					result = true;
				}
			}
		} else {
			Position newPosition = new Position(position.getRank() - 2, position.getFile());
			if (PositionController.isWithinRange(newPosition)) {
				if (board.getPiece(newPosition) == 0) {
					result = true;
				}
			}
		}
		return false;
	}
	
	public boolean canCaptureRight(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardController.WHITEPAWN;
		// For the right and left side we assume white's POV
		//TODO
		return false;
	}
	
	public boolean canCaptureLeft(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardController.WHITEPAWN;
		// For the right and left side we assume white's POV
		//TODO
		return false;
	}
	
	public boolean canEnPassantRight(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardController.WHITEPAWN;
		// For the right and left side we assume white's POV
		//TODO
		return false;
	}
	
	public boolean canEnPassantLeft(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardController.WHITEPAWN;
		// For the right and left side we assume white's POV
		//TODO
		return false;
	}
	
	
}
