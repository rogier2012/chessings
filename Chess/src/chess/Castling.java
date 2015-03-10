package chess;

public class Castling extends Move {

	private boolean isShort;
	
	public Castling(Position initialPoint, Position endPoint, boolean isShort) {
		super(initialPoint, endPoint);
		this.isShort = isShort;
	}
}
