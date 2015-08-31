package testing.boards;

import java.util.ArrayList;

import enums.Color;
import pieces.ChessPiece;
import board.ChessBoard;
import board.Square;
import board.versions.SquareCentricBoard;

public class BoardSpeedTest {
	
	private static final int REPEAT = 5000;
	
	private ChessBoard board;
	
	public static void main(String[] args) {
		BoardSpeedTest test = new BoardSpeedTest(new SquareCentricBoard());
		test.testReset();
		test.testGetChessPiece();
		test.testGetPosition();
		test.testGetAllChessPiecesOf();
	}
	
	public BoardSpeedTest(ChessBoard board)	{
		this.board = board;
	}
	
	
	private void testReset()	{
		System.out.println("TESTING: reset() " + REPEAT + " times.");
		long start = System.currentTimeMillis();
		for (int r = 0; r < REPEAT; r++)	{
			board.reset();
		}
		long end = System.currentTimeMillis();
		long duration = end - start;
		double avgDuration = (float) duration/REPEAT;
		System.out.println("Total duration: " + duration + " ms.");
		System.out.println("Avg. duration: " + avgDuration + " ms." + "\n");
		
	}
	
	private void testGetChessPiece()	{
		System.out.println("TESTING: getChessPiece() " + REPEAT + " times.");
		ArrayList<Square> toCheck = new ArrayList<Square>();
		for (int rank = 0; rank < ChessBoard.RANKS; rank++)	{
			for (int file = 0; file < ChessBoard.FILES; file++)	{
				toCheck.add(new Square(rank, file));
			}
		}
		
		long start = System.currentTimeMillis();
		for (int r = 0; r < REPEAT; r++)	{
			for (Square s : toCheck)	{
				board.getChessPiece(s);
			}
		}
		long end = System.currentTimeMillis();
		long duration = end - start;
		double avgDuration = (float) duration/REPEAT;
		System.out.println("Total duration: " + duration + " ms.");
		System.out.println("Avg. duration: " + avgDuration + " ms." + "\n");
	}
	
	private void testGetPosition()	{
		System.out.println("TESTING: getPosition() " + REPEAT + " times.");
		ArrayList<ChessPiece> toCheck = new ArrayList<ChessPiece>();
		toCheck.addAll(this.board.getAllChessPiecesOf(Color.WHITE));
		toCheck.addAll(this.board.getAllChessPiecesOf(Color.BLACK));
		
		long start = System.currentTimeMillis();
		for (int r = 0; r < REPEAT; r++)	{
			for (ChessPiece piece : toCheck)	{
				this.board.getPosition(piece);
			}
		}
		long end = System.currentTimeMillis();
		long duration = end - start;
		double avgDuration = (float) duration/REPEAT;
		System.out.println("Total duration: " + duration + " ms.");
		System.out.println("Avg. duration: " + avgDuration + " ms." + "\n");
	}
	
	private void testGetAllChessPiecesOf()	{
		System.out.println("TESTING: getAllChessPiecesOf() " + REPEAT + " times.");
		long start = System.currentTimeMillis();
		for (int r = 0; r < REPEAT/2; r++)	{
			this.board.getAllChessPiecesOf(Color.WHITE);
			this.board.getAllChessPiecesOf(Color.BLACK);
			
		}
		long end = System.currentTimeMillis();
		long duration = end - start;
		double avgDuration = (float) duration/REPEAT;
		System.out.println("Total duration: " + duration + " ms.");
		System.out.println("Avg. duration: " + avgDuration + " ms." + "\n");
	}
	
}
