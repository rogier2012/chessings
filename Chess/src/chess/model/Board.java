package chess.model;

import chess.*;
import chess.model.pieces.*;
import chess.view.*;
import chess.controller.*;

import java.util.List;
import java.util.ArrayList;

public class Board {
	
	/*
	 * Constants
	 */
	
	public static final int FILES = 8;
	public static final int RANKS = 8;
	
	/*
	 * Instance variables
	 */
	
	private List<Pawn> whitePawnList;
	private List<Pawn> blackPawnList;
	
	private byte[][] fields;
	
	/*
	 * Constructors
	 */
	
	public Board()	{
		this.fields = new byte[RANKS][FILES];
		
		this.whitePawnList = new ArrayList<Pawn>(FILES);
		this.blackPawnList = new ArrayList<Pawn>(FILES);
	}
	
	/*
	 * Queries
	 */
	
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
	
	public boolean isOccupied(Position position)	{
		return this.getPiece(position) != BoardController.EMPTY;
	}
	
	/*
	 * Getters and Setters
	 */
	
	public byte getPiece(Position pos) {
		return this.fields[pos.getRank()][pos.getFile()];
	}

	public void setPiece(int rank, int file, byte piece)	{
		this.fields[rank][file] = piece;
	}

	public List<Pawn> getWhitePawnList()	{
		return this.whitePawnList;
	}
	
	public List<Pawn> getBlackPawnList()	{
		return this.blackPawnList;
	}

}
