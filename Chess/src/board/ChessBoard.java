package board;

import java.util.ArrayList;

import pieces.ChessPiece;
import enums.Color;

public interface ChessBoard {
	
	/*
	 * Constants
	 */
	
	public static final int FILES = 8;
	public static final int RANKS = 8;
	
	public static final int WHITEPIECERANK = 0;
	public static final int WHITEPAWNRANK = WHITEPIECERANK + 1;
	
	public static final int BLACKPIECERANK = ChessBoard.RANKS - 1;
	public static final int BLACKPAWNRANK = BLACKPIECERANK - 1;
	
	public static final int KINGFILE = 3;
	public static final int QUEENFILE = 4;
	public static final int LEFTBISHOPFILE = 2;
	public static final int RIGHTBISHOPFILE = 5;
	public static final int LEFTKNIGHTFILE = 1;
	public static final int RIGHTKNIGHTFILE = 6;
	public static final int LEFTROOKFILE = 0;
	public static final int RIGHTROOKFILE = 7;
	
	/*
	 * Static Methods
	 */
	
	public static boolean isValidRank(int rank) {
		return rank >= 0 && rank < ChessBoard.RANKS;
	}

	public static boolean isValidFile(int file) {
		return file >= 0 && file < ChessBoard.FILES;
	}

	public static boolean isWithinBoard(int rank, int file) {
		return isValidRank(rank) && isValidFile(file);
	}

	public static boolean isWithinBoard(Square position) {
		return isValidRank(position.getRank())
				&& isValidFile(position.getFile());
	}
	
	/*
	 * Queries
	 */
	
	public ChessPiece getChessPiece(Square position);
	
	public Square getPosition(ChessPiece piece);
	
	public boolean isOccupied(Square position);
	
	public boolean isOccupiedBy(Color color, Square position);
	
	public ArrayList<ChessPiece> getAllChessPiecesOf(Color color);
	
	public ChessBoard deepCopy();
	
	/*
	 * Commands
	 */
	
	public void clear(Square position);
	
	public void setPiece(Square position, ChessPiece piece);
	
	public void reset();
	
}
