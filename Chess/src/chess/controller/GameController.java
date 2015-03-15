package chess.controller;

import chess.model.*;

public class GameController {
	
	public void play(Game game){
		boolean doorgaan = true;
		game.getBoardController().reset(game.getBoard());
		while (doorgaan){
			game.getPlayerController().makeMove(game.getPlayers()[game.getCurrent()], game.getBoard());
		}
	}
	
}
