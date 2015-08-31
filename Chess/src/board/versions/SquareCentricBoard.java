package board.versions;

import java.util.ArrayList;

import board.ChessBoard;
import board.Square;
import pieces.Bishop;
import pieces.ChessPiece;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;
import enums.Color;

public class SquareCentricBoard implements ChessBoard {
	
	/*
	 * Instance Variables
	 */
	
	private ChessPiece[][] board;

	/*
	 * Constructors
	 */
	
	public SquareCentricBoard()	{
		board = new ChessPiece[RANKS][FILES];
	}
	
	
	@Override
	public ChessPiece getChessPiece(Square position) {
		return this.board[position.getRank()][position.getFile()];
	}

	@Override
	public Square getPosition(ChessPiece piece) {
		for (int rank = 0; rank < RANKS; rank++)	{
			for (int file = 0; file < FILES; file++)	{
				ChessPiece toCheck = board[rank][file];
				if (piece.equals(toCheck))	{
					return new Square(rank, file);
				}
			}
		}
		return null;
	}

	@Override
	public boolean isOccupied(Square position) {
		return this.board[position.getRank()][position.getFile()] != null;
	}

	@Override
	public boolean isOccupiedBy(Color color, Square position) {
		return this.board[position.getRank()][position.getFile()].getColor() == color;
	}

	@Override
	public ArrayList<ChessPiece> getAllChessPiecesOf(Color color) {
		ArrayList<ChessPiece> result = new ArrayList<ChessPiece>();
		for (int rank = 0; rank < RANKS; rank++)	{
			for (int file = 0; file < FILES; file++)	{
				ChessPiece toCheck = board[rank][file];
				if (toCheck instanceof ChessPiece && toCheck.getColor() == color)	{
					result.add(toCheck);
				}
			}
		}
		return result;
	}

	@Override
	public SquareCentricBoard deepCopy() {
		SquareCentricBoard copy = new SquareCentricBoard();
		for (int rank = 0; rank < RANKS; rank++)	{
			for (int file = 0; file < FILES; file++)	{
				copy.board[rank][file] = this.board[rank][file].deepCopy();
			}
		}
		return copy;
	}

	@Override
	public void clear(Square position) {
		this.board[position.getRank()][position.getFile()] = null;
	}

	@Override
	public void setPiece(Square position, ChessPiece piece) {
		this.board[position.getRank()][position.getFile()] = piece;
	}

	@Override
	public void reset() {
		for (int rank = 0; rank < RANKS; rank++)	{					/* Clear board */
			for (int file = 0; file < FILES; file++)	{
				this.board[rank][file] = null;
			}
		}
		
		King whiteKing = new King(Color.WHITE);							/* Add a white king */
		this.board[WHITEPIECERANK][KINGFILE] = whiteKing;
		
		King blackKing = new King(Color.BLACK);							/* Add a black king */
		this.board[BLACKPIECERANK][KINGFILE] = blackKing;
		
		Queen whiteQueen = new Queen(Color.WHITE);						/* Add a white queen */
		this.board[WHITEPIECERANK][QUEENFILE] = whiteQueen;
		
		Queen blackQueen = new Queen(Color.BLACK);						/* Add a black queen */
		this.board[BLACKPIECERANK][QUEENFILE] = blackQueen;
		
		Bishop whiteLeftBishop = new Bishop(Color.WHITE);				/* Add white left bishop */
		this.board[WHITEPIECERANK][LEFTBISHOPFILE] = whiteLeftBishop;
		
		Bishop whiteRightBishop = new Bishop(Color.WHITE);				/* Add white right bishop */
		this.board[WHITEPIECERANK][RIGHTBISHOPFILE] = whiteRightBishop;
		
		Bishop blackLeftBishop = new Bishop(Color.BLACK);				/* Add black left bishop */
		this.board[BLACKPIECERANK][LEFTBISHOPFILE] = blackLeftBishop;
		
		Bishop blackRightBishop = new Bishop(Color.BLACK);				/* Add black right bishop */
		this.board[BLACKPIECERANK][RIGHTBISHOPFILE] = blackRightBishop;
		
		Knight whiteLeftKnight = new Knight(Color.WHITE);				/* Add white left knight */
		this.board[WHITEPIECERANK][LEFTKNIGHTFILE] = whiteLeftKnight;
		
		Knight whiteRightKnight = new Knight(Color.WHITE);				/* Add white right knight */
		this.board[WHITEPIECERANK][RIGHTKNIGHTFILE] = whiteRightKnight;
		
		Knight blackLeftKnight = new Knight(Color.BLACK);				/* Add black left knight */
		this.board[BLACKPIECERANK][LEFTKNIGHTFILE] = blackLeftKnight;
		
		Knight blackRightKnight = new Knight(Color.BLACK);				/* Add black right knight */
		this.board[BLACKPIECERANK][RIGHTKNIGHTFILE] = blackRightKnight;
		
		Rook whiteLeftRook = new Rook(Color.WHITE);						/* Add white left rook */
		this.board[WHITEPIECERANK][LEFTROOKFILE] = whiteLeftRook;
		
		Rook whiteRightRook = new Rook(Color.WHITE);					/* Add white right rook */
		this.board[WHITEPIECERANK][RIGHTROOKFILE] = whiteRightRook;
		
		Rook blackLeftRook = new Rook(Color.BLACK);						/* Add black left rook */
		this.board[BLACKPIECERANK][LEFTROOKFILE] = blackLeftRook;
		
		Rook blackRightRook = new Rook(Color.BLACK);					/* Add black right rook */
		this.board[BLACKPIECERANK][RIGHTROOKFILE] = blackRightRook;
		
		for (int file = 0; file < FILES; file++)	{								
			Pawn whitePawn = new Pawn(Color.WHITE);						/* Add 8 white pawns */
			this.board[WHITEPAWNRANK][file] = whitePawn;
			
			Pawn blackPawn = new Pawn(Color.BLACK);						/* Add 8 black pawns */
			this.board[BLACKPAWNRANK][file] = blackPawn;
		}

	}
	
}
