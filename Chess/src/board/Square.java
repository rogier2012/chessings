package board;

import enums.Color;

public class Square {
	
	/*
	 * Instance variables
	 */
	
	private int rank;
	private int file;
	
	/*
	 * Constructors
	 */
	
	public Square(int rank, int file){
		this.rank = rank;
		this.file = file;
	}
	
	/*
	 * Queries
	 */
	
	public String toString(){
		return ("(" + rank + ", " + file + ")");
	}
	
	public Square deepCopy()	{
		Square copy;
		copy = new Square(this.getRank(), this.getFile());
		return copy;
	}
	
	public boolean isEqual(Square position)	{
		return (this.rank == position.getRank() && this.file == position.getFile());
	}
	
	public boolean isEqual(int rank, int file)	{
		return(rank == this.rank && file == this.file);
	}
	
	public Color getColor()	{
		return (((this.rank + this.file)%2) == 1)? Color.WHITE:Color.BLACK;
	}
	
	/*
	 * Getters and Setters
	 */
	
	public int getRank() {
		return rank;
	}
	
	public int getFile() {
		return file;
	}
	
}
