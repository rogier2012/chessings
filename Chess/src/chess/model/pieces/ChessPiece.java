package chess.model.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.model.Color;
import chess.model.Position;
import chess.model.moveoptions.MoveOption;
import chess.model.moves.Move;

public abstract class ChessPiece {
	
	/*
	 * Instance Variables
	 */
	
	private Color color;
	private Position position;
	private List<MoveOption> moveOptions;
	
	/*
	 * Constructors
	 */
	
	public ChessPiece(Color color, Position position){
		this.color = color;
		this.position = position;
		moveOptions = new ArrayList<MoveOption>();
	}
	
	/*
	 * Queries
	 */
	
	public boolean canMove(Move move)	{
		boolean result = false;
		int index = 0;
		while (index < this.getMoveOptions().size() && !result)	{
			result = this.getMoveOptions().get(index).isSatisfiedBy(move);
			index++;
		}
		return result;
	}
	
	/*
	 * Getters and Setters
	 */
	
	public Position getPosition() {
		return this.position;
	}
	
	public void setColor(Color color)	{
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

	public void setPosition(int rank, int file) {
		this.position.setRank(rank);
		this.position.setFile(file);
	}

	public List<MoveOption> getMoveOptions() {
		return moveOptions;
	}

	public void setMoveOptions(List<MoveOption> moveOptions) {
		this.moveOptions = moveOptions;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}
