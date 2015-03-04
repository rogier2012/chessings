package chess;

public enum Color {
	WHITE, BLACK;

	public Color other() {
		return this == WHITE ? BLACK : WHITE;
	}

	public String toString() {
		String toReturn;
		if (this.equals(WHITE)) {
			toReturn = "| W";
		} else if (this.equals(BLACK)) {
			toReturn = "| B";
		} else {
			toReturn = "Unknown!";
		}

		return toReturn;
	}
}
