package chess;

import chess.model.*;
import chess.model.players.*;
import chess.controller.BoardController;
import chess.view.BoardView;
import chess.controller.*;
import chess.model.strategies.*;

public class PlayChess {

	public static void main(String[] args) {
		GameController gameController = new GameController();
		
		Board board = new Board();
		BoardController boardController = new BoardController();
		BoardView boardView = new BoardView();
		
		boardController.reset(board);
		
		ComputerPlayer one = new ComputerPlayer("Freek", Color.WHITE, new TestStrategy());
		ComputerPlayer two = new ComputerPlayer("Karel", Color.BLACK, new TestStrategy());
		
		Game game = new Game(one, two);
		game.setBoard(board);
		
		gameController.play(game);
	}
}
