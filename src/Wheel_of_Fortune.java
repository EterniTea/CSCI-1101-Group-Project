import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Wheel_of_Fortune {

	public static void main(String[] args) {
		//sound
		PopUp pop = new PopUp();

		//initialize variables
		int round = 1;
		String name1="", name2="", name3="";

		//initialize frames
		JFrame start = new JFrame ("New Game");
		JFrame game = new JFrame ("Wheel of Fortune - Round " + round);
		JFrame vowel = new JFrame ("Buy a Vowel");
		JFrame letter = new JFrame ("Guess a Letter");
		JFrame phrase = new JFrame ("Guess the Phrase");

		//start the game
		GameStart startP = new GameStart();	//initialize panel
		start.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		start.getContentPane().add(startP);
		start.pack();
		start.setVisible (true);
		
		//while loop to keep window visible until the event of the panel is "event"
		while(start.isVisible()){
			if(!startP.getEvent().equals("start"))
				start.setVisible (true);
			else{
				name1 = startP.getPlayer1();
				name2 = startP.getPlayer2();
				name3 = startP.getPlayer3();
				start.setVisible(false);	//hides the gamestart window
			}
			
		}
		
		//main frame for the game
		MainPanel gameP = new MainPanel(name1, name2, name3, round);
		game.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		game.getContentPane().add(gameP);
		game.pack();
		game.setVisible(false);

		for(;round<=4;round++){
			
			game.setTitle("Wheel of Fortune - Round " + round);	//change title according to the round
			//create new instances for Guess frames but make them invisible
		
			//GuessLetter frame
			GuessLetter letterP = new GuessLetter();
			letter.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
			letter.getContentPane().add(letterP);
			letter.pack();
			letter.setVisible(false);

			//BuyVowel frame
			BuyVowel vowelP = new BuyVowel();
			vowel.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
			vowel.getContentPane().add(vowelP);
			vowel.pack();
			vowel.setVisible(false);

			//GuessPhrase frame
			GuessPhrase phraseP = new GuessPhrase();
			phrase.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
			phrase.getContentPane().add(phraseP);
			phrase.pack();
			phrase.setVisible(false);
		
			JOptionPane.showMessageDialog(null, "Round "+round);
			pop.play();
			game.setVisible(true);
			
			int i=0; //for testing purposes
			while(i<5){	//keeps game going as long as phrase isnt guessed (this is just a place holder for testing)/////////////////////////////////////////////////////////
				
				while(game.isEnabled()){
					
					//check for the event in game panel is
					if(gameP.getEvent().equals("letter")){
						game.setEnabled(false);
						i=showFrame(letter, letterP, gameP, i);////////////////////////////////////////////////////////////////////////////////////////////////////////
					}
					
					else if(gameP.getEvent().equals("vowel")){
						game.setEnabled(false);
						i=showFrame(vowel, vowelP, gameP, i);//////////////////////////////////////////////////////////////////////////////////////////////////////
					}

					else if(gameP.getEvent().equals("phrase")){
						game.setEnabled(false);
						i=showFrame(phrase, phraseP, gameP, i);/////////////////////////////////////////////////////////////////////////////////////////////////////
					}	
					
				}	//end of while enabled
				
				game.setEnabled(true);	
				
				i++;	//testing purposes////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
			}	//end of while loop
			
			//close the guessing windows for the round

		}	//end of for loop
	
	
	}	//end of main
	
	//method to open and get results from the guessing windows
	public static int showFrame(JFrame f, GuessPanel p, MainPanel g, int i){	//i is for testing purposes////////////////////////////////////////////////////////
		f.setVisible(true);
		while(f.isVisible()){
			if(g.getEvent().equals("guess")){
				g.playerRotate();
				g.resetEvent();
				p.resetEvent();
				f.setVisible(false);
			}
		
			else if(g.getEvent().equals("cancel")){
				g.buttonsON();
				g.resetEvent();
				p.resetEvent();
				f.setVisible(false);
				
				i--;	///testing purposes//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			}
			
		}
		
		return i;
	}
	
}



























