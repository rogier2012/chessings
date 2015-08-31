package players.playerinput.request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A request to a player for input
 * 	- Can be answered with a move
 *  - Can be answered with resignation
 *  - Can be answered with a request to remise
 * @author Ron
 *
 */
public class TurnRequest extends InputRequest {
	
	public static final String remiseinput = "remise";
	public static final String resignationinput = "resign";
	
	private static final String moveInputFormat = "[a-h][1-8] [a-h][1-8]";
	private static final Pattern regex = Pattern.compile(moveInputFormat);
	
	@Override
	public boolean valid() {
		boolean valid = false;
		switch(this.getAnswer())	{
		case remiseinput:
			valid = true;
			break;
		case resignationinput:
			valid = true;
			break;
		default:
			Matcher matcher = regex.matcher(this.getAnswer());
			valid = matcher.matches();
		}
		return valid;
	}
	
	@Override
	public String message()	{
		return "Please make a move ([a-h][1-8] [a-h][1-8]). Type \"" + resignationinput + "\" to resign or \"" + remiseinput + "\" to propose remise.";
	}
	
	
}
