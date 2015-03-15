package chess;

import java.io.*;
import chess.model.*;

public class InputForMove {
	
	public static void main(String[] args) {
		InputForMove input = new InputForMove();
		Position[] positionschange = input.input();
		System.out.println(positionschange[0]);
		System.out.println(positionschange[1]);
	}
	
	public Position[] input(){
		Position[] move = new Position[2];
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			input = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		move[0] = convert(separateMove(input, 0));
		move[1] = convert(separateMove(input, 1));
		return move;
	}
	
	public String separateMove(String input, int index){
		String[] full = input.split(" ");
		return full[index];
	}
	
	public Position convert(String input){
		InputTable table = new InputTable();
		int[] position = table.getInt(input.toLowerCase());
		return new Position(position[0],position[1]);
	}
}
