package chess.controller.piecespecific;

import chess.controller.BoardControllerMethods;
import chess.model.*;
import chess.view.*;

public class PawnConditionals {
	
	public boolean canMoveOneForward(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardControllerMethods.WHITEPAWN;
		//TODO 
		return false;
	}
	
	public boolean canMoveTwoForward(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardControllerMethods.WHITEPAWN;
		//TODO
		return false;
	}
	
	public boolean canCaptureRight(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardControllerMethods.WHITEPAWN;
		// For the right and left side we assume white's POV
		//TODO
		return false;
	}
	
	public boolean canCaptureLeft(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardControllerMethods.WHITEPAWN;
		// For the right and left side we assume white's POV
		//TODO
		return false;
	}
	
	public boolean canEnPassantRight(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardControllerMethods.WHITEPAWN;
		// For the right and left side we assume white's POV
		//TODO
		return false;
	}
	
	public boolean canEnPassantLeft(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardControllerMethods.WHITEPAWN;
		// For the right and left side we assume white's POV
		//TODO
		return false;
	}
	
	
}
