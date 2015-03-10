package chess.model;

import chess.*;
import chess.pieces.*;

import java.util.List;
import java.util.ArrayList;

public class Board {
	
	public static final int FILES = 8;
	public static final int RANKS = 8;
	
	private List<ChessPiece> whitePawnList;
	private List<ChessPiece> blackPawnList;
	
	private byte[][] fields;
	
	public Board()	{
		this.fields = new byte[RANKS][FILES];
		
		this.whitePawnList = new ArrayList<ChessPiece>();
		this.blackPawnList = new ArrayList<ChessPiece>();
	}
	
	public byte getPiece(Position pos) {
		return this.fields[pos.getRank()][pos.getFile()];
	}

	public void setPiece(int rank, int file, byte piece)	{
		this.fields[rank][file] = piece;
	}

	public List<ChessPiece> getWhitePawnList()	{
		return this.whitePawnList;
	}
	
	public List<ChessPiece> getBlackPawnList()	{
		return this.blackPawnList;
	}
}
