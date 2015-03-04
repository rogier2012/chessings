package chess;

public abstract class Player {
	
	/*
	 * Instance variables
	 */
	
	private String name;
	private Color color;
	
	/*
	 * Constructors
	 */
	
	public Player(String aName, Color aColor)	{
		this.name = aName;
		this.color = aColor;
	}
	
	/*
	 * Queries
	 */
	
    public abstract int determineMove(Board board);
	
	/*
	 * Commands
	 */
    
    public abstract void makeMove(Board board);
	
	/*
	 * Getters and Setters
	 */
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
