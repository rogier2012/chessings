package game.checkcheck;

import enums.Color;

/*
 * check check check check check check check check check check check check check check check check check check check 
 * check check check check check check check check check check check check check check check check check check check
 * check check check check check check check check check check check check check check check check check check check
 * check check check check check check check check check check check check check check check check check check check
 * check check check check check check check check check check check check check check check check check check check
 * check check check check check check check check check check check check check check check check check check check
 * check check check check check check check check check check check check check check check check check check check
 * check check check check check check check check check check check check check check check check check check check
 * check check check check check check check check check check check check check check check check check check check
 */
/**
 * Check checks check if a king of a certain color is in check. Check.
 */
public interface CheckCheck {
	
	/**
	 * @param color -- The color of the king to check
	 * @return -- The king with this color is in check
	 */
	public boolean isKingInCheck(Color color);
	
}
