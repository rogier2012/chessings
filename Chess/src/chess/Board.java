package chess;

import chess.pieces.*;
import java.util.Set;
import java.util.HashSet;


public class Board {

	/*
	 * Constants
	 */
	
	public static final int FILES = 8;
	public static final int RANKS = 8;

	
	/*
	 * Instance variables
	 */
	
	private Field[][] fields = new Field[RANKS][FILES];

	private Set<Pawn> whitePawnSet = new HashSet<Pawn>();
	private Set<Pawn> blackPawnSet = new HashSet<Pawn>();

	public Board() {

		// Create new fields
		Color color = Color.WHITE;
		for (int rank = 0; rank < RANKS; rank++) {
			color = color.other();
			for (int file = 0; file < FILES; file++) {
				fields[rank][file].setColor(color);
				color = color.other();
			}
		}

		
		// Create Pieces

		this.reset();
	}

	
	public void reset(){
		
		/**
		 * Clear sets
		 */
		
		// Clear pawnSets
		whitePawnSet.clear();
		blackPawnSet.clear();

		// Reset white

		for (int file = 0; file < FILES; file++)	{
			Pawn pawn = new Pawn(Color.WHITE, 1, file);
			fields[1][file].setPiece(pawn);
			whitePawnSet.add(pawn);
		}
		
		for (int file = 0; file < FILES; file++) {
			if (file == 0 || file == 7) {
				fields[0][file].setPiece(new Rook(Color.WHITE, 0, file));
			}
			if (file == 1 || file == 6) {
				fields[0][file].setPiece(new Knight(Color.WHITE, 0, file));
			}
			if (file == 2 || file == 5) {
				fields[0][file].setPiece(new Bishop(Color.WHITE, 0, file));
			}
			if (file == 3) {
				fields[0][file].setPiece(new Queen(Color.WHITE, 0, file));
			}
			if (file == 4) {
				fields[0][file].setPiece(new King(Color.WHITE, 0, file));
			}
		}

		// Clear middle
		for (int rank = 2; rank < RANKS - 2; rank++) {
			for (int file = 0; rank < FILES; file++) {
				fields[rank][file].setPiece(null);
			}
		}

		// Reset black
		for (int file = 0; file < FILES; file++)	{
			Pawn pawn = new Pawn(Color.BLACK, RANKS - 2, file);
			fields[RANKS - 2][file].setPiece(pawn);
			blackPawnSet.add(pawn);
		}
		for (int file = 0; file < FILES; file++) {
			if (file == 0 || file == 7) {
				fields[RANKS - 1][file].setPiece(new Rook(Color.BLACK,
						RANKS - 1, file));
			}
			if (file == 1 || file == 6) {
				fields[RANKS - 1][file].setPiece(new Knight(Color.BLACK,
						RANKS - 1, file));
			}
			if (file == 2 || file == 5) {
				fields[RANKS - 1][file].setPiece(new Bishop(Color.BLACK,
						RANKS - 1, file));
			}
			if (file == 3) {
				fields[RANKS - 1][file].setPiece(new Queen(Color.BLACK,
						RANKS - 1, file));
			}
			if (file == 4) {
				fields[RANKS - 1][file].setPiece(new King(Color.BLACK,
						RANKS - 1, file));
			}
		}
	}
	
	public void printBoard() {
		System.out.println("");

	}

	public boolean isValidRank(int rank) {
		return rank >= 0 && rank < RANKS;
	}

	public boolean isValidFile(int file) {
		return file >= 0 && file < FILES;
	}

	public boolean isWithinBoard(int rank, int file) {
		return isValidRank(rank) && isValidFile(file);
	}

	public Field getField(int rank, int file) {
		return this.fields[rank][file];
	}

	public Field[][] getFields() {
		return fields;
	}
}
