package game.moveoptionmapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import moveoptions.Castling;
import moveoptions.CastlingLong;
import moveoptions.CastlingShort;
import moveoptions.MoveOption;
import moveoptions.PawnCapture;
import moveoptions.PawnEnPassant;
import moveoptions.PawnForwardDouble;
import moveoptions.PawnForwardSingle;
import moveoptions.StandardMoveOption;
import moves.CastleLong;
import moves.CastleShort;
import moves.ForwardDouble;
import moves.Move;
import pieces.Bishop;
import pieces.ChessPiece;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;
import board.ChessBoard;
import enums.Color;
import enums.Horizontal;

public class StandardMoveMapping implements MoveMapping {
	
	/*
	 * Constants
	 */
	
	/*
	 *  -- Range
	 */
	
	private static final int STEP = 1;
	private static final int LINE = Math.max(ChessBoard.RANKS, ChessBoard.FILES);
	
	/*
	 * -- Directions
	 */
	
	private static final int CONSTANT = 0;
	private static final int UP = 1;
	private static final int DOWN = -1;
	private static final int RIGHT = 1;
	private static final int LEFT = -1;
	
	/*
	 * -- Steps
	 */
	
	private static final MoveOption STEPUP = new StandardMoveOption(UP, CONSTANT, STEP);
	private static final MoveOption STEPDOWN = new StandardMoveOption(DOWN, CONSTANT, STEP);
	private static final MoveOption STEPRIGHT = new StandardMoveOption(CONSTANT, RIGHT, STEP);
	private static final MoveOption STEPLEFT = new StandardMoveOption(CONSTANT, LEFT, STEP);
	private static final MoveOption STEPUPPERRIGHT = new StandardMoveOption(UP, RIGHT, STEP);
	private static final MoveOption STEPUPPERLEFT = new StandardMoveOption(UP, LEFT, STEP);
	private static final MoveOption STEPLOWERRIGHT = new StandardMoveOption(DOWN, RIGHT, STEP);
	private static final MoveOption STEPLOWERLEFT = new StandardMoveOption(DOWN, LEFT, STEP);
	
	/*
	 * -- Lines
	 */
	
	private static final MoveOption LINEUP = new StandardMoveOption(UP, CONSTANT, LINE);
	private static final MoveOption LINEDOWN = new StandardMoveOption(DOWN, CONSTANT, LINE);
	private static final MoveOption LINERIGHT = new StandardMoveOption(CONSTANT, RIGHT, LINE);
	private static final MoveOption LINELEFT = new StandardMoveOption(CONSTANT, LEFT, LINE);
	private static final MoveOption LINEUPPERRIGHT = new StandardMoveOption(UP, RIGHT, LINE);
	private static final MoveOption LINEUPPERLEFT = new StandardMoveOption(UP, LEFT, LINE);
	private static final MoveOption LINELOWERRIGHT = new StandardMoveOption(DOWN, RIGHT, LINE);
	private static final MoveOption LINELOWERLEFT = new StandardMoveOption(DOWN, LEFT, LINE);
	
	/*
	 * -- Castling
	 */
	
	private static final CastlingLong WHITELONGCASTLE = new CastlingLong(Color.WHITE);
	private static final CastlingShort WHITESHORTCASTLE = new CastlingShort(Color.WHITE);
	private static final CastlingLong BLACKLONGCASTLE = new CastlingLong(Color.BLACK);
	private static final CastlingShort BLACKSHORTCASTLE = new CastlingShort(Color.BLACK);
	
	/*
	 * -- Pawn Forward
	 */
	
	private static final PawnForwardSingle WHITEPAWNSINGLEFORWARD = new PawnForwardSingle(Color.WHITE);
	private static final PawnForwardSingle BLACKPAWNSINGLEFORWARD = new PawnForwardSingle(Color.BLACK);
	private static final PawnForwardDouble WHITEPAWNDOUBLEFORWARD = new PawnForwardDouble(Color.WHITE);
	private static final PawnForwardDouble BLACKPAWNDOUBLEFORWARD = new PawnForwardDouble(Color.BLACK);
	
	/*
	 * -- Pawn Capturing
	 */
	
