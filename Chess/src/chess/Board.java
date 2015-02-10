package chess;

import chess.pieces.*;

public class Board {

	public static final int FILES = 8;
	public static final int RANKS = 8;
	
	private Field[][] fields = new Field[RANKS][FILES];
	
	public Board() {
		this.reset();
	}
	
	public void reset(){
		// Create new fields
		Color color = Color.WHITE;
		for (int rank = 0; rank < RANKS; rank++)	{
			color = color.other();
			for (int file = 0; file < FILES; file++)	{
				fields[rank][file].setColor(color);
				color = color.other();
			}
		}
		
		// Reset white
		for (int file = 0; file < FILES; file++)	{
			fields[1][file].setPiece(new Pawn(Color.WHITE));
		}
		for (int file = 0; file < FILES; file++)	{
			if (file == 0 || file == 7)	{
				fields[0][file].setPiece(new Rook(Color.WHITE));
			}
			if (file == 1 || file == 6)	{
				fields[0][file].setPiece(new Knight(Color.WHITE));
			}
			if (file == 2 || file == 5)	{
				fields[0][file].setPiece(new Bishop(Color.WHITE));
			}
			if (file == 3)	{
				fields[0][file].setPiece(new Queen(Color.WHITE));
			}
			if (file == 4)	{
				fields[0][file].setPiece(new King(Color.WHITE));
			}
		}
		
		// Reset black
		for (int file = 0; file < FILES; file++)	{
			fields[5][file].setPiece(new Pawn(Color.BLACK));
		}
		for (int file = 0; file < FILES; file++)	{
			if (file == 0 || file == 7)	{
				fields[6][file].setPiece(new Rook(Color.BLACK));
			}
			if (file == 1 || file == 6)	{
				fields[6][file].setPiece(new Knight(Color.BLACK));
			}
			if (file == 2 || file == 5)	{
				fields[6][file].setPiece(new Bishop(Color.BLACK));
			}
			if (file == 3)	{
				fields[6][file].setPiece(new Queen(Color.BLACK));
			}
			if (file == 4)	{
				fields[6][file].setPiece(new King(Color.BLACK));
			}
		}
	}

	public boolean isValidRank(int rank)	{
		return rank >= 0 && rank < RANKS;
	}
	
	public boolean isValidFile(int file)	{
		return file >= 0 && file < FILES;
	}
	
	public Field getField(int rank, int file)	{
		return this.fields[rank][file];
	}
	
	public Field[][] getFields() {
		return fields;
	}
}
