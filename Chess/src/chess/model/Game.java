package chess.model;

import chess.model.moves.Move;
import chess.model.pieces.*;
import chess.model.players.*;
import chess.model.strategies.*;
import chess.controller.players.*;
import chess.controller.*;
import chess.view.*;

public class Game {
	
	/*
	 * Constants
	 */
	
	public static final int PLAYERAMOUNT = 2;
	
	/*
	 * Instance variables
	 */
	
	private Board board;
	private BoardController boardController;
	private BoardView boardView;
	
	private int current;
	
	private Player[] players;
	private HumanPlayerController humanPlayerController;
	private ComputerPlayerController computerPlayerController;
	
	/*
	 * Constructors
	 */
	
	public Game(Player player1, Player player2){
		this.players = new Player[2];
		players[0] = player1;
		players[1] = player2;
		board = new Board();
		
		current = 0;
		boardController = new BoardController();
		humanPlayerController = new HumanPlayerController();
		computerPlayerController = new ComputerPlayerController();
	}
	
	/*
	 * Queries
	 */
	
	public boolean gameOver(Game game)	{
		// TODO : Checks if the game ended

		/*
		 * Check for win/loss
		 * 	- white resignation
		 * 	- black resignation
		 * 	- white checkmate
		 * 	- black checkmate
		 */
		
		/*
		 * Check for a draw
		 * 	- No possible valid moves left for next player (stalemate)
		 *  - Both players agree on a draw
		 *  - Both players don't have enough pieces
		 *  		* King v.s. King
		 *  		* King v.s. King + Knight
		 *  		* King v.s. King + Bishop
		 *  		* King + Bishop v.s. King + Bishop (Bishops should share tile color)
		 */
		
		/*
		 * Ask player if he wants to end the game in a draw
		 * 	- In 50 subsequent moves no pawns were moved or pieces were captured
		 *  - 3 Subsequent moves of a certain player result in the same board configuration. The amount of possibilities for moves should be the same as well in each configuration!
		 */
		
		
		return false;
	}
	
	public boolean isValidMove(Game game, Move move)	{
		// TODO : Checks if the suggested move is valid
		return true;
	}
	
	/*
	 * Getters and Setters
	 */

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public BoardController getBoardController() {
		return boardController;
	}

	public void setBoardController(BoardController boardController) {
		this.boardController = boardController;
	}

	public HumanPlayerController getHumanPlayerController() {
		return this.humanPlayerController;
	}
	
	public ComputerPlayerController getComputerPlayerController()	{
		return this.computerPlayerController;
	}
	
	public void setHumanPlayerController(HumanPlayerController humanPlayerController)	{
		this.humanPlayerController = humanPlayerController;
	}
	
	public void setComputerPlayerController(ComputerPlayerController computerPlayerController) {
		this.computerPlayerController = computerPlayerController;
	}

	public BoardView getBoardView() {
		return boardView;
	}

	public void setBoardView(BoardView boardView) {
		this.boardView = boardView;
	}
	
}
