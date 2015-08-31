package moves;

import board.Square;

public class MoveSuggestion {
	
	/*
	 * Instance Variables
	 */
	
	private Square origin;
	private Square destination;
	
	/*
	 * Constructors
	 */
	
	public MoveSuggestion(Square origin, Square destination)	{
		this.origin = origin;
		this.destination = destination;
	}
	
	/*
	 * Queries
	 */
	
	public String toString()	{
		return "Suggestion: " + this.getOrigin() + " to " + this.getDestination();
	}
	
	/*
	 * Getters and Setters
	 */
	
	public Square getOrigin() {
		return origin;
	}

	public Square getDestination() {
		return destination;
	}
	
}