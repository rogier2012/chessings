package players.computer;

import java.util.ArrayList;

import moves.Move;
import players.Player;
import players.computer.strategies.Strategy;
import players.playerinput.input.AgreementInput;
import players.playerinput.input.MoveInput;
import players.playerinput.input.PromotionInput;
import players.playerinput.input.TurnInput;
import board.Square;
import enums.Color;
import game.Game;

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
	 * Queries
	 */
	
	@Override
	public TurnInput determineMove(ArrayList<Move> options, Game game) {
		/*
		 * Computer players don't resign or propose remise. 
		 */
		MoveInput move = new MoveInput(this.strategy.determineMove(options, game, this.getColor()));
		return move;
	}
	
	@Override
	public PromotionInput determinePromotion(Square position, Game game) {
		return new PromotionInput(this.strategy.determinePromotion(position, game), this.getColor());
	}

	@Override
	public AgreementInput remise(Game game) {
		return new AgreementInput(this.strategy.remise(this.getColor(), game));
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