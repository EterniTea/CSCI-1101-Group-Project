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

	public String getPhrase(){return word;}
	public String getHidden(){
<<<<<<< HEAD
		for(int i=0; i < word.length()*2; i++){
			if(i%2==1)
				hidden[i] = ' ';
			else
				hidden[i] = '_';
		}
		
		String s = new String(hidden);
		return s;

		}
	
=======
		for(int i=0; i < word.length(); i++){
			hidden[i] = '_';
			hidden[i+1] = ' ';
		}
		String s = new String(hidden);
		return s;

	}

>>>>>>> origin/master
	public void guess(char x){
		for(int i = 0; i < word.length(); i++){
			if(x == word.charAt(i))
				hidden[i] = word.charAt(i);
		}
	}

}