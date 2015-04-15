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
		word = phrases[i].toUpperCase();
		hidden = new char[word.length()];
	}

	
	public String getPhrase(){return word;}
	public String getHidden(){return new String(hidden);}
	
	public String setHidden(){
		for(int i=0; i < word.length(); i++)
			hidden[i] = '_';
		String s = new String(hidden);
		return s;

	}
	
	//sets hidden to the word
	public String setHidden(String s){return word;}
	
	public String setPhrase(){
		int i = rand.nextInt(phrases.length);
		word = phrases[i].toUpperCase();
		return word;
	}


	public boolean guessLetter(char x){
		int preLoop=hiddenCheck(), postLoop; 
		for(int i = 0; i < word.length(); i++)
			if(x == word.charAt(i))
				hidden[i] = word.charAt(i);
		postLoop=hiddenCheck();

		return postLoop != preLoop;
	}
		
	
	public boolean guessPhrase(String s){
		if(s.equals(word)){
			hidden.equals(word.toCharArray());
			return true;
		}
		
		else
			return false;
	}
	
	public int numChar(char c){
		int n=0;
		for(int i=0; i<word.length(); i++){
			if(c==word.charAt(i))
				n++;
		}
		return n;
	}
	
	public int hiddenCheck(){
		int n=0;
		for(int i=0; i<hidden.length; i++){
			if('_'==hidden[i])
				n++;
		}
		return n;
	}

}