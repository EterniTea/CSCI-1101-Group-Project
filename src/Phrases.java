import java.util.Random;
public class Phrases {

	private Random rand = new Random();
	private String word;
	private String [] phrases = {"Pikachu", "Charmander", "Bulbasaur", "Squirtle", "Chikorita",
			"Cyndaquil", "Totodile", "Treecko", "Torchic", "Mudkip", "Turtwig", "Chimchar", 
			"Piplup", "Snivy", "Tepig", "Oshawott", "Chespin", "Fennekin", "Froakie"};
	private char[] hidden;
	
	public Phrases(){
		int i = rand.nextInt(phrases.length);
		word = phrases[i];
		hidden = new char[word.length()];
	}
	
//	public String getHidden(){String h = hidden.toString(); return h;}
	public String getPhrase(){return word;}
	
	public String getHidden(){
		for(int i=0; i < word.length(); i++)
			hidden[i] = '_';
	
		return hidden.toString();
		
	}
	
	public void guess(char x){
		for(int i = 0; i < word.length(); i++){
			if(x == word.charAt(i))
				hidden[i] = word.charAt(i);
		}
	}

}