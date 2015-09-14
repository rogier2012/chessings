package game;

import game.checkcheck.CheckCheck;
import game.fiftymoverule.FiftyMoveRuleCheck;
import game.history.GameHistory;
import game.materialchecker.MaterialChecker;
import game.movecounter.MoveCounter;
import game.movegenerator.MoveGenerator;
import game.moveoptionmapping.MoveMapping;
import game.promotioncheck.PromotionCheck;
import game.promotioncheck.StandardPromotionCheck;
import game.repetitionchecker.RepetitionChecker;

import java.util.List;

import moves.Move;
import players.Player;
import players.playerinput.input.MoveInput;
import players.playerinput.input.RemiseInput;
import players.playerinput.input.ResignationInput;
import players.playerinput.input.TurnInput;
import view.TUI;
import view.View;
import board.ChessBoard;

public class StandardGame implements Game {
	
	/*
	 * Constants
	 */
	
	private static final String remiseMessage = "Remise!";
	private static final String checkmateMessage = "You are in checkmate!";
	private static final String resignationMessage = "Opponent resigned! You win!";
	private static final String stalemateMessage = "Stalemate!";
	private static final String rejectionMessage = "Opponent did not agree on remise!";
	private static final String winMessage = " wins!";
	
	/*
	 * Instance Variables
	 */
	
	private ChessBoard board;
	private Player[] players;
	
	private FiftyMoveRuleCheck fiftyMoveRule;
	private GameHistory history;
	private MaterialChecker materialChecker;
	private MoveCounter moveCounter;
	private MoveGenerator moveGenerator;
	private CheckCheck checkCheck;
	private PromotionCheck promotionCheck;
	private MoveMapping moveOptionMapping;
	private RepetitionChecker repetitionChecker;
	private View view;
	
	public StandardGame(Player one, Player two)	{
		// TODO
		
		
		
		this.promotionCheck = new StandardPromotionCheck(this);
		
		this.view = new TUI(this.board);
	}
	
	@Override
	public Game copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Game outcome(Move move) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getCurrentPlayer() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Player getWaitingPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChessBoard getBoard() {
		return this.board;
	}

	@Override
	public Player[] getPlayers() {
		return this.players;
	}
	
	@Override
	public GameHistory getHistory()	{
		return this.history;
	}
	
	@Override
	public int getMoveIndex()	{
		return this.moveCounter.getCount();
	}

	@Override
	public void play() {
		this.board.reset();																		/* Reset board							 */
		this.history.addBoard(board.deepCopy());												/* Add first board to history			 */
		boolean continueGame = true;
		while (continueGame)	{
			Player currentPlayer = this.getCurrentPlayer();										/* Get current player					 */
			this.view.showBoard(currentPlayer.getColor());										/* Show current board					 */
			List<Move> movePossibilities = this.moveGenerator.getValidMoves();				/* Determine all possible moves			 */
			
			if (movePossibilities.size() == 0)	{												/* If there are no possible moves:		 */
				if (this.checkCheck.isKingInCheck(currentPlayer.getColor()))	{				/* 		and the king is in check		 */
					this.view.display(checkmateMessage);										/* 			Check mate!					 */
					this.view.display(this.getWaitingPlayer().getName() + winMessage);			/* 			Display winning player		 */
					continueGame = false;														/* 			Stop the game				 */
					
				} else {																		/* 		and the king is not in check	 */
					this.view.display(stalemateMessage);										/* 			Stalemate!					 */
					continueGame = false;														/* 			Stop the game				 */
				}
			} else {																			/* If there are possible moves:			 */
				
				TurnInput turnDecision = currentPlayer.determineMove(movePossibilities, this);	/* Ask the player what to do			 */
				
				if (turnDecision instanceof ResignationInput)	{								/* If the player chose to resign:		 */
					this.view.display(resignationMessage);										/* Display resignation					 */
					continueGame = false;														/* Stop the game						 */
					
				} else if (turnDecision instanceof RemiseInput)	{								/* If the player requests remise:		 */
					boolean remise = this.getWaitingPlayer().remise(this).isAccepted();			/* Get opponent's response				 */
					if (remise)	{																/* If the opponent agreed:				 */
						this.view.display(remiseMessage);										/* Display remise						 */
						continueGame = false;													/* Stop the game						 */
					} else {																	/* If the opponent rejected:			 */
						view.display(rejectionMessage);											/* Display rejection					 */
					}
				} else if (turnDecision instanceof MoveInput)	{								/* If the player chose to make a move	 */
					Move nextMove = ((MoveInput) turnDecision).getMove();						/* Get the move							 */
					this.moveOptionMapping.update(nextMove);									/* Update move options for future turns	 */
					this.executeMove();															/* Execute the move						 */
					this.promotionCheck.promotionCheck(nextMove, currentPlayer);				/* Check for pawn promotion				 */
					this.nextPlayer();															/* Switch players						 */
				}
			}
			if (!this.materialChecker.sufficientMaterial())	{									/* If there are not enough pieces left	 */
				this.view.showBoard(currentPlayer.getColor());									/* Show final board						 */
				this.view.display(remiseMessage);												/* Display remise						 */
				continueGame = false;															/* Stop the game						 */
			}
		}
	}
	
	/*
	 * Help Methods
	 */
	
	private void nextPlayer()	{
		// TODO
	}
	
	private void executeMove()	{
		// TODO
	}
	
	
	
}
