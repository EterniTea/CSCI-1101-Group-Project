import java.util.ArrayList;

/*This class represents the board of the game, and holds the message that the players try
 * to guess. 
 */
public class board {
	static ArrayList<String> message;
	
	public board(){}
	public board(ArrayList<String> m)
	{
		for(int i=0;i<m.size();i++)
		{
			message.set(i, m.get(i));
		}
	}
	
	//get and set methods
	public ArrayList<String> getMessage()
	{
		return message;
	}
	public void setMessage(ArrayList<String> m)
	{
		for(int i=0;i<m.size();i++)
		{
			message.set(i, m.get(i));
		}
	}
	
	
	
}
