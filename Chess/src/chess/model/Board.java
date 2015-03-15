package chess.model;

import chess.*;
import chess.model.pieces.*;
import chess.view.*;
import chess.controller.*;

import java.util.List;
import java.util.ArrayList;

public class Board {
	
	public static final int FILES = 8;
	public static final int RANKS = 8;
	
	private List<Pawn> whitePawnList;
	private List<Pawn> blackPawnList;
	
	private byte[][] fields;
	
	public Board()	{
		this.fields = new byte[RANKS][FILES];
		
		this.whitePawnList = new ArrayList<Pawn>();
		this.blackPawnList = new ArrayList<Pawn>();
	}
	
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
