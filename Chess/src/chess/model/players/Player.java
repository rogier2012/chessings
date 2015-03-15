package chess.model.players;

import chess.model.Board;
import chess.model.Color;
import chess.model.moves.*;

public abstract class Player {
	
	/*
	 * Instance variables
	 */
	
	private String name;
	private Color color;
	
	/*
	 * Constructors
	 */
	
	public Player(String aName, Color aColor)	{
		this.name = aName;
		this.color = aColor;
	}
	
	/*
	 * Queries
	 */
	
	//TODO
	public abstract Move determineMove(Board board);
	
	/*
	 * Commands
	 */
	
	//TODO
	public void makeMove(Board board)	{
		
	}
	
	/*
	 * Getters and setters
	 */
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
