package game;

import moves.Move;
import players.Player;
import board.ChessBoard;

public interface Game {
	
	/*
	 * Constants
	 */
	
	public static final int PLAYERAMOUNT = 2;
	
	/*
	 * Queries
	 */
	
	public Game copy();
	
	public Game outcome(Move move);
	
	public Player getCurrentPlayer();

	public Player getWaitingPlayer();
	
	public ChessBoard getBoard();
	
	public Player[] getPlayers();
	
	/*
	 * Commands
	 */
	
	public void play();
	
	
}
