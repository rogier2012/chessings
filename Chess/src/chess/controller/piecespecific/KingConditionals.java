package chess.controller.piecespecific;

import chess.model.*;
import chess.Position;
import chess.controller.*;

public class KingConditionals {
	
	public boolean canCastleLong(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardControllerMethods.WHITEPAWN;
		//TODO
		return false;
	}
	
	public boolean canCastleShort(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardControllerMethods.WHITEPAWN;
		//TODO
		return false;
	}
	
	
}
