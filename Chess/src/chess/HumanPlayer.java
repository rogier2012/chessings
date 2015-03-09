package chess;

public class HumanPlayer extends Player{

	public HumanPlayer(String aName, Color aColor) {
		super(aName, aColor);
	}

	@Override
	public Move determineMove(Board board) {
		InputForMove input = new InputForMove();
		Position[] positions = input.input();
		
		return new Move(positions[0], positions[1]);
	}

	
}
