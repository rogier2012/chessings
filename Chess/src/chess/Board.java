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
	public static final String LINE = "\n---+----------+----------+----------+----------+----------+----------+----------+----------";

	private static final String NUMBERINGFILES = "        A     |    B     |    C     |    D     |    E     |     F    |     G    |     H  "
			+ "" + "\n" + "\n";

	private static final String NUMBERINGRANKS = "  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  "
			+ "" + "\n" + "\n";
	/*
	 * Instance variables
	 */

	private Field[][] fields;
	private Set<Pawn> whitePawnSet = new HashSet<Pawn>();
	private Set<Pawn> blackPawnSet = new HashSet<Pawn>();

	public Board() {
		fields = new Field[RANKS][FILES];
		// Create new fields
		Color color = Color.WHITE;
		for (int rank = 0; rank < RANKS; rank++) {
			color = color.other();
			for (int file = 0; file < FILES; file++) {
				fields[rank][file] = new Field(color);
				color = color.other();

				System.out.println("color: " + color);
				System.out.println("fields: " + fields[rank][file]);
			}
		}

		// Create Pieces

		this.reset();
	}

	public void reset() {

		/**
		 * Clear sets
		 */

		// Clear pawnSets
		whitePawnSet.clear();
		blackPawnSet.clear();

		// Reset white

		for (int file = 0; file < FILES; file++) {
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
			for (int file = 0; file < FILES; file++) {
				fields[rank][file].clear();
			}
		}

		// Reset black
		for (int file = 0; file < FILES; file++) {
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

		System.out.println("\n\nBoard setup complete");
		System.out.println("Current board: \n\n");
		System.out.println(printBoard());
	}

	// print current state of the chess board
	public String printBoard() {

		int rowCounter = 8;
		boolean insertRowCounter;

		String s = "";

		for (int i = 0; i < RANKS; i++) {
			String row = "";
			insertRowCounter = true;
			for (int j = 0; j < FILES; j++) {
				if (fields[i][j].getPiece() == null) {
					if (insertRowCounter) {
						row = rowCounter-- + row + "  |          ";
						insertRowCounter = false;
					} else {
						row = row + "|          ";
					}
				} else {
					if (insertRowCounter) {
						row = rowCounter-- + "  " + row + fields[i][j].getPiece().getColor()
								+ "-" + fields[i][j].getPiece();
						insertRowCounter = false;
					} else {
						row = row + fields[i][j].getPiece().getColor() + "-"
								+ fields[i][j].getPiece();
					}
				}
			}
			s += row + "\n" + LINE + "\n" + "\n";
		}
		s = NUMBERINGFILES + s;
		return s;
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

	public boolean isWithinBoard(Position position) {
		return isValidRank(position.getRank())
				&& isValidFile(position.getFile());
	}

	public Field getField(int rank, int file) {
		return this.fields[rank][file];
	}

	public Field getField(Position position) {
		return this.fields[position.getRank()][position.getFile()];
	}

	public Field[][] getFields() {
		return fields;
	}
}
