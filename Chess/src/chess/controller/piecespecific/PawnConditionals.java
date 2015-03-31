package chess.controller.piecespecific;

import java.util.*;

import chess.controller.BoardController;
import chess.model.*;
import chess.model.pieces.Pawn;
import chess.view.*;

public class PawnConditionals {
	
	public boolean canMoveOneForward(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardController.WHITEPAWN;
		boolean result = false;
		
		// Pawn is white
		if (isWhite) {
			Position newPos = new Position(position.getRank() + 1, position.getFile());

			if (board.isWithinBoard(newPos)){
				if (!board.isOccupied(newPos)) {
					result = true;
				}
			}
		} 
		
		// Pawn is black
		else {
			Position newPos = new Position(position.getRank() - 1, position.getFile());
			
			if (board.isWithinBoard(newPos)){
				if (!board.isOccupied(newPos)) {
					result = true;
				}
			}
		}
		return result;
	}
	
	public boolean canMoveTwoForward(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardController.WHITEPAWN;
		boolean result = false;
		if (canMoveOneForward(position, board)) {
			if (isWhite) {
				Position newPosition = new Position(position.getRank() + 2, position.getFile());
				if (board.isWithinBoard(newPosition)) {
					if (!board.isOccupied(newPosition)) {
						result = true;
					}
				}
			} else {
				Position newPosition = new Position(position.getRank() - 2, position.getFile());
				if (board.isWithinBoard(newPosition)) {
					if (!board.isOccupied(newPosition)) {
						result = true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean canCaptureRight(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardController.WHITEPAWN;
		boolean result = false;
		// For the right and left side we assume white's POV
		if (isWhite) {
			Position newPos = new Position(position.getRank() + 1, position.getFile() + 1);
			if (board.isWithinBoard(newPos)) {
				if (board.isOccupied(newPos) && (board.getPiece(newPos) % 2) == 0) {
					result = true;
				}
			}
		} else {
			Position newPos = new Position(position.getRank() - 1, position.getFile() + 1);
			if (board.isWithinBoard(newPos)) {
				if (board.isOccupied(newPos) && (board.getPiece(newPos) % 2) == 1) {
					result = true;
				}
			}
		}
		return result;
	}
	
	public boolean canCaptureLeft(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardController.WHITEPAWN;
		boolean result = false;
		// For the right and left side we assume white's POV
		if (isWhite) {
			Position newPos = new Position(position.getRank() + 1, position.getFile() - 1);
			if (board.isWithinBoard(newPos)) {
				if (board.isOccupied(newPos) && (board.getPiece(newPos) % 2) == 0) {
					result = true;
				}
			}
		} else {
			Position newPos = new Position(position.getRank() - 1, position.getFile() - 1);
			if (board.isWithinBoard(newPos)) {
				if (board.getPiece(newPos) != 0 && (board.getPiece(newPos) % 2) == 1) {
					result = true;
				}
			}
		}
		return result;
	}
	
	public boolean canEnPassantRight(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardController.WHITEPAWN;
		boolean result = false;
		// For the right and left side we assume white's POV
		if (isWhite) {
			List<Pawn> bPawn = board.getBlackPawnList();
			Position newPos = new Position(position.getRank() + 1, position.getFile() + 1);
			Position enPassant = new Position(position.getRank(), position.getFile() + 1);
			if (board.isWithinBoard(newPos) && !board.isOccupied(newPos)) {
				for (Pawn p : bPawn) {
					if (p.getPosition().equals(enPassant) && p.isFirstMoveDone() && !p.isSecondMoveDone()) {
						result = true;
					}
				}
			}
		} else {
			List<Pawn> wPawn = board.getWhitePawnList();
			Position newPos = new Position(position.getRank() - 1, position.getFile() + 1);
			Position enPassant = new Position(position.getRank(), position.getFile() + 1);
			if (board.isWithinBoard(newPos) && !board.isOccupied(newPos)) {
				for (Pawn p : wPawn) {
					if (p.getPosition().equals(enPassant) && p.isFirstMoveDone() && !p.isSecondMoveDone()) {
						result = true;
					}
				}
			}
		}
		return result;
	}
	
	public boolean canEnPassantLeft(Position position, Board board)	{
		boolean isWhite = board.getPiece(position) == BoardController.WHITEPAWN;
		boolean result = false;
		// For the right and left side we assume white's POV
		if (isWhite) {
			List<Pawn> bPawn = board.getBlackPawnList();
			Position newPos = new Position(position.getRank() + 1, position.getFile() - 1);
			Position enPassant = new Position(position.getRank(), position.getFile() - 1);
			if (board.isWithinBoard(newPos) && !board.isOccupied(newPos)) {
				for (Pawn p : bPawn) {
					if (p.getPosition().equals(enPassant) && p.isFirstMoveDone() && !p.isSecondMoveDone()) {
						result = true;
					}
				}
			}
		} else {
			List<Pawn> wPawn = board.getWhitePawnList();
			Position newPos = new Position(position.getRank() - 1, position.getFile() - 1);
			Position enPassant = new Position(position.getRank(), position.getFile() - 1);
			if (board.isWithinBoard(newPos) && !board.isOccupied(newPos)) {
				for (Pawn p : wPawn) {
					if (p.getPosition().equals(enPassant) && p.isFirstMoveDone() && !p.isSecondMoveDone()) {
						result = true;
					}
				}
			}
		}
		return result;
	}
	
	
}
