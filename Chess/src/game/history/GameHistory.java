package game.history;

import java.util.List;

import moves.Move;
import board.ChessBoard;

/**
 *  Responsible for keeping track of the board states and moves done in a game.
 */
public interface GameHistory {
	
	/*
	 * Queries
	 */
	
	/**
	 * @param turn -- index of the board that is requested
	 * @return -- The board configuration before this turn
	 */
	public ChessBoard getBoard(int turn);
	
	/**
	 * @param turn -- turn in which this move is executed
	 * @return -- move which was executed in this turn
	 */
	public Move getMove(int turn);
	
	/**
	 * @return -- All board configurations that occurred this game, in chronological order
	 */
	public List<ChessBoard> getAllBoards();
	
	/**
	 * @return -- All moves executed during this game, in chronological order
	 */
	public List<Move> getAllMoves();
	
	/*
	 * Commands
	 */
	
	/**
	 * @param board -- board to append to history
	 */
	public void addBoard(ChessBoard board);
	
	/**
	 * @param move -- move to append to history
	 */
	public void addMove(Move move);
	
	/**
	 * @param board -- board to remove from history
	 */
	public void removeBoard(ChessBoard board);
	
	/**
	 * @param move -- move to remove from history
	 */
	public void removeMove(Move move);
	
}
