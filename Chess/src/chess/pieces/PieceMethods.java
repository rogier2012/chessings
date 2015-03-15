package chess.pieces;

import chess.*;
import chess.model.*;
import chess.model.pieces.*;
import chess.controller.*;
import chess.controller.piecespecific.*;
import chess.view.*;

public class PieceMethods {

	public boolean checkValidMovePawn(Pawn pawn, Move move, Board board) {
		boolean result = false;
		Position initialPoint = move.getInitial();
		Position endPoint = move.getEnd();
		boolean firstMoveMade = pawn.isFirstMove();

		// check if i can move 1 forward
		if ((initialPoint.getRank() == endPoint.getRank() - 1)
				&& initialPoint.getFile() == endPoint.getFile()) {
			if (board.getPiece(endPoint) == 0) {
				result = true;
			}
			result = true;
		}
		return result;
	}

	public boolean moveForward(Position initialPoint, Position endPoint, Board board) {
		boolean result = false;
		if (board.getPiece(endPoint) == 0) {
			if ((initialPoint.getRank() == endPoint.getRank() - 1) && initialPoint.getFile() == endPoint.getFile()) {
				result = true;
			}
		}
		return result;
	}

	public boolean pawnCapture(Pawn pawn, Move move, Board board) {
		boolean result = false;
		Position initialPoint = move.getInitial();
		Position endPoint = move.getEnd();

		// check if move forward is allowed
		if (initialPoint.getRank() == endPoint.getRank() - 1
				&& initialPoint.getFile() == endPoint.getFile() + 1) {
			if (board.getPiece(endPoint) == 0) {
				result = true;
			}
		} else {
			result = false;
		}
		return result;
	}
}