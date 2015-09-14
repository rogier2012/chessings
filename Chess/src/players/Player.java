package players;

import java.util.List;

import moves.Move;
import players.playerinput.input.AgreementInput;
import players.playerinput.input.PromotionInput;
import players.playerinput.input.TurnInput;
import board.Square;
import enums.Color;
import game.Game;

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
	
	public abstract TurnInput determineMove(List<Move> options, Game game);
	
	public abstract PromotionInput determinePromotion(Square position, Game game);
	
	public abstract AgreementInput remise(Game game);
	
	/*
	 * Getters and setters
	 */
	
	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}
	
}