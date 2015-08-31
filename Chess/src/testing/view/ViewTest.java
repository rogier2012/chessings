package testing.view;

import enums.Color;
import view.TUI;
import view.View;
import board.ChessBoard;
import board.versions.SquareCentricBoard;

public class ViewTest {
	
	public static void main(String[] args) {
		ChessBoard board = new SquareCentricBoard();
		View view = new TUI(board);
		board.reset();
		view.showBoard(Color.WHITE);
	}
	
}
