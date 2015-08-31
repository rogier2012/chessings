package players.playerinput.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A request to a player for input
 * @author Ron
 *
 */
public abstract class InputRequest {
	
	private String answer;
	
	public InputRequest()	{
		this.ask();
	}
	
	public void ask()	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(this.answer == null || !valid())	{
			System.out.println(this.message());
			try {
				answer = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getAnswer()	{
		return this.answer;
	}
	
	public abstract String message();
	
	public abstract boolean valid();
	
}
