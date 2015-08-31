package players.playerinput.input;

import java.util.HashMap;

import moves.Move;
import moves.MoveSuggestion;
import board.Square;

public class MoveInput extends TurnInput {
	
	private MoveSuggestion suggestion;
	private Move chosen;
	
	private static final HashMap<Character, Integer> fileTable = new HashMap<Character, Integer>();
	static {
		fileTable.put('a', 1);
		fileTable.put('b', 2);
		fileTable.put('c', 3);
		fileTable.put('d', 4);
		fileTable.put('e', 5);
		fileTable.put('f', 6);
		fileTable.put('g', 7);
		fileTable.put('h', 8);
	}
	
	public MoveInput(String input)	{
		char[] charInput = input.toCharArray();
		Square origin = this.convertToPosition(charInput[0], charInput[1]);
		Square destination = this.convertToPosition(charInput[3], charInput[4]);
		this.suggestion = new MoveSuggestion(origin, destination);
	}
	
	public MoveInput(Move move)	{
		this.chosen = move;
	}
	
	private Square convertToPosition(char fileInput, char rankInput)	{
		int file = fileTable.get(fileInput) - 1;
		int rank = Character.getNumericValue(rankInput - 1);
		return new Square(rank, file);
	}
	
	public MoveSuggestion getSuggestion()	{
		return this.suggestion;
	}
	
	public Move getMove()	{
		return this.chosen;
	}
	
	public void setMove(Move move)	{
		this.chosen = move;
	}
	
}