	private static final PawnCapture WHITERIGHTPAWNCAPTURE = new PawnCapture(Horizontal.RIGHT, Color.WHITE);
	private static final PawnCapture WHITELEFTPAWNCAPTURE = new PawnCapture(Horizontal.LEFT, Color.WHITE);
	private static final PawnCapture BLACKRIGHTPAWNCAPTURE = new PawnCapture(Horizontal.RIGHT, Color.BLACK);
	private static final PawnCapture BLACKLEFTPAWNCAPTURE = new PawnCapture(Horizontal.LEFT, Color.BLACK);
	
	private static HashSet<MoveOption> whitePawnCapture = new HashSet<MoveOption>();
	static {
		whitePawnCapture.add(WHITERIGHTPAWNCAPTURE);
		whitePawnCapture.add(WHITELEFTPAWNCAPTURE);
	}
	private static HashSet<MoveOption> blackPawnCapture = new HashSet<MoveOption>();
	static {
		blackPawnCapture.add(BLACKRIGHTPAWNCAPTURE);
		blackPawnCapture.add(BLACKLEFTPAWNCAPTURE);
	}
	
	/*
	 * -- En Passant
	 */
	
	private static final PawnEnPassant WHITERIGHTENPASSANT = new PawnEnPassant(Horizontal.RIGHT, Color.WHITE);
	private static final PawnEnPassant WHITELEFTENPASSANT = new PawnEnPassant(Horizontal.LEFT, Color.WHITE);
	private static final PawnEnPassant BLACKRIGHTENPASSANT = new PawnEnPassant(Horizontal.RIGHT, Color.BLACK);
	private static final PawnEnPassant BLACKLEFTENPASSANT = new PawnEnPassant(Horizontal.LEFT, Color.BLACK);
	
	private static HashSet<MoveOption> whiteEnPassant = new HashSet<MoveOption>();
	static {
		whiteEnPassant.add(WHITERIGHTENPASSANT);
		whiteEnPassant.add(WHITELEFTENPASSANT);
	}
	
	private static HashSet<MoveOption> blackEnPassant = new HashSet<MoveOption>();
	static {
		blackEnPassant.add(BLACKRIGHTENPASSANT);
		blackEnPassant.add(BLACKLEFTENPASSANT);
	}
	
	/*
	 * -- Movement
	 */
	
	private static HashSet<MoveOption> horizontalSteps = new HashSet<MoveOption>();
	static {
		horizontalSteps.add(STEPRIGHT);
		horizontalSteps.add(STEPLEFT);
	}
	private static HashSet<MoveOption> verticalSteps = new HashSet<MoveOption>();
	static {
		verticalSteps.add(STEPUP);
		verticalSteps.add(STEPDOWN);
	}
	private static HashSet<MoveOption> diagonalSteps = new HashSet<MoveOption>();
	static {
		diagonalSteps.add(STEPUPPERRIGHT);
		diagonalSteps.add(STEPUPPERLEFT);
		diagonalSteps.add(STEPLOWERRIGHT);
		diagonalSteps.add(STEPLOWERLEFT);
	}
	
	private static HashSet<MoveOption> horizontalLines = new HashSet<MoveOption>();
	static {
		horizontalLines.add(LINERIGHT);
		horizontalLines.add(LINELEFT);
	}
	private static HashSet<MoveOption> verticalLines = new HashSet<MoveOption>();
	static {
		verticalLines.add(LINEUP);
		verticalLines.add(LINEDOWN);
	}
	private static HashSet<MoveOption> diagonalLines = new HashSet<MoveOption>();
	static {
		diagonalLines.add(LINEUPPERRIGHT);
		diagonalLines.add(LINEUPPERLEFT);
		diagonalLines.add(LINELOWERRIGHT);
		diagonalLines.add(LINELOWERLEFT);
	}
	
	/*
	 * -- Static King MoveOptions
	 */
	
	private static HashSet<MoveOption> staticKingOptions = new HashSet<MoveOption>();
	static {
		staticKingOptions.addAll(horizontalSteps);
		staticKingOptions.addAll(verticalSteps);
		staticKingOptions.addAll(diagonalSteps);
	}
	
	/*
	 *-- Static Queen MoveOptions
	 */
	
	private static HashSet<MoveOption> staticQueenOptions = new HashSet<MoveOption>();
	static {
		staticQueenOptions.addAll(horizontalLines);
		staticQueenOptions.addAll(verticalLines);
		staticQueenOptions.addAll(diagonalLines);
	}
	
	/*
	 * -- Static Bishop MoveOptions
	 */
	
