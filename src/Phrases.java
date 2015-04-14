import java.util.Random;
public class Phrases {

	private Random rand = new Random();
	private String word;
	private String [] phrases = {"Grandma Olive Oil", "Afghan Hound", "Aloe Vera Plant",
			"Ants In Your Pants", "Clark Kent", "Brock", "Ordering Pizza Online", 
			"Star Wars Action Figures", "Piers Anthony", "Patrons Of The Arts",
			"Great Sand Dunes National Park", "White Bean Chili", "Hollywood Squares", "Gunsmoke",
			"United States Supreme Court", "French Canning Jars"};
	private char[] hidden;
	
	public Phrases(){
		int i = rand.nextInt(phrases.length);
		word = phrases[i];
		hidden = new char[word.length()];
	}
	
	public String getPhrase(){
		String phrase = new String(hidden);
		return phrase;
	}
	
	public void convertToHidden(){
		for(int j=0; j < word.length(); j++){
			if(word.charAt(j) == ' ')
				hidden[j] = ' ';
			else
				hidden[j] = '_';
		}
	}
	
	public void guess(char x){
		for(int i = 0; i < word.length(); i++){
			if(x == word.charAt(i))
				hidden[i] = word.charAt(i);
		}
	}

}
