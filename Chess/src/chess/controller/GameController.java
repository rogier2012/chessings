package chess.controller;

import chess.model.*;
import chess.model.moves.*;
import chess.model.players.*;

public class GameController {
	
	public void play(Game game){
		boolean doorgaan = true;
		Move nextMove = null;
		boolean isComputer;
		boolean isHuman;
		boolean playerDidValidMove;
		Player currentPlayer;
		
		game.getBoardController().reset(game.getBoard());
		while (doorgaan){
			playerDidValidMove = false;
			
			
			currentPlayer = game.getPlayers()[game.getCurrent()];
			isComputer = (currentPlayer instanceof ComputerPlayer);
			isHuman = (currentPlayer instanceof HumanPlayer);
			
			if (isComputer)	{
				nextMove = game.getComputerPlayerController().determineMove(game.getBoard(), (ComputerPlayer) currentPlayer);
			}
			else if (isHuman)	{
				nextMove = game.getHumanPlayerController().determineMove(game.getBoard(), (HumanPlayer) currentPlayer);
			}
			executeMove(game, game.getBoard(), nextMove);
			
			System.out.println(game.getBoardView().toString(game.getBoard()));
			
			
			while (!playerDidValidMove)	{
				
			}
			
			
			doorgaan = !gameOver(game);
		}
	}
	
	public void executeMove(Game game, Board board, Move move)	{
		game.getBoardController().executeMove(move, board);
	}
	
	public boolean gameOver(Game game)	{
		
		
		return false;
	}
	
	
}
