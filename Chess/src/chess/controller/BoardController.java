package chess.controller;

import chess.model.Board;
import chess.model.Color;
import chess.model.Game;
import chess.model.Position;
import chess.model.moves.Move;
import chess.model.pieces.Bishop;
import chess.model.pieces.ChessPiece;
import chess.model.pieces.King;
import chess.model.pieces.Knight;
import chess.model.pieces.Pawn;
import chess.model.pieces.Queen;
import chess.model.pieces.Rook;
import chess.view.BoardView;

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
		this.resetWhitePawnList(board);
		this.resetBlackPawnList(board);
		this.resetFields(board);
		this.resetKingList(board);
		this.resetQueenList(board);
		this.resetBishopList(board);
		this.resetKnightList(board);
		this.resetRookList(board);
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
	
	public void resetKingList(Board board)	{
		board.getKingList().clear();
		King king = null;
		Color color = Color.WHITE;
		Position positionWhiteKing = new Position(0, 3);
		Position positionBlackKing = new Position((Board.FILES - 1), 3);
		for (int index = 0; index < Game.PLAYERAMOUNT; index++)	{
			if (color == Color.WHITE)	king = new King(color, positionWhiteKing);
			if (color == Color.BLACK)	king = new King(color, positionBlackKing);
			board.getKingList().add(king);
			color = color.other();
		}
	}
	
	public void resetQueenList(Board board)	{
		board.getQueenList().clear();
		Queen queen = null;
		Color color = Color.WHITE;
		Position positionWhiteQueen = new Position(0, 4);
		Position positionBlackQueen = new Position((Board.RANKS - 1), 4);
		for (int index = 0; index < Game.PLAYERAMOUNT; index++)	{
			if (color == Color.WHITE) queen = new Queen(color, positionWhiteQueen);
			if (color == Color.BLACK) queen = new Queen(color, positionBlackQueen);
			board.getQueenList().add(queen);
			color = color.other();
		}
	}
	
	public void resetBishopList(Board board)	{
		board.getBishopList().clear();
		board.getBishopList().add(new Bishop(Color.WHITE, new Position(0, 2)));
		board.getBishopList().add(new Bishop(Color.WHITE, new Position(0, 5)));
		board.getBishopList().add(new Bishop(Color.BLACK, new Position(Board.RANKS - 1, 2)));
		board.getBishopList().add(new Bishop(Color.BLACK, new Position(Board.RANKS - 1, 5)));
	}
	
	public void resetKnightList(Board board)	{
		board.getKnightList().clear();
		board.getKnightList().add(new Knight(Color.WHITE, new Position(0, 1)));
		board.getKnightList().add(new Knight(Color.WHITE, new Position(0, 6)));
		board.getKnightList().add(new Knight(Color.BLACK, new Position(Board.RANKS - 1, 1)));
		board.getKnightList().add(new Knight(Color.BLACK, new Position(Board.RANKS - 1, 6)));
	}
	
	public void resetRookList(Board board)	{
		board.getRookList().clear();
		board.getRookList().add(new Rook(Color.WHITE, new Position(0, 0)));
		board.getRookList().add(new Rook(Color.WHITE, new Position(0, 7)));
		board.getRookList().add(new Rook(Color.BLACK, new Position(Board.RANKS - 1, 0)));
		board.getRookList().add(new Rook(Color.BLACK, new Position(Board.RANKS - 1, 7)));
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
		board.setPiece(WHITEPIECERANK, file, WHITEKING);
		file++;
		board.setPiece(WHITEPIECERANK, file, WHITEQUEEN);
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
	
	public void setPawnInList(Pawn pawn, Board board)	{
		boolean isWhite = pawn.getColor() == Color.WHITE;
		boolean isBlack = pawn.getColor() == Color.BLACK;
		
		if (isWhite)	{
			board.getWhitePawnList().add(pawn);
		} else if (isBlack)	{
			board.getBlackPawnList().add(pawn);
		}
	}
	
	/**
	 * Executes a move in board. Even if it is invalid.
	 */
	public void executeMove(Move move, Board board)	{
		byte bPiece = board.getPiece(move.getInitial());
		board.setPiece(move.getEnd(), bPiece);
		board.setPiece(move.getInitial(), (byte) 0);;
		ChessPiece piece = board.getChessPiece(bPiece, move.getInitial());
		piece.setPosition(move.getEnd());
	}
}
