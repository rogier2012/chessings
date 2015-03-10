package chess.pieces;

import chess.*;

public abstract class ChessPiece {
	private Color color;
	private Position position;
	

	public ChessPiece(Color color, int rank, int file){
		this.color = color;
		position = new Position(rank, file);
	}
	
	
	public String toString() {
		String toReturn;
		if (color.equals(Color.WHITE)) {
			toReturn = "| W";
		} else if (color.equals(Color.BLACK)) {
			toReturn = "| B";
		} else {
			toReturn = "Unknown!";
		}

		return toReturn;
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
}
