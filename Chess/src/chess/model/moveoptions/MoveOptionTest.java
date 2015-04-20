package chess.model.moveoptions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.model.*;
import chess.model.moves.*;

public class MoveOptionTest {

	Position zeroZero;
	Position maxMax;
	Position oneZero;
	Position fiveFive;
	Position oneTwo;
	Position notInBoard;
	
	MoveOption forwardStep;
	MoveOption verticalLine;
	MoveOption knightMove;
	MoveOption jumpFromBoard;
	MoveOption diagonal;
	MoveOption oppositeDiagonal;
	
	@Before
	public void setUp() throws Exception {
		// Positions
		zeroZero = new Position(0, 0);
		maxMax = new Position(Board.RANKS - 1, Board.FILES - 1);
		oneZero = new Position(1, 0);
		fiveFive = new Position(5,5);
		oneTwo = new Position(1, 2);
		notInBoard = new Position(Board.RANKS, 0);
		
		// MoveOptions
		forwardStep = new MoveOption(1, 0, 1);
		verticalLine = new MoveOption(1, 0, Board.RANKS);
		knightMove = new MoveOption(1, 2, 1);
		jumpFromBoard = new MoveOption(Board.RANKS, 0 , 1);
		diagonal = new MoveOption(1, 1, Math.min(Board.RANKS, Board.FILES));
		oppositeDiagonal = new MoveOption(-1, -1, Math.min(Board.RANKS, Board.FILES));
	}

	@Test
	public void test() {
		assertEquals("I", true, testMove(zeroZero, oneZero, forwardStep));
		assertEquals("II", true, testMove(zeroZero, oneZero, verticalLine));
		assertEquals("III", false ,testMove(zeroZero, zeroZero, verticalLine));
		assertEquals("IV", true, testMove(zeroZero, oneTwo, knightMove));
		assertEquals("V", true, testMove(zeroZero, notInBoard, jumpFromBoard));
		assertEquals("VI", true, testMove(zeroZero, fiveFive, diagonal));
		assertEquals("VII", true, testMove(zeroZero, maxMax, diagonal));
		assertEquals("VIII", true, testMove(fiveFive, maxMax, diagonal));
		assertEquals("IX", false, testMove(maxMax, zeroZero, diagonal));
		assertEquals("X", true, testMove(maxMax, zeroZero, oppositeDiagonal));
	}
	
	public boolean testMove(Position pos1, Position pos2, MoveOption moveOption)	{
		Move move = new Move(pos1, pos2);
		return moveOption.isSatisfiedBy(move);
	}
	
	public void assertEquals(String text, Object expected, Object result) {
		System.out.println("        " + text);
		System.out.println("            Expected:  " + expected);
		System.out.println("            Result: " + result);
	}


}
