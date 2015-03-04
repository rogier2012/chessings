package chess.pieces;

import chess.*;

public abstract class ChessPiece {
	private Color color;
	private int[] position;
	

	public ChessPiece(Color color, int rank, int file){
		this.color = color;
		this.position = new int[]{rank,file};
	}
	
	public Field getPosition() {
		return null;
	}

	public Color getColor() {
		return this.color;
	}

	public void setPosition(int rank, int file, Board board) {
		this.position[0] = rank;
		this.position[1] = file;
	}

	public abstract boolean isValidMove();
}
