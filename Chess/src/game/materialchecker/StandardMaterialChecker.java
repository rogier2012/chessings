package game.materialchecker;

import java.util.ArrayList;

import pieces.Bishop;
import pieces.ChessPiece;
import pieces.King;
import pieces.Knight;
import board.ChessBoard;
import enums.Color;

public class StandardMaterialChecker implements MaterialChecker {
	
	private ChessBoard board;
	
	public StandardMaterialChecker(ChessBoard board)	{
		this.board = board;
	}
	
	@Override
	public boolean sufficientMaterial() {
		boolean result = false;
		
		
		
		
		
		
//		ArrayList<ChessPiece> whitePieces = this.board.getAllChessPiecesOf(Color.WHITE);
//		ArrayList<ChessPiece> blackPieces = this.board.getAllChessPiecesOf(Color.BLACK);
//		
//		if (whitePieces.size() < 3 && blackPieces.size() < 3)	{
//			King whiteKing = this.board.getKing(Color.WHITE);
//			King blackKing = this.board.getKing(Color.BLACK);
//			ChessPiece whitePiece = null;
//			ChessPiece blackPiece = null;
//			for (ChessPiece piece : whitePieces)	{
//				if (piece != whiteKing)	{
//					whitePiece = piece;
//				}
//			}
//			for (ChessPiece piece : blackPieces)	{
//				if (piece != blackKing)	{
//					blackPiece = piece;
//				}
//			}
//			if (whitePiece == null)	{
//				if (blackPiece == null || blackPiece instanceof Knight || blackPiece instanceof Bishop)	{
//					result = true;
//				}
//			}
//			if (blackPiece == null)	{
//				if (whitePiece == null || whitePiece instanceof Knight || whitePiece instanceof Bishop)	{
//					result = true;
//				}
//			}
//			if (whitePiece instanceof Bishop && blackPiece instanceof Bishop)	{
//				if (whitePiece.getPosition().getColor() == blackPiece.getPosition().getColor())	{
//					result = true;
//				}
//			}
//		}
		return result;
	}
	
	
	
}
