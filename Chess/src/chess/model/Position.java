package chess.model;

public class Position {
	
	private int rank;
	private int file;
	
	public Position(int rank, int file){
		this.rank = rank;
		this.file = file;
	}
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getFile() {
		return file;
	}
	public void setFile(int file) {
		this.file = file;
	}
	
	public String toString(){
		return ("(" + rank + ", " + file + ")");
	}
}
