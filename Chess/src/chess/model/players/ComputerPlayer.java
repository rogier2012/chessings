package chess.model.players;

import chess.model.*;
import chess.model.pieces.*;
import chess.model.strategies.*;
import chess.model.moves.*;

public class ComputerPlayer extends Player {
	
	/*
	 * Instance variables
	 */
	
	private String name;
	private Strategy strategy;
	private Color color;
	
	/*
	 * Constructors
	 */
	
	public ComputerPlayer(String aName, Color aColor, Strategy aStrategy) {
		super(aName, aColor);
		this.name = aStrategy + "-" + aColor;
		this.color = aColor;
		this.strategy = aStrategy;
	}

	/*
	 * Getters and Setters
	 */

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Strategy getStrategy() {
		return strategy;
	}


	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}


	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
	
	
	
