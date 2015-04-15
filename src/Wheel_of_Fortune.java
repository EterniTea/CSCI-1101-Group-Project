import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Wheel_of_Fortune {

	public static void main(String[] args) {
		//sound
		PopUp pop = new PopUp();
		
		//phrases
		Phrases phr = new Phrases();

		//initialize variables
		String name1="", name2="", name3="";

		//initialize frames
		JFrame start = new JFrame ("New Game");
		JFrame game = new JFrame ("Wheel of Fortune");
		JFrame vowel = new JFrame ("Buy a Vowel");
		JFrame letter = new JFrame ("Guess a Letter");
		JFrame phrase = new JFrame ("Guess the Phrase");

		//start the game
		GameStart startP = new GameStart();	//initialize panel
		start.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		start.getContentPane().add(startP);
		start.pack();
		start.setLocationRelativeTo(null);
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
		MainPanel gameP = new MainPanel(name1, name2, name3, phr);
		game.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		game.getContentPane().add(gameP);
		game.pack();
		game.setLocationRelativeTo(null);
		game.setVisible(false);
		
		//create frames for the guessing panels, but set invisible until necessary.
		
		//GuessLetter frame
		GuessLetter letterP = new GuessLetter();
		letter.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		letter.getContentPane().add(letterP);
		letter.pack();
		letter.setLocationRelativeTo(null);
		letter.setVisible(false);

		//BuyVowel frame
		BuyVowel vowelP = new BuyVowel();
		vowel.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		vowel.getContentPane().add(vowelP);
		vowel.pack();
		vowel.setLocationRelativeTo(null);
		vowel.setVisible(false);

		//GuessPhrase frame
		GuessPhrase phraseP = new GuessPhrase();
		phrase.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		phrase.getContentPane().add(phraseP);
		phrase.pack();
		phrase.setLocationRelativeTo(null);
		phrase.setVisible(false);

		//counts for 4 rounds
		for(int r=1;r<=2;r++){
			System.out.println(phr.getPhrase());
			game.setTitle("Wheel of Fortune - Round " + r);	//change title according to the round
			gameP.updateWheel(r);	//updating wheel in gameP
			JOptionPane.showMessageDialog(null, "Round "+r);	//shows current round
			pop.play();
			game.setVisible(true);
			
		
			while(!phr.getHidden().equals(phr.getPhrase())){	//keeps game going as long as phrase isnt guessed (this is just a place holder for testing)/////////////////////////////////////////////////////////
				
				while(game.isEnabled()){
					
					//check for the event in game panel is
					if(gameP.getEvent().equals("letter")){
						game.setEnabled(false);
						showFrame(letter, game, letterP, gameP, phr);
					}
					
					if(gameP.getEvent().equals("vowel")){
						game.setEnabled(false);
						gameP.getPlayer().addToWinnings(-250);
						showFrame(vowel, game, vowelP, gameP, phr);
					}

					if(gameP.getEvent().equals("phrase")){
						game.setEnabled(false);
						showFrame(phrase, game, phraseP, gameP, phr);
					}
					
					if(!gameP.getEvent().equals(""))
							game.toFront();
					
					gameP.updateMoney();
					gameP.updatePhrase();
					
				}	//end of while enabled
				
				game.setEnabled(true);
				gameP.resetEvent();
								
			}	//end of while loop
			
			//bank the players money and close the guessing windos in order to make new ones
			gameP.bankAll();
			phr.setPhrase();
			phr.setHidden();
			gameP.setNewPhrase(phr.getHidden());
			letterP.allEnabled();
			vowelP.allEnabled();

		}	//end of for loop
		
		game.setVisible(false);
		gameP.endGame();
		System.exit(0);
	
	}	//end of main
	
	//method to open and get results from the guessing windows
	public static void showFrame(JFrame frame, JFrame gameF, GuessPanel panel, MainPanel gameP, Phrases p){
		frame.setVisible(true);
		while(frame.isVisible()){
			if(panel.getEvent().equals("guess")){
				int win = gameP.getWin(), chars=0;
				String guess = panel.getGuess();
				Player player = gameP.getPlayer();
				
				//if guess is greater than 1 character then it must be guessing phrase
				if(guess.length()>1){
					chars=p.numChar('_');
					if(p.guessPhrase(guess)){
						if(win!=1000000)
							win*=chars;
						JOptionPane.showMessageDialog(null, "You just won $"+win+"!");
						player.addToWinnings(win);
					}
					else
						JOptionPane.showMessageDialog(null, guess+" is not the word");

				}

				//must be single char is guess length is not greater than 1
				else{
					chars=p.numChar(guess.charAt(0));
					if(p.guessLetter(guess.charAt(0))){
						JOptionPane.showMessageDialog(null, "There is "+chars+" "+guess+"('s)");
						if(win!=1000000)
							win*=chars;
						JOptionPane.showMessageDialog(null, "You just won $"+win+"!");
						player.addToWinnings(win);
					}
					
					else
						JOptionPane.showMessageDialog(null, guess+" is not in this word");
				}
				
				gameP.playerRotate();
				panel.resetEvent();
				frame.setVisible(false);
			}

			else if(panel.getEvent().equals("cancel")){
				if(gameP.getEvent().equals("vowel"))
					gameP.getPlayer().addToWinnings(250);
				gameP.buttonsON();
				panel.resetEvent();
				frame.setVisible(false);
				gameF.toFront();
				gameF.setEnabled(true);
				gameP.resetEvent();
			}

		}

	}

}




























