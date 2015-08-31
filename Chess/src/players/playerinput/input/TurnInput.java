package players.playerinput.input;

import players.playerinput.UserInput;
import players.playerinput.request.TurnRequest;

public abstract class TurnInput extends UserInput {
	
	public static TurnInput convert(String input)	{
		TurnInput result;
		switch(input)	{
		case TurnRequest.remiseinput:
			result = new RemiseInput();
			break;
		case TurnRequest.resignationinput:
			result = new ResignationInput();
			break;
		default:
			result = new MoveInput(input);
		}
		return result;
	}
	
}
