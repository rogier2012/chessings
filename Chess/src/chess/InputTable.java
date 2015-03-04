package chess;

import java.util.HashMap;

public class InputTable {
	public HashMap<Integer, Integer> ranks;
	public HashMap<String, Integer> files;
	
	public InputTable(){
		ranks = new HashMap<Integer, Integer>();
		files = new HashMap<String, Integer>();
		this.fillRanks();
		this.fillFiles();
	}
	
	public void fillRanks(){
		for (int i = 0; i < Board.RANKS; i++){
			ranks.put(Board.RANKS-i, i);
		}
	}
	
	public void fillFiles(){
		files.put("a", 0);
		files.put("b", 1);
		files.put("c", 2);
		files.put("d", 3);
		files.put("e", 4);
		files.put("f", 5);
		files.put("f", 6);
		files.put("g", 7);
	}
	
	public int[] getInt(String position){
		String[] separate = position.split("");
		int[] result = new int[2];
		result[0] = ranks.get(Integer.parseInt(separate[1]));
		result[1] = files.get(separate[0]);
		return result;
	}
}
