package moveoptions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import moves.Move;
import moves.MoveSuggestion;
import pieces.ChessPiece;
import board.ChessBoard;
import board.Square;
import enums.Color;
import game.Game;

// TODO -- Make sure MoveOption with direction (0, 0) is not possible!
public abstract class MoveOption { // TODO Comment help methods!
	
	/*
	 * Instance variables
	 */
	
	/**
	 * int[] direction -- What are the differences in ranks and files when executing the smallest step possible using this MoveOption?
	 * (e.g.) {1,0} for a forward step, {1,1} for a diagonal step, {2, 1} for a Knight's Move
	 */
	private int[] direction;
	
	/**
	 * int range -- How many times can this minimal difference in ranks and files be repeated?
	 * (e.g.) Board.FILES for unlimited movement in a certain direction, 1 for a single step.
	 */
	private int range;
	
	/**
	 * boolean canJump -- Is this MoveOption allowed to jump over pieces?
	 */
	private boolean canJump;
	
	/**
	 * boolean isRepeatable -- Can this MoveOption be used in multiple turns?
	 */
	private boolean isRepeatable;
	
	/*
	 * Constructors
	 */
	
	public MoveOption(int rankStep, int fileStep, int range)	{
		this.direction = new int[]{rankStep, fileStep};
		this.range = range;
		this.isRepeatable = true;
		this.canJump = false;
	}
	
	public MoveOption(Color color)	{
		this.direction = new int[]{0, 0};
		this.range = 0;
		this.isRepeatable = true;
		this.canJump = false;
	}

	/*
	 * Queries
	 */
	
	public Move getMove(MoveSuggestion suggestion, Game game)	{
		Move result = null;
		boolean valid = this.requirementsAreMet(game, suggestion);
		if (valid)	{
			result = this.generateMove(suggestion);
		}
		return result;
	}
	
	/*
	 * Checks if this move can be done using this moveOption
	 */
	public boolean isSatisfiedBy(MoveSuggestion suggestion)	{
		int[] moveDirection = new int[]{suggestion.getDestination().getRank() - suggestion.getOrigin().getRank(), suggestion.getDestination().getFile() - suggestion.getOrigin().getFile()};
		int[] zeroVector = new int[]{0, 0};
		if (moveDirection[0] == zeroVector[0] && moveDirection[1] == zeroVector[1])	{
			// You can't move to the same position!
			return false;
		} else {
			return isMultiple(this.direction, moveDirection);
		}
	}
	
	/**
	 * Checks the universal requirements for move options
	 * @param game -- Game in which the move is suggested
	 * @param suggestion -- Move suggestion
	 */
	public boolean requirementsAreMet(Game game, MoveSuggestion suggestion)	{
		boolean result = true;
		result = result && ChessBoard.isWithinBoard(suggestion.getOrigin());
		result = result && ChessBoard.isWithinBoard(suggestion.getDestination());
		result = result && this.isSatisfiedBy(suggestion);
		result = result && this.specificRequirementsAreMet(game, suggestion);
		result = result && !this.isBlocked(game, suggestion);
		return result;
	}
	
	/**
	 * Returns a list of all Moves that could satisfy this MoveOption
	 * @param position -- position from which moves could be made
	 * @param board -- board in which the move should be done
	 */
	public ArrayList<Move> getAllPossibilitiesFrom(Square origin, Game game)	{
		ArrayList<Move> result = new ArrayList<Move>();
		int covered = 0;
		do {
			covered++;
			int rankDifference = covered * this.direction[0];
			int fileDifference = covered * this.direction[1];
			Square destination = new Square(origin.getRank() + rankDifference, origin.getFile() + fileDifference);
			Move move = this.getMove(new MoveSuggestion(origin, destination), game);
			if (move != null)	{
				result.add(move);
			}
		} while (covered < this.range);
		return result;
	}
	
	public abstract boolean specificRequirementsAreMet(Game game, MoveSuggestion suggestion);
	
	public abstract Move generateMove(MoveSuggestion suggestion);
	
	/*
	 * Private help methods
	 */
	