	private static HashSet<MoveOption> staticBishopOptions = new HashSet<MoveOption>();
	static {
		staticBishopOptions.addAll(diagonalLines);
	}
	
	/*
	 * -- Static Knight MoveOptions
	 */
	
	private static HashSet<MoveOption> staticKnightOptions = new HashSet<MoveOption>();
	static {
		staticKnightOptions.add(new StandardMoveOption(1, 2, STEP));
		staticKnightOptions.add(new StandardMoveOption(2, 1, STEP));
		staticKnightOptions.add(new StandardMoveOption(-1, 2, STEP));
		staticKnightOptions.add(new StandardMoveOption(2, -1, STEP));
		staticKnightOptions.add(new StandardMoveOption(1, -2, STEP));
		staticKnightOptions.add(new StandardMoveOption(-2, 1, STEP));
		staticKnightOptions.add(new StandardMoveOption(-1, -2, STEP));
		staticKnightOptions.add(new StandardMoveOption(-2, -1, STEP));
		
	}
	
	/*
	 * -- Static Rook MoveOptions
	 */
	
	private static HashSet<MoveOption> staticRookOptions = new HashSet<MoveOption>();
	static {
		staticRookOptions.addAll(horizontalLines);
		staticRookOptions.addAll(verticalLines);
	}
	
	/*
	 * Instance Variables
	 */
	
	private ArrayList<ChessPiece> whitePieces;
	private ArrayList<ChessPiece> blackPieces;
	private ChessBoard board;
	
	private HashMap<ChessPiece, HashSet<MoveOption>> map;
	
	/*
	 * Constructors
	 */
	
	public StandardMoveMapping(ChessBoard board)	{
		
		this.board = board;
		this.map = new HashMap<ChessPiece, HashSet<MoveOption>>();
		
		this.reset();
	}
	
	/*
	 * Queries
	 */
	
	@Override
	public HashSet<MoveOption> getOptions(ChessPiece piece)	{
		return this.map.get(piece);
	}
	
	@Override
	public HashSet<MoveOption> getColorOptions(Color color)	{
		HashSet<MoveOption> result = new HashSet<MoveOption>();
		for (ChessPiece piece : this.board.getAllChessPiecesOf(color))	{
			result.addAll(this.map.get(piece));
		}
		return result;
	}
	
	@Override
	public HashSet<MoveOption> getAllOptions()	{
		HashSet<MoveOption> result = new HashSet<MoveOption>();
		for (ChessPiece piece : this.map.keySet())	{
			result.addAll(this.map.get(piece));
		}
		return result;
	}
	
	
	/*
	 * Commands
	 */
	
	/**
	 * IMPORTANT -- Method should be used before move is executed, but it must be inevitable that is executed!
	 */
	@Override
	public void update(Move move) {
		ChessPiece piece = this.board.getChessPiece(move.getOrigin());
		ChessPiece target = this.board.getChessPiece(move.getDestination());
		
		// Remove captured chess pieces
		if (target instanceof ChessPiece)	{
			if (target.getColor() == Color.WHITE)	{
				whitePieces.remove(target);
			} else {
				blackPieces.remove(target);
			}
		}
		
		// Remove disabled move options
		
		if (move instanceof ForwardDouble)	{
			this.removeDoubleForwardIn((Pawn) piece); 					/* Remove the ability to double forward again for this piece */
		} else if (move instanceof CastleLong)	{
			this.removeCastlingIn((King) piece);						/* Remove the ability to castle for this piece */
		} else if (move instanceof CastleShort)	{
			this.removeCastlingIn((King) piece);						/* Remove the ability to castle for this piece */
		} else if (piece instanceof Pawn)	{	
			this.removeDoubleForwardIn((Pawn) piece); 					/* Remove the ability to double forward for this piece */
		} else if (piece instanceof Rook)	{
			switch(piece.getColor())	{
			case WHITE:
				if (move.getOrigin().isEqual(ChessBoard.WHITEPIECERANK, ChessBoard.LEFTROOKFILE))	{
					this.removeShortCastlingIn(this.board.getKing(piece.getColor())); 			/* Remove the ability to do a short castle for this piece */
				} else if (move.getOrigin().isEqual(ChessBoard.WHITEPIECERANK, ChessBoard.RIGHTROOKFILE))	{
					this.removeLongCastlingIn(this.board.getKing(piece.getColor())); 			/* Remove the ability to do a long castle for this piece */
				}
				break;
			case BLACK:
				if (move.getOrigin().isEqual(ChessBoard.BLACKPIECERANK, ChessBoard.LEFTROOKFILE))	{
					this.removeShortCastlingIn(this.board.getKing(piece.getColor())); 			/* Remove the ability to do a short castle for this piece */
				} else if (move.getOrigin().isEqual(ChessBoard.BLACKPIECERANK, ChessBoard.RIGHTROOKFILE))	{
					this.removeLongCastlingIn(this.board.getKing(piece.getColor())); 			/* Remove the ability to do a long castle for this piece */
				}
			}
		} else if (piece instanceof King)	{
			this.removeCastlingIn((King) piece);												/* Remove the ability to castle for this piece */
		}
		
	}

