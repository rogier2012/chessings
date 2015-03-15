package chess.model.pieces;

import chess.model.*;
import chess.controller.*;
import chess.controller.piecespecific.*;
import chess.view.*;

public abstract class ChessPiece {
	private Color color;
	private Position position;

	public ChessPiece(Color color, int rank, int file){
		this.color = color;
		position = new Position(rank, file);
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	public void setColor(Color color)	{
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

	public void setPosition(int rank, int file) {
		this.position.setRank(rank);
		this.position.setFile(file);
	}
}
