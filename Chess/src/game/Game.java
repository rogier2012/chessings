package game;

import game.history.GameHistory;
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
	
	public GameHistory getHistory();
	
	public int getMoveIndex();
	
	/*
	 * Commands
	 */
	
	public void play();
	
	
}
