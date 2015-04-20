package chess.model.moveoptions;

import chess.model.*;
import chess.model.moves.*;

public class MoveOption {
	
	/*
	 * Instance variables
	 */
	
	private int[] direction;
	private int range;
	
	/*
	 * Constructors
	 */
	
	public MoveOption(int rankStep, int fileStep, int range)	{
		direction = new int[]{rankStep, fileStep};
		this.range = range;
	}

	/*
	 * Queries
	 */
	
	/*
	 * Checks if this move can be done using this moveOption
	 */
	public boolean isSatisfiedBy(Move move)	{
		int[] moveDirection = new int[]{move.getEnd().getRank() - move.getInitial().getRank(), move.getEnd().getFile() - move.getInitial().getFile()};
		int[] zeroVector = new int[]{0, 0};
		if (moveDirection[0] == zeroVector[0] && moveDirection[1] == zeroVector[1])	{
			// You can't move to the same position!
			return false;
		} else {
			return isMultiple(this.direction, moveDirection);
		}
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
		// Make sure vector length is two
		if (v1.length != 2 && v1.length != v2.length)	{
			System.out.println("Wrong input at MoveOption.isMultiple()!");
			return false;
		}
		int c1 = 0;
		int c2 = 0;
		if (equalSigns(v1, v2))	{
			if (separateMultiples(v1, v2))	{
				while(v2[0] != 0 && v2[1] != 0)	{
					if (v2[0] != 0)	{
						v2[0] = v2[0] - v1[0];
						c1++;
					}
					if (v2[1] != 0)	{
						v2[1] = v2[1] - v1[0];
						c2++;
					}
				}
				return (c1 == c2) && c1 <= this.range;
			}
		}
		return false;
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
	 * Check if both elements of v2 are divisible by the elements in v1
	 * !!! Help method for this.isMultiple() !!!
	 */
	private boolean separateMultiples(int[] v1, int[] v2)	{
		if (v1[0] == 0 && v2[0] != 0) return false;
		if (v1[1] == 0 && v2[1] != 0) return false;
		if (v1[0] == 0 && v2[0] == 0 && v1[1] == 0 && v2[1] == 0)	return true;
		if (v1[0] == 0 && v2[0] == 0)	return v2[1]%v1[1] == 0;
		return v2[0]%v1[0] == 0;
		// Ik wil bij deze mezelf de maker benoemen van misschien wel de lelijkste methode ooit.
		// Maar hij doet!
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
	
	
}
