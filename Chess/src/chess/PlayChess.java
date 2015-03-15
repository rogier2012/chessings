package chess;

import chess.model.Board;
import chess.controller.BoardController;
import chess.view.BoardView;

public class PlayChess {

	public static void main(String[] args) {
		Board board = new Board();
		BoardController boardController = new BoardController();
		BoardView boardView = new BoardView();
		
		boardController.reset(board);
		
		System.out.println(boardView.toString(board));
	}
}