	@Override
	public void reset() {
		this.whitePieces = board.getAllChessPiecesOf(Color.WHITE);
		this.blackPieces = board.getAllChessPiecesOf(Color.BLACK);
		// Clear map
		this.map.clear();
		// Map white pieces
		for (ChessPiece piece : this.whitePieces)	{
			HashSet<MoveOption> options = new HashSet<MoveOption>();
			if (piece instanceof Pawn)	{
				options.add(WHITEPAWNSINGLEFORWARD);
				options.add(WHITEPAWNDOUBLEFORWARD);
				options.addAll(whitePawnCapture);
				options.addAll(whiteEnPassant);
			} else if (piece instanceof King)	{
				options.addAll(staticKingOptions);
				options.add(WHITELONGCASTLE);
				options.add(WHITESHORTCASTLE);
			} else if (piece instanceof Queen)	{
				options.addAll(staticQueenOptions);
			} else if (piece instanceof Bishop)	{
				options.addAll(staticBishopOptions);
			} else if (piece instanceof Knight)	{
				options.addAll(staticKnightOptions);
			} else if (piece instanceof Rook)	{
				options.addAll(staticRookOptions);
			}
			this.map.put(piece, options);
		}
		
		// Map black pieces
		for (ChessPiece piece : this.blackPieces)	{
			HashSet<MoveOption> options = new HashSet<MoveOption>();
			if (piece instanceof Pawn)	{
				options.add(BLACKPAWNSINGLEFORWARD);
				options.add(BLACKPAWNDOUBLEFORWARD);
				options.addAll(blackPawnCapture);
				options.addAll(blackEnPassant);
			} else if (piece instanceof King)	{
				options.addAll(staticKingOptions);
				options.add(BLACKLONGCASTLE);
				options.add(BLACKSHORTCASTLE);
			} else if (piece instanceof Queen)	{
				options.addAll(staticQueenOptions);
			} else if (piece instanceof Bishop)	{
				options.addAll(staticBishopOptions);
			} else if (piece instanceof Knight)	{
				options.addAll(staticKnightOptions);
			} else if (piece instanceof Rook)	{
				options.addAll(staticRookOptions);
			}
			this.map.put(piece, options);
		}
		
	}
	
	/*
	 * Help methods
	 */
	
	private void removeDoubleForwardIn(Pawn pawn)	{
		HashSet<MoveOption> options = this.map.get(pawn);
		MoveOption toRemove = null;
		for (MoveOption option : options)	{
			if (option instanceof PawnForwardDouble)	{
				toRemove = option;
				break;
			}
		}
		options.remove(toRemove);
	}
	
	private void removeLongCastlingIn(King king)	{
		HashSet<MoveOption> options = this.map.get(king);
		MoveOption toRemove = null;
		for (MoveOption option : options)	{
			if (option instanceof CastlingLong)	{
				toRemove = option;
				break;
			}
		}
		options.remove(toRemove);
	}
	
	private void removeShortCastlingIn(King king)	{
		HashSet<MoveOption> options = this.map.get(king);
		MoveOption toRemove = null;
		for (MoveOption option : options)	{
			if (option instanceof CastlingShort)	{
				toRemove = option;
				break;
			}
		}
		options.remove(toRemove);
	}
	
	private void removeCastlingIn(King king)	{
		HashSet<MoveOption> options = this.map.get(king);
		MoveOption toRemove = null;
		for (MoveOption option : options)	{
			if (option instanceof Castling)	{
				toRemove = option;
				break;
			}
		}
		options.remove(toRemove);
	}

	
}
