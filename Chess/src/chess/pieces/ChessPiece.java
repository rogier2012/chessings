package chess.pieces;

import chess.*;

public abstract class ChessPiece {
	private Color color;
	private int[] position;

	public ChessPiece(Color color, int i, int j){
		this.color = color;
		this.position = new int[]{i,j};
	}
	
	public Field getPosition() {
		return null;
	}

	public Color getColor() {
		return this.color;
	}

	public void setPosition(int i, int j, Board board) {
		this.position[0] = i;
		this.position[1] = j;
//		board.setField(this, i, j);
	}

	public void move(int i, int j, Board board) {
		if ((board.getField(i, j).getPiece() instanceof Empty || board
				.getField(i, j).getPiece.getColor == this.color.other())
				&& this.isValidMove()) {
			this.setPosition(i, j, board);
		} else {

		}
	}

	public abstract boolean isValidMove();
}
