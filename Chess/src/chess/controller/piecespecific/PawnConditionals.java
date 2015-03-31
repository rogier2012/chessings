package chess.controller.piecespecific;

import chess.controller.BoardController;
import chess.controller.PositionController;
import chess.model.*;
import chess.view.*;

public class PawnConditionals {
	
	public boolean canMoveOneForward(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardController.WHITEPAWN;
		boolean result = false;
		
		// Pawn is white
		if (isWhite) {
			if (position.getRank() + 1 < board.RANKS && position.getFile() < board.FILES){
				Position newPos = new Position(position.getRank() + 1, position.getFile());
				if (board.getPiece(newPos) == 0) {
					result = true;
				}
			}
				
		} 
		
		// Pawn is black
		else {
			if (position.getRank() - 1 >= 0 && position.getFile() < board.FILES){
				Position newPos = new Position(position.getRank() - 1, position.getFile());
				if (board.getPiece(newPos) == 0) {
					result = true;
				}
			}
		}
		return result;
	}
	
	public boolean canMoveTwoForward(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardController.WHITEPAWN;
		boolean result = false;
		if (canMoveOneForward(position, board)) {
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
		}
		return false;
	}
	
	public boolean canCaptureRight(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardController.WHITEPAWN;
		boolean result = false;
		// For the right and left side we assume white's POV
		
		if (isWhite) {
			if (position.getRank() + 1 < board.RANKS && position.getFile() + 1 < board.FILES) {
				Position newPos = new Position(position.getFile() + 1, position.getRank() + 1);
//				if (board.getPiece(newPos)) {
					
//				}
			}
		} else {
			
		}
		
		
		
		
		
		return result;
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
