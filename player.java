import java.util.ArrayList;

/*This is the Player class. It is used to represent the three players in the game, their winnings,
 * as well as their actions on their turns.
 */
public class Player {
	private int winnings;		//the player's winnings of the current round
	private int bankedWinnings;	//the player's winnings of the past rounds
	private String name;		//the player's name
	
	public Player(String s)
	{
		name = s;
		winnings = 0;
		bankedWinnings = 0;
	}
	
	//standard get/set methods for attributes
	public int getWinnings()
	{
		return winnings;
	}
	public int getBankedWinnings()
	{
		return bankedWinnings;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String s)
	{
		name = s;
	}
	
	//methods to add onto the current winnings and bankedWinnings variables
	public void addToWinnings(int n)
	{
		winnings += n;
	}
	public void addToBanked(int n)
	{
		bankedWinnings += n;
	}
	
	
	//methods used for guessing letters
	public boolean guessLetter(String c)
	{
		if(board.message.contains(c))
			return true;
		else
			return false;
	}
	public boolean buyVowel(String c)
	{
		if(guessLetter(c))
		{
			winnings-=250;
			return true;
		}
		else
			return false;
	}
	
	public boolean guessPhrase(String s)
	{
		ArrayList<String> guess = new ArrayList<String>();
		for(int i=0;i<s.length();i++)
		{
			guess.set(i, s.charAt(i)+"");
		}
		if (guess.equals(board.message))
			return true;
		else
			return false;
	}
	
	
}
