package chess.model.pieces;

import chess.model.*;
import chess.model.moveoptions.MoveOption;
import chess.model.pieces.*;
import chess.controller.*;
import chess.controller.piecespecific.*;
import chess.view.*;

public class Pawn extends ChessPiece{
	
	private boolean firstMoveDone;
	private boolean secondMoveDone;
	
	public Pawn(Color color, Position position)	{
		super(color, position);
		
		// Set moveOptions
		this.getMoveOptions().add(new MoveOption(1, 1, 1));
		this.getMoveOptions().add(new MoveOption(1, 0, 1));
		this.getMoveOptions().add(new MoveOption(2, 0, 1));
		this.getMoveOptions().add(new MoveOption(1, -1, 1));
		
		firstMoveDone = false;
		secondMoveDone = false;
	}
	
	public boolean isFirstMoveDone()	{
		return this.firstMoveDone;
	}

	public boolean isSecondMoveDone() {
		return secondMoveDone;
	}

	public void setSecondMoveDone(boolean b) {
		this.secondMoveDone = b;
	}

	public void setFirstMoveDone(boolean b) {
		this.firstMoveDone = b;
	}
}
