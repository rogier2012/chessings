package enums;

public enum Horizontal {
	RIGHT, LEFT;
	
	public Horizontal opposite()	{
		return (this == RIGHT)? LEFT:RIGHT;
	}
	
	public int value()	{
		return (this == RIGHT)? 1:-1;
	}
	
}
