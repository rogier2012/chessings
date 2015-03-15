package chess.controller.piecespecific;

import chess.model.*;
import chess.controller.*;

public class KingConditionals {
	
	public boolean canCastleLong(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardController.WHITEPAWN;
		//TODO
		return false;
	}
	
	public boolean canCastleShort(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardController.WHITEPAWN;
		//TODO
		return false;
	}
	
	
}
