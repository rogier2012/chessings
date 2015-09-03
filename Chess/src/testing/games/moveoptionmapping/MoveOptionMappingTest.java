package testing.games.moveoptionmapping;

import enums.Color;
import game.moveoptionmapping.MoveMapping;
import game.moveoptionmapping.StandardMoveMapping;

import java.util.ArrayList;
import java.util.Set;

import moveoptions.MoveOption;
import moves.Castle;
import moves.CastleLong;
import moves.CastleShort;
import moves.ForwardDouble;
import moves.Move;

import org.junit.Before;
import org.junit.Test;

import pieces.ChessPiece;
import board.ChessBoard;
import board.Square;
import board.versions.SquareCentricBoard;

public class MoveOptionMappingTest {
	
	private static Move move = new Move(new Square(0, 0), new Square(1,0));
	private static Castle longCastle = new CastleLong(new Square(0, 3), new Square(0, 7));
	private static Castle shortCastle = new CastleShort(new Square(0, 3), new Square(0, 0));
	private static ForwardDouble doubleForward = new ForwardDouble(new Square(1, 0), new Square(3, 0));
	
	private ChessBoard board;
	private MoveMapping mapping;
	
	@Before
	public void setUp() throws Exception {
		this.board = new SquareCentricBoard();
		this.board.reset();
		this.mapping = new StandardMoveMapping(this.board);
	}
	
	@Test
	public void test() {
		this.showOptions();
		
//		showOptions(this.mapping.getAllOptions());
//		showOptions(this.mapping.getColorOptions(Color.WHITE));
//		showOptions(this.mapping.getColorOptions(Color.BLACK));
		
		
	}
	
	/*
	 * Queries
	 */
	
	private void showOptions()	{
		ArrayList<ChessPiece> whitePieces = board.getAllChessPiecesOf(Color.WHITE);
		ArrayList<ChessPiece> blackPieces = board.getAllChessPiecesOf(Color.BLACK);
		System.out.println("Showing all options of all pieces");
		System.out.println("Total pieces amount: " + (this.board.getAllChessPiecesOf(Color.WHITE).size() + this.board.getAllChessPiecesOf(Color.BLACK).size()));
		System.out.println("Total options amount: " + this.mapping.getAllOptions().size());
		
		System.out.println("Showing white pieces: ");
		for (ChessPiece piece : whitePieces)	{
			System.out.println("\n" + piece.getColor() + " " + piece);
			Set<MoveOption> options = this.mapping.getOptions(piece);
			System.out.println(options.size() + " Options:");
			for (MoveOption option : options)	{
				System.out.println(option);
			}
		}
		
		System.out.println("Showing black pieces: ");
		for (ChessPiece piece : blackPieces)	{
			System.out.println("\n" + piece.getColor() + " " + piece);
			Set<MoveOption> options = this.mapping.getOptions(piece);
			System.out.println(options.size() + " Options:");
			for (MoveOption option : options)	{
				System.out.println(option);
			}
		}
		
	}
	
	private static void showOptions(Set<MoveOption> options)	{
		System.out.println("Showing options:");
		for (MoveOption option : options)	{
			System.out.println(option);
		}
		System.out.println("Total size: " + options.size() + "\n");
	}
	
	
	
	
	

}
