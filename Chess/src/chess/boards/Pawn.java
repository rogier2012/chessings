package chess.boards;

import chess.*;
import chess.Position;

public class Pawn extends ChessPiece{
	
	private boolean isFirstMove;
	
	public Pawn(Color color, int rank, int file)	{
		super(color, rank, file);
		isFirstMove = true;
	}
	
	public boolean isFirstMove()	{
		return this.isFirstMove;
	}
	
	@Override
	public boolean isValidMove(int rank, int file, Board board) {
		return false;
	}
	
	public boolean canCapture(int rank, int file, Board board)	{
		boolean imWhite = (this.getColor() == Color.WHITE);
		boolean imBlack = (this.getColor() == Color.BLACK);
		int myRank = this.getPosition().getRank();
		int myFile = this.getPosition().getFile();
		
		if (imWhite)	{
			boolean regularCapture = (myRank + 1 == rank) && (myFile + 1 == file || myFile - 1 == file);
			boolean enPassant =false; // TODO IMPLEMENT EN PASSANT
			
			
			return regularCapture || enPassant;
		} else if(imBlack)	{
			boolean regularCapture = (myRank - 1 == rank) && (myFile + 1 == file || myFile - 1 == file);
			
			
		}		
		return false;
	}
	
	
	public boolean canCaptureRight(int rank, int file, Board board)	{
		boolean imWhite = (this.getColor() == Color.WHITE);
		boolean imBlack = (this.getColor() == Color.BLACK);
		int myRank = this.getPosition().getRank();
		int myFile = this.getPosition().getFile();
		
		
		return false;
	}
	
	public boolean canCaptureLeft(int rank, int file, Board board)	{
		boolean imWhite = (this.getColor() == Color.WHITE);
		boolean imBlack = (this.getColor() == Color.BLACK);
		int myRank = this.getPosition().getRank();
		int myFile = this.getPosition().getFile();
		
		
		
		return false;
	}
	
	public boolean canEnPassantRight(int rank, int file, Board board)	{
		boolean imWhite = (this.getColor() == Color.WHITE);
		boolean imBlack = (this.getColor() == Color.BLACK);
		int myRank = this.getPosition().getRank();
		int myFile = this.getPosition().getFile();
		
		
		return false;
	}
	
	public boolean canEnPassantLeft(int rank, int file, Board board)	{
		boolean imWhite = (this.getColor() == Color.WHITE);
		boolean imBlack = (this.getColor() == Color.BLACK);
		int myRank = this.getPosition().getRank();
		int myFile = this.getPosition().getFile();
		
		
		return false;
	}
	
	
	
}
