package chess;

public class Game {
	
	/*
	 * Constants
	 */
	
	public static final int PLAYERAMOUNT = 2;
	
	/*
	 * Instance variables
	 */
	
	private Board board;
	
	private int current;
	
	private Player[] players;
	
	public Game(Player player1, Player player2){
		this.players = new Player[2];
		players[0] = player1;
		players[1] = player2;
		board = new Board();
	}
	
	
	public void play(){
		boolean doorgaan = true;
		board.reset();
		while (doorgaan){
			players[current].makeMove(board);
		}
	}
}
