package players.playerinput.input;

import pieces.Bishop;
import pieces.ChessPiece;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;
import players.playerinput.UserInput;
import players.playerinput.request.PromotionRequest;
import enums.Color;

public class PromotionInput extends UserInput {
	
	private ChessPiece promotion;
	
	public PromotionInput(String input, Color color)	{
		switch(input)	{
		case PromotionRequest.pawninput:
			promotion = new Pawn(color);
			break;
		case PromotionRequest.queeninput:
			promotion = new Queen(color);
			break;
		case PromotionRequest.bishopinput:
			promotion = new Bishop(color);
			break;
		case PromotionRequest.knightinput:
			promotion = new Knight(color);
			break;
		case PromotionRequest.rookinput:
			promotion = new Rook(color);
			break;
		}
	}
	
	public ChessPiece getPromotion()	{
		return this.promotion;
	}
}
