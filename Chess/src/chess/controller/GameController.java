package chess.controller;

import chess.model.*;

public class GameController {
	
	public void play(Game game){
		boolean doorgaan = true;
		game.getBoard().reset();
		while (doorgaan){
			game.getPlayers()[current].makeMove(game.getBoard());
		}
	}
	
}
