package chess.controller;

import chess.model.*;
import chess.model.moves.*;
import chess.model.players.*;
import chess.view.BoardView;

public class GameController {
	
	public void play(Game game){
		// Temporary variables
		boolean doorgaan = true;
		Move nextMove = null;
		boolean isComputer;
		boolean isHuman;
		boolean playerDidValidMove;
		Player currentPlayer;
		// Set up board before playing
		game.getBoardController().reset(game.getBoard());
		while (doorgaan){
			// Show current board state
			System.out.println(game.getBoardView().toString(game.getBoard()));
			// Player has not done a move yet
			playerDidValidMove = false;
			// Get the player that has to do a move
			currentPlayer = game.getPlayers()[game.getCurrent()];
			// Is the player a computer?
			isComputer = (currentPlayer instanceof ComputerPlayer);
			// Is the player a human?
			isHuman = (currentPlayer instanceof HumanPlayer);
			// Continue asking the player for a move until we receive a valid one
			while (!playerDidValidMove)	{
				// Request a move from the player
				if (isComputer)	{
					nextMove = game.getComputerPlayerController().determineMove(game.getBoard(), (ComputerPlayer) currentPlayer);
				}
				else if (isHuman)	{
					nextMove = game.getHumanPlayerController().determineMove(game.getBoard(), (HumanPlayer) currentPlayer);
				}
				// Check if the move is valid
				playerDidValidMove = game.isValidMove(nextMove);
			}
			// Execute the valid move
			executeMove(game, nextMove);
			// Check if we should continue the game
			doorgaan = !game.gameOver(game);
		}
	}
	
	/*
	 * Execute the move
	 */
	public void executeMove(Game game, Move move)	{
		game.getBoardController().executeMove(move, game.getBoard());
	}
	
}
