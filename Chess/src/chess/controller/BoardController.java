package chess.controller;

import chess.model.Board;
import chess.model.Color;
import chess.model.Position;
import chess.model.pieces.*;
import chess.model.moves.*;

public class BoardController {
	
	/*
	 * Piece byte values
	 * 
	 * Binary   -  N - Color - Piece
	 * 
	 * 00000000 -  0 - N/A   - EMPTY
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
	
	public void reset(Board board)	{
		resetWhitePawnList(board);
		resetBlackPawnList(board);
		resetFields(board);
	}
	
	public void resetWhitePawnList(Board board)	{
		board.getWhitePawnList().clear();
		Pawn pawn;
		for (int file = 0; file < Board.FILES; file++)	{
			pawn = new Pawn(Color.WHITE, new Position(WHITEPAWNRANK, file));
			setPawnInList(pawn, board);
		}
	}
	
	public void resetBlackPawnList(Board board)	{
		board.getBlackPawnList().clear();
		Pawn pawn;
		for (int file = 0; file < Board.FILES; file++)	{
			pawn = new Pawn(Color.BLACK, new Position(BLACKPAWNRANK, file));
			setPawnInList(pawn, board);
		}
	}
	
	public void resetFields(Board board)	{
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
	
	public boolean isOccupied(Position position, Board board)	{
		return board.getPiece(position) != EMPTY;
	}
	
	public void setPawnInList(Pawn pawn, Board board)	{
		boolean isWhite = pawn.getColor() == Color.WHITE;
		boolean isBlack = pawn.getColor() == Color.BLACK;
		
		if (isWhite)	{
			board.getWhitePawnList().add(pawn);
		} else if (isBlack)	{
			board.getWhitePawnList().add(pawn);
		}
	}
	
	/*
	 * Executes a move in board. Even if it is invalid.
	 */
	public void executeMove(Move move, Board board)	{
		executeMoveInFields(move.getInitial(), move.getEnd(), board);
		executeMoveInSets(move.getInitial(), move.getEnd(), board);
	}
	
	
	/*
	 * Executes a move in the fields matrix in board. Even if it is invalid.
	 * IMPORTANT: EXECUTE THIS AFTER CHANGING THE SETS
	 */
	public void executeMoveInFields(Position oldPosition, Position newPosition, Board board)	{
		byte piece = board.getPiece(oldPosition);
		board.setPiece(newPosition.getRank(), newPosition.getFile(), piece);
	}
	
	/*
	 * Executes a move in the set representation of board. Even if it is invalid.
	 * IMPORTANT: EXECUTE THIS BEFORE CHANGING FIELDS
	 */
	public void executeMoveInSets(Position oldPosition, Position newPosition, Board board)	{
		//TODO
	}
	
}
