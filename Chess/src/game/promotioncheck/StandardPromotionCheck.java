package game.promotioncheck;

import game.Game;
import moves.Move;
import pieces.ChessPiece;
import pieces.Pawn;
import players.Player;
import players.playerinput.input.PromotionInput;
import board.ChessBoard;

public class StandardPromotionCheck implements PromotionCheck {
	
	private Game game;
	
	public StandardPromotionCheck(Game game)	{
		this.game = game;
	}
	
	@Override
	public void promotionCheck(Move move, Player player) {
		ChessPiece movedPiece = game.getBoard().getChessPiece(move.getDestination());
		int rank = move.getDestination().getRank();
		if ((rank == ChessBoard.BLACKPIECERANK || rank == ChessBoard.WHITEPIECERANK) && movedPiece instanceof Pawn)	{
			PromotionInput input = player.determinePromotion(move.getDestination(), game);
			game.getBoard().setPiece(move.getDestination(), input.getPromotion());
		}
	}
	
	
}
