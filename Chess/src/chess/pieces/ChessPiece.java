package chess.pieces;

import chess.*;

public abstract class ChessPiece {
	private Color color;
	private Position position;
	

	public ChessPiece(Color color, int rank, int file){
		this.color = color;
		this.position.setRank(rank);
		this.position.setFile(file);
	}
	
	public Field getPosition() {
		return null;
	}

	public Color getColor() {
		return this.color;
	}

	public void setPosition(int rank, int file, Board board) {
		this.position.setRank(rank);
		this.position.setFile(file);
	}

	public abstract boolean isValidMove();
}
