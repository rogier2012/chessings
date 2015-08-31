package game.movecounter;

import enums.Color;

/**
 * A class to increment and decrement an integer.
 * 
 * 
 * 
 * 
 * I have no idea why I made this.
 * @author Ron
 *
 */
public class MoveCounter {
	
	/*
	 * Instance Variables
	 */
	
	private int count;
	
	/*
	 * Constructor
	 */
	
	public MoveCounter()	{
		reset();
	}
	
	/*
	 * Queries
	 */
	
	public Color moveColor(int index)	{
		return index%2 == 0? Color.WHITE:Color.BLACK;
	}
	
	/*
	 * Commands
	 */
	
	public void increment()	{
		count++;
	}
	
	public void decrement()	{
		if (count >= 0) {count--;};
	}
	
	public void reset()	{
		count = 0;
	}
	
	public void set(int count)	{
		this.count = count;
	}
	
	/*
	 * Getters and Setters
	 */
	
	public int getCount()	{
		return this.count;
	}
	
}