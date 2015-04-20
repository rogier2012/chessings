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
	private List<King> kingList;
	
	private byte[][] fields;
	
	/*
	 * Constructors
	 */
	
	public Board()	{
		this.fields = new byte[RANKS][FILES];
		this.whitePawnList = new ArrayList<Pawn>(FILES);
		this.blackPawnList = new ArrayList<Pawn>(FILES);
		this.kingList = new ArrayList<King>(Game.PLAYERAMOUNT);
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
	
	public Board deepCopy()	{
		Board copy = new Board();
		copy.whitePawnList = this.whitePawnList;
		copy.blackPawnList = this.blackPawnList;
		// Copy whitePawnList
		for (int index = 0; index < this.whitePawnList.size(); index++)	{
			copy.whitePawnList.set(index, this.whitePawnList.get(index));
		}
		// Copy blackPawnList
		for (int index = 0; index < this.blackPawnList.size(); index++)	{
			copy.blackPawnList.set(index, this.blackPawnList.get(index));
		}
		// Copy fields
		for (int rank = 0; rank < RANKS; rank++)	{
			for (int file = 0; file < FILES; file++)	{
				copy.fields[rank][file] = this.fields[rank][file];
			}
		}
		// Copy kingList
		for (int index = 0; index < Game.PLAYERAMOUNT; index++)	{
			copy.kingList.set(index, this.kingList.get(index));
		}
		return copy;
	}
	
	public boolean isKingInCheck(Color color)	{
		Boolean result = false;
		Color opponent = color.other();
		King king;
		king = (color == Color.WHITE)? this.kingList.get(0):this.kingList.get(1);
 		Position position = king.getPosition();
		
 		
 		
 		
		
		//TODO
		return result;
	}
	
	/*
	 * Returns the ChessPiece object corresponding to the Piece byte representation and position
	 */
	public ChessPiece getChessPiece(byte bPiece, Position position){
		Color color = (bPiece%2 == 1)? Color.WHITE : Color.BLACK;
		// Is it a pawn?
		if (bPiece == BoardController.WHITEPAWN || bPiece == BoardController.BLACKPAWN)	{
			// Which pawn list should be searched?
			if (color == Color.WHITE)	{
				for (Pawn pawn : this.whitePawnList)	{
					if (pawn.getPosition().getRank() == position.getRank() && pawn.getPosition().getFile() == position.getFile())	{
						return pawn;
					}
				}
			} else if (color == Color.BLACK)	{
				for (Pawn pawn : this.blackPawnList)	{
					if (pawn.getPosition().getRank() == position.getRank() && pawn.getPosition().getFile() == position.getFile())	{
						return pawn;
					}
				}
			}
		// Is it a king?
		} else if (bPiece == BoardController.WHITEKING || bPiece == BoardController.BLACKKING)	{
			for (King king : this.kingList)	{
				System.out.println("hi");
				System.out.println(king.getPosition().toString()  + " : " + position.toString());
				if (king.getPosition().getRank() == position.getRank() && king.getPosition().getFile() == position.getFile())	{
					System.out.println("HAY");
					return king;
				}
			}
			
			
			
		}

		return null; // TODO
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

	public List<King> getKingList() {
		return kingList;
	}

	public void setKingList(List<King> kingList) {
		this.kingList = kingList;
	}

}
