package chess.model;

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
