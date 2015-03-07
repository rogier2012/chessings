package chess.boards;

import chess.Position;

public class BoardMethods {
	
	/*
	 * Piece byte values
	 * 
	 * 00000000 -  0 - EMPTY - EMPTY
	 * 00000001 -  1 - WHITE - PAWN
	 * 00000010 -  2 - BLACK - PAWN
	 * 00000011 -  3 - WHITE - KING
	 * 00000100 -  4 - BLACK - KING
	 * 00000101 -  5 - WHITE - QUEEN
	 * 00000110 -  6 - BLACK - QUEEN
	 * 00000111 -  7 - WHITE - BISHOP
	 * 00001000 -  8 - BLACK - BISHOP
	 * 00001001 -  9 - WHITE - KNIGHT
	 * 00001010 - 10 - BLACK - KNIGHT
	 * 00001011 - 11 - WHITE - ROOK
	 * 00001100 - 12 - BLACK - ROOK
	 */
	
	public static final byte EMPTY = 0;
	public static final byte WHITEPAWN = 1;
	public static final byte BLACKPAWN = 2;
	public static final byte WHITEKING = 3;
	public static final byte BLACKKING = 4;
	public static final byte WHITEQUEEN = 5;
	public static final byte BLACKQUEEN = 6;
	public static final byte WHITEBISHOP = 7;
	public static final byte BLACKBISHOP = 8;
	public static final byte WHITEKNIGHT = 9;
	public static final byte BLACKKNIGHT = 10;
	public static final byte WHITEROOK = 11;
	public static final byte BLACKROOK = 12;
	
	public static final int WHITEPIECERANK = 0;
	public static final int WHITEPAWNRANK = WHITEPIECERANK + 1;
	
	public static final int BLACKPIECERANK = Board.RANKS - 1;
	public static final int BLACKPAWNRANK = BLACKPIECERANK - 1;
	
	public static final String LINE = "---+----------+----------+----------+----------+----------+----------+----------+----------";

	private static final String NUMBERINGFILES = "        A     |    B     |    C     |    D     |    E     |     F    |     G    |     H  "
			+ "" + "\n" + "\n";

	private static final String NUMBERINGRANKS = "  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  "
			+ "" + "\n" + "\n";
	
	public void resetWhitePawnList(Board board)	{
		
	}
	
	public void resetBlackPawnList(Board board)	{
		
	}
	
	public static void resetFields(Board board)	{
		int file;
		// Reset white fields
		
		// * White Pawns
		for (file = 0; file < Board.FILES; file++)	{
			board.setPiece(WHITEPAWNRANK, file, WHITEPAWN);
		}
		
		// * White Pieces
		file = 0;
		board.setPiece(WHITEPIECERANK, file, WHITEROOK);
		file++;
		board.setPiece(WHITEPIECERANK, file, WHITEKNIGHT);
		file++;
		board.setPiece(WHITEPIECERANK, file, WHITEBISHOP);
		file++;
		board.setPiece(WHITEPIECERANK, file, WHITEQUEEN);
		file++;
		board.setPiece(WHITEPIECERANK, file, WHITEKING);
		file++;
		board.setPiece(WHITEPIECERANK, file, WHITEBISHOP);
		file++;
		board.setPiece(WHITEPIECERANK, file, WHITEKNIGHT);
		file++;
		board.setPiece(WHITEPIECERANK, file, WHITEROOK);
		
		// Reset black fields
		
		// * Black Pawns
		for (file = 0; file < Board.FILES; file++)	{
			board.setPiece(BLACKPAWNRANK, file, BLACKPAWN);
		}
		
		// * Black Pieces
		file = 0;
		board.setPiece(BLACKPIECERANK, file, BLACKROOK);
		file++;
		board.setPiece(BLACKPIECERANK, file, BLACKKNIGHT);
		file++;
		board.setPiece(BLACKPIECERANK, file, BLACKBISHOP);
		file++;
		board.setPiece(BLACKPIECERANK, file, BLACKKING);
		file++;
		board.setPiece(BLACKPIECERANK, file, BLACKQUEEN);
		file++;
		board.setPiece(BLACKPIECERANK, file, BLACKBISHOP);
		file++;
		board.setPiece(BLACKPIECERANK, file, BLACKKNIGHT);
		file++;
		board.setPiece(BLACKPIECERANK, file, BLACKROOK);
		
		// Reset middle
		for (int rank = WHITEPAWNRANK + 1; rank < BLACKPAWNRANK; rank++)	{
			for (file = 0; file < Board.FILES; file++)	{
				board.setPiece(rank, file, EMPTY);
			}
		}
	}
	
	
	public static String test(chess.boards.Board board)	{
		int rowCounter = 8;
		boolean insertRowCounter;

		String s = "";

		for (int rank = 0; rank < Board.RANKS; rank++) {
			String row = "";
			insertRowCounter = true;
			for (int file = 0; file < Board.FILES; file++) {
				if (board.getPiece(rank ,file) == 0) {
					if (insertRowCounter) {
						row = rowCounter-- + row + "  |          ";
						insertRowCounter = false;
					} else {
						row = row + "|          ";
					}
				} else {
					if (insertRowCounter) {
						row = rowCounter-- + "  " + row
								+ "|" + byteToString(board.getPiece(rank ,file));
						insertRowCounter = false;
					} else {
						row = row + "|"
								+ byteToString(board.getPiece(rank ,file));
					}
				}
			}
			s += row + "\n" + "\n" + LINE + "\n" + "\n";
		}
		s = NUMBERINGFILES + s;
		return s;
	}
	
	public static String byteToString(byte piece)	{
		String res = "";
		if (piece == EMPTY)	{
			res = "		";
		} else if(piece == WHITEPAWN)	{
			res = "  W PAWN  ";
		} else if(piece == BLACKPAWN)	{
			res = "  B PAWN  ";
		} else if(piece == WHITEKING)	{	
			res = "  W KING  ";
		} else if(piece == BLACKKING)	{	
			res = "  B KING  ";
		} else if(piece == WHITEQUEEN)	{	
			res = "  W QUEEN ";
		} else if(piece == BLACKQUEEN)	{	
			res = "  B QUEEN ";
		} else if(piece == WHITEBISHOP)	{	
			res = " W BISHOP ";
		} else if(piece == BLACKBISHOP)	{
			res = " B BISHOP ";
		} else if(piece == WHITEKNIGHT)	{
			res = " W KNIGHT ";
		} else if(piece == BLACKKNIGHT)	{	
			res = " B KNIGHT ";
		} else if(piece == WHITEROOK)	{	
			res = "  W ROOK  ";
		} else if(piece == BLACKROOK)	{	
			res = "  B ROOK  ";
		} else {
			System.out.println("I'm trying to print an invalid piece byte representation!");
		}
		return res;
	}
	
	public static boolean isValidRank(int rank) {
		return rank >= 0 && rank < Board.RANKS;
	}

	public static boolean isValidFile(int file) {
		return file >= 0 && file < Board.FILES;
	}

	public static boolean isWithinBoard(int rank, int file) {
		return isValidRank(rank) && isValidFile(file);
	}

	public static boolean isWithinBoard(Position position) {
		return isValidRank(position.getRank())
				&& isValidFile(position.getFile());
	}
}
