package moveoptions;

import moves.CastleShort;
import moves.Move;
import moves.MoveSuggestion;
import pieces.ChessPiece;
import pieces.Rook;
import board.ChessBoard;
import board.Square;
import enums.Color;
import game.Game;

public class CastlingShort extends Castling {
	
	/*
	 * Constructors
	 */
	
	public CastlingShort(Color color)	{
		super(color);
		this.setColor(color);
		this.setDirection(new int[] { 0, -2 });
	}
	
	/*
	 * Queries
	 */
	
	@Override
	public boolean specificRequirementsAreMet(Game game, MoveSuggestion suggestion)	{ // TODO -- Rook positions hardcoded
		boolean result = true;
		// Space between King and Rook is clear
		if (this.getColor() == Color.WHITE){
			result = result && !game.getBoard().isOccupied(new Square(ChessBoard.WHITEPIECERANK, 1));
			result = result && !game.getBoard().isOccupied(new Square(ChessBoard.WHITEPIECERANK, 2));
			if (result)	{
				ChessPiece rook = game.getBoard().getChessPiece(new Square(0, 0));
				result = result && rook instanceof Rook;
				result = result && rook.getColor() == Color.WHITE;
			}
			
		} else if (this.getColor() == Color.BLACK)	{
			result = result && !game.getBoard().isOccupied(new Square(ChessBoard.BLACKPIECERANK, 1));
			result = result && !game.getBoard().isOccupied(new Square(ChessBoard.BLACKPIECERANK, 2));
			
			if (result)	{
				ChessPiece rook = game.getBoard().getChessPiece(new Square(7, 0));
				result = result && rook instanceof Rook;
				result = result && rook.getColor() == Color.BLACK;
			}
		}
		return result;
	}
	
	@Override
	public Move generateMove(MoveSuggestion suggestion) {
		CastleShort result = new CastleShort(suggestion.getOrigin(), suggestion.getDestination());
		return result;
	}
	
	
}
