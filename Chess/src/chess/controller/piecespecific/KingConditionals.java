package chess.controller.piecespecific;

import chess.controller.BoardController;
import chess.model.Board;
import chess.model.Position;
import chess.model.moves.Move;
import chess.model.pieces.King;

public class KingConditionals {
	
	public boolean canCastleLong(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardController.WHITEKING;
		//TODO
		return false;
	}
	
	public boolean canCastleShort(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardController.WHITEKING;
		//TODO
		return false;
	}
	
	
}
