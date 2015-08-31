package players.playerinput.input;

import players.playerinput.UserInput;
import players.playerinput.request.RemiseRequest;

public class AgreementInput extends UserInput {
	
	private boolean accepted;
	
	public AgreementInput(String input)	{
		switch(input)	{
		case RemiseRequest.acceptinput:
			accepted = true;
		case RemiseRequest.denyinput:
			accepted = false;
		}
	}
	
	public AgreementInput(boolean accepted)	{
		this.accepted = accepted;
	}
	
	public boolean isAccepted()	{
		return this.accepted;
	}
}
