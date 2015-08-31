package players.playerinput.request;

/**
 * A request to a player for input
 * 	- Can only specify to which piece the pawn is promoted
 * @author Ron
 *
 */
public class PromotionRequest extends InputRequest {
	
	public static final String pawninput = "pawn";
	public static final String queeninput = "queen";
	public static final String knightinput = "knight";
	public static final String bishopinput = "bishop";
	public static final String rookinput = "rook";
	
	@Override
	public boolean valid() {
		boolean valid = false;
		switch(this.getAnswer()){
		case pawninput:
			valid = true;
			break;
		case queeninput:
			valid = true;
			break;
		case knightinput:
			valid = true;
			break;
		case bishopinput:
			valid = true;
			break;
		case rookinput:
			valid = true;
			break;
		}
		return valid;
	}
	
	@Override
	public String message()	{
		return "To which piece should your pawn be promoted?";
	}

}
