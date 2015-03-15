package chess.controller;

import chess.model.*;

public class GameController {
	
	public void play(Game game){
		boolean doorgaan = true;
		game.getBoardController().reset(game.getBoard());
		while (doorgaan){
			game.getPlayers()[game.getCurrent()].makeMove(game.getBoard());
		}
	}
	
}
