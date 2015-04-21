package chess;

import chess.controller.BoardController;
import chess.controller.GameController;
import chess.model.Board;
import chess.model.Color;
import chess.model.Game;
import chess.model.players.ComputerPlayer;
import chess.model.players.HumanPlayer;
import chess.model.strategies.TestStrategy;
import chess.view.BoardView;

public class PlayChess {

	public static void main(String[] args) {
		GameController gameController = new GameController();
		
		Board board = new Board();
		BoardController boardController = new BoardController();
		BoardView boardView = new BoardView();
		
		boardController.reset(board);
		
		HumanPlayer one = new HumanPlayer("Freek", Color.WHITE);
		ComputerPlayer two = new ComputerPlayer("Karel", Color.BLACK, new TestStrategy());
		
		Game game = new Game(one, two);
		game.setBoard(board);
		
		gameController.play(game);
	}
}
