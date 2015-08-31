package players.playerinput.request;


/**
 * A request to a player for input
 *  - Can be answered with yes or no (whether the player agrees on a remise or not)
 * @author Ron
 *
 */
public class RemiseRequest extends InputRequest {
	
	public static final String acceptinput = "yes";
	public static final String denyinput = "no";
	
	@Override
	public boolean valid() {
		boolean valid = false;
		switch(this.getAnswer())	{
		case acceptinput:
			valid = true;
			break;
		case denyinput:
			valid = true;
			break;
		}
		return valid;
	}
	
	@Override
	public String message()	{
		return "Your opponent requested a remise. Accept? (yes/no)";
	}
	
}
