package view;

import pieces.Bishop;
import pieces.ChessPiece;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;
import board.ChessBoard;
import board.Square;
import enums.Color;

public class TUI implements View {
	
	/*
	 * Constants
	 */
	
	private static final String VERTICALBORDER = "|";
	private static final String HORIZONTALBORDER = "-";
	private static final String SPACE = "  ";
	private static final String CROSSING = "+";
	
	/*
	 * Instance Variables
	 */
	
	private ChessBoard board;
	
	/*
	 * Constructors
	 */
	
	public TUI(ChessBoard board){
		this.board = board;
	}
	
	/*
	 * Methods
	 */
	
	@Override
	public void display(String message) {
		System.out.println(message);
	}

	@Override
	public void showBoard(Color color) {
		System.out.println(this.boardRepresentation());
	}
	
	private String boardRepresentation()	{
		String result = "";
		for (int rank = 0; rank < ChessBoard.RANKS; rank++)	{
			result += TUI.getEmptyRow();
			result += "\n";
			
			String pieceRow = ChessBoard.RANKS - rank + SPACE + VERTICALBORDER;
			for (int file = 0; file < ChessBoard.FILES; file++)	{
				Square square = new Square(rank, file);
				ChessPiece piece = board.getChessPiece(square);
				String color = SPACE;
				
				if (piece instanceof ChessPiece)	{
					color = TUI.colorRepresentation(piece.getColor());
				}
				
				pieceRow += SPACE + color + TUI.pieceRepresentation(piece) + SPACE + VERTICALBORDER;
				
			}
			result += pieceRow;
			result += "\n";
			
			result += TUI.getEmptyRow();
			result += "\n";
			
		}
		
		
		
		return result;
	}
	
	private static String getEmptyRow()	{
		String result = " " + SPACE + VERTICALBORDER;
		
		for (int file = 0; file < ChessBoard.FILES; file++)	{
			result += SPACE + SPACE + TUI.pieceRepresentation(null) + SPACE + VERTICALBORDER;
		}
		
		return result;
	}
	
	private static String getHorizontalBorder()	{ // TODO
		String result = HORIZONTALBORDER + HORIZONTALBORDER + HORIZONTALBORDER + CROSSING;
		
		
		
		
		return result;
	}
	
	private static String pieceRepresentation(ChessPiece piece)	{
		String result = SPACE + SPACE + SPACE;
		if (piece instanceof Pawn)	{
			result = "Pawn  ";
		} else if (piece instanceof King)	{
			result = "King  ";
		} else if (piece instanceof Queen)	{
			result = "Queen ";
		} else if (piece instanceof Bishop)	{
			result = "Bishop";
		} else if (piece instanceof Knight)	{
			result = "Knight";
		} else if (piece instanceof Rook)	{
			result = "Rook  ";
		}
		return result;
	}
	
	private static String colorRepresentation(Color color)	{
		return (color == Color.WHITE)? "W ":"B ";
	}

}