	/**
	 * Checks if there is a valid piece to be moved on the suggested position
	 * @param game -- Game in which the move is suggested
	 * @param suggestion -- Move suggestion
	 */
//	private boolean pieceToBeMovedExists(Game game, MoveSuggestion suggestion)	{
//		Square origin = suggestion.getOrigin();
//		ChessPiece piece = game.getBoard().getChessPiece(origin);
//		return piece != null && piece.getColor() == game.getPlayers()[game.getCurrent()].getColor();
//	}
	
//	private boolean isBlockedBy(Square position, MoveSuggestion suggestion)	{ // TODO
//		boolean result = false;
//		Square toCheck = suggestion.getOrigin().deepCopy();
//		while (!suggestion.getDestination().isEqual(toCheck))	{
//			toCheck.setRank(toCheck.getRank() + this.getDirection()[0]);
//			toCheck.setFile(toCheck.getFile() + this.getDirection()[1]);
//			if (toCheck.isEqual(position))	{
//				result = true;
//				break;
//			}
//		}
//		return result;
//	}
	
	/** 
	 * Checks if any other pieces are preventing the move suggestion
	 * @param game -- Game in which the move is suggested
	 * @param suggestion -- Move suggestion
	 */
	private boolean isBlocked(Game game, MoveSuggestion suggestion)	{
		boolean result = true;
		result = result && targetFieldNotOccupied(game, suggestion);
		if (result && !this.canJump())	{
			Set<Integer> set = new HashSet<Integer>();
			set.add(1);
			set.add(-1);
			set.add(0);
			// Pieces can only block other pieces that go in straight horizontal, vertical or diagonal lines.
			// Check for these directions
			boolean properDirection = false;
			int[] direction = this.getDirection();
			properDirection = (set.contains(direction[0]) && set.contains(direction[1]))
							|| (direction[0] == 0) || (direction[1] == 0);
			if (properDirection)	{
				// Check positions between the move's initial and end position
				int[] line = new int[]{getSign(direction[0]), getSign(direction[1])};
				// * Keep track of current position that needs to be checked
				Square initial = suggestion.getOrigin();
				Square end = suggestion.getDestination();
				Square check = new Square(initial.getRank() + line[0], initial.getFile() + line[1]);
				while (!(check.isEqual(end)) && result)	{
					result = result && (game.getBoard().getChessPiece(check) == null);
					check = new Square(check.getRank() + line[0], check.getFile() + line[1]);
				}
			}
		}
		return !result;
	}
	
	/**
	 * Checks if the targeted square is not occupied by a piece of the same color
	 * @param game -- Game in which the move is suggested
	 * @param suggestion -- The move suggestion
	 * @return
	 */
	private boolean targetFieldNotOccupied(Game game, MoveSuggestion suggestion)	{
		Color color = game.getBoard().getChessPiece(suggestion.getOrigin()).getColor();
		ChessPiece target = game.getBoard().getChessPiece(suggestion.getDestination());
		boolean result = !(target != null && target.getColor() == color);
		return result;
	}
	
	private int getSign(int number){
		int sign;
		if (number < 0) sign = -1;
		else if (number > 0) sign = 1;
		else sign = 0;
		return sign;
	}
	
	/*
	 * Checks if v2 can be created by multiplying v1 with a positive integer.
	 */
	private boolean isMultiple(int[] v1 , int[] v2)	{
		boolean result = false;
		// Make sure vector length is two
		if (v1.length != 2 && v1.length != v2.length)	{
			System.out.println("Wrong input at MoveOption.isMultiple()!");
			return result;
		}
		if (equalSigns(v1, v2))	{ // General direction is the same
			// Check all fields in range
			boolean match;
			int range = 1;
			do {
				int[] check = new int[]{v1[0] * range, v1[1] * range};
				match = (check[0] == v2[0]) && (check[1] == v2[1]);
				range++;
			} while (range <= this.getRange() && !match);
			result = match;
		}
		return result;
	}
	
	/*
	 * Checks if the general direction is the same for both vectors
	 * !!! Help method for this.isMultiple() !!!
	 */
	private boolean equalSigns(int[] v1, int[] v2)	{
		int[] v1Sign = new int[]{getSign(v1[0]), getSign(v1[1])};
		int[] v2Sign = new int[]{getSign(v2[0]), getSign(v2[1])};
		return (v1Sign[0] == v2Sign[0] && v1Sign[1] == v2Sign[1]);
	}
	
	/*
	 * Getters and Setters
	 */
	
	public int[] getDirection() {
		return direction;
	}

	public void setDirection(int[] direction) {
		this.direction = direction;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public boolean isRepeatable() {
		return isRepeatable;
	}

	public void setRepeatable(boolean isRepeatable) {
		this.isRepeatable = isRepeatable;
	}

	public boolean canJump() {
		return canJump;
	}

	public void setCanJump(boolean canJump) {
		this.canJump = canJump;
	}
	
}
