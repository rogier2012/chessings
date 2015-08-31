package moveoptions;

import moves.CastleLong;
import moves.Move;
import moves.MoveSuggestion;
import pieces.ChessPiece;
import pieces.Rook;
import board.ChessBoard;
import board.Square;
import enums.Color;
import game.Game;

public class CastlingLong extends Castling {
	
	/*
	 * Constructors
	 */
	
	public CastlingLong(Color color)	{
		super(color);
		this.setColor(color);
		this.setDirection(new int[] { 0, 3 });
	}
	
	/*
	 * Queries
	 */
	
	@Override
	public boolean specificRequirementsAreMet(Game game, MoveSuggestion suggestion)	{
		boolean result = true;
		// Space between King and Rook is clear
		if (this.getColor() == Color.WHITE){
			result = result && !game.getBoard().isOccupied(new Square(ChessBoard.WHITEPIECERANK, ChessBoard.QUEENFILE));
			result = result && !game.getBoard().isOccupied(new Square(ChessBoard.WHITEPIECERANK, ChessBoard.RIGHTBISHOPFILE));
			result = result && !game.getBoard().isOccupied(new Square(ChessBoard.WHITEPIECERANK, ChessBoard.RIGHTKNIGHTFILE));
			if (result)	{
				ChessPiece rook = game.getBoard().getChessPiece(new Square(ChessBoard.WHITEPIECERANK, ChessBoard.RIGHTROOKFILE));
				result = result && rook instanceof Rook;
				result = result && rook.getColor() == Color.WHITE;
			}
			
		} else if (this.getColor() == Color.BLACK)	{
			result = result && !game.getBoard().isOccupied(new Square(ChessBoard.BLACKPIECERANK, ChessBoard.QUEENFILE));
			result = result && !game.getBoard().isOccupied(new Square(ChessBoard.BLACKPIECERANK, ChessBoard.RIGHTBISHOPFILE));
			result = result && !game.getBoard().isOccupied(new Square(ChessBoard.BLACKPIECERANK, ChessBoard.RIGHTKNIGHTFILE));
			if (result)	{
				ChessPiece rook = game.getBoard().getChessPiece(new Square(ChessBoard.BLACKPIECERANK, ChessBoard.RIGHTROOKFILE));
				result = result && rook instanceof Rook;
				result = result && rook.getColor() == Color.BLACK;
			}
			
		}
		return result;
	}
	
	@Override
	public Move generateMove(MoveSuggestion suggestion) {
		return new CastleLong(suggestion.getOrigin(), suggestion.getDestination());
	}
	
	
}
