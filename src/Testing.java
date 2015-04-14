import java.util.Random;
public class Testing {

	public static void main(String[] args) {
	
		Random rand = new Random();
		
		String [] phrases = {"Grandma Olive Oil", "Afghan Hound", "Aloe Vera Plant",
				"Ants In Your Pants", "Clark Kent", "Brock", "Ordering Pizza Online", 
				"Star Wars Action Figures", "Piers Anthony", "Patrons Of The Arts",
				"Great Sand Dunes National Park", "White Bean Chili", "Hollywood Squares", "Gunsmoke",
				"United States Supreme Court", "French Canning Jars"};
		int i = rand.nextInt(phrases.length);
		String word = phrases[i];
		char [] hidden = new char[word.length()];
		
		System.out.println(word);
		
		for(int j=0; j < word.length(); j++){
			if(word.charAt(j) == ' ')
				hidden[j] = ' ';
			else
				hidden[j] = '_';
		}
		
		
		String s = new String(hidden);
		System.out.println(s);
		
	}

}
