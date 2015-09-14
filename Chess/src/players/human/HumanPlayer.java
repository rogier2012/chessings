package players.human;

import java.util.List;

import moves.Move;
import moves.MoveSuggestion;
import players.Player;
import players.playerinput.input.AgreementInput;
import players.playerinput.input.MoveInput;
import players.playerinput.input.PromotionInput;
import players.playerinput.input.TurnInput;
import players.playerinput.request.PromotionRequest;
import players.playerinput.request.RemiseRequest;
import players.playerinput.request.TurnRequest;
import board.Square;
import enums.Color;
import game.Game;

public class HumanPlayer extends Player {
	
	public HumanPlayer(String aName, Color aColor) {
		super(aName, aColor);
	}
	
	@Override
	public TurnInput determineMove(List<Move> options, Game game) {
		TurnInput input = null;
		boolean valid = false;
		while (!valid)	{
			TurnRequest request = new TurnRequest();
			input = TurnInput.convert(request.getAnswer());
			if (input instanceof MoveInput)	{
				MoveSuggestion suggestion = ((MoveInput) input).getSuggestion();
				for (Move option : options)	{
					if (suggestion.getOrigin().isEqual(option.getOrigin()) && suggestion.getDestination().isEqual(option.getDestination()))	{
						((MoveInput) input).setMove(option);
						valid = true;
					}
				}
			} else {
				valid = true; /* Input is either of resignation or remise proposition */
			}
		}
		return input;
	}

	@Override
	public PromotionInput determinePromotion(Square position, Game game) { // TODO?
		return new PromotionInput(new PromotionRequest().getAnswer(), this.getColor());
	}

	@Override
	public AgreementInput remise(Game game) {
		return new AgreementInput(new RemiseRequest().getAnswer());
	}

}
