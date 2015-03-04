package chess;

public class ComputerPlayer extends Player {
	
	private String name;
	
	private Strategy strategy;
	private Color color;
	
	public ComputerPlayer(String aName, Color aColor, Strategy aStrategy) {
		super(aName, aColor);
		this.name = aStrategy + "-" + aColor;
		this.color = aColor;
		this.strategy = aStrategy;
	}
	
	
	@Override
	public int determineMove(Board board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void makeMove(Board board) {
		// TODO Auto-generated method stub
		
	}

	
	/*
	 * Getters and Setters
	 */

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Strategy getStrategy() {
		return strategy;
	}


	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}
	
	
	
	
}
