import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MainPanel extends JPanel implements ActionListener{
	//return variables
	private String event;
	
	//sounds
	PopUp pop = new PopUp();
	SpinSound spinner = new SpinSound();
	
	//attributes
	private static Player p1, p2, p3, pCurr;
	private int round;
	private Wheel w; 

	//components
	private JLabel p1money, p2money, p3money;

	private JRadioButton p1turn, p2turn, p3turn;

	private JButton spin, guessLett, buyVowel, guessPhrase;

	public MainPanel(String n1, String n2, String n3, int r) {
		//set return variables
		event = "";
		
		//set round and wheel
		round = r;
		w = new Wheel(r);
		
		//construct players
		p1 = new Player(n1);
		p2 = new Player(n2);
		p3 = new Player(n3);
		pCurr = p1;		//sets current player to p1

		//construct components
		p1money = new JLabel ("$"+p1.totalWinnings());	//tells players how much money they have won total
		p2money = new JLabel ("$"+p2.totalWinnings());
		p3money = new JLabel ("$"+p3.totalWinnings());

		p1turn = new JRadioButton (p1.getName());	//shows the current player
		p2turn = new JRadioButton (p2.getName());
		p3turn = new JRadioButton (p3.getName());

		spin = new JButton ("Spin!");
		guessLett = new JButton ("Guess a Letter");
		buyVowel = new JButton ("Buy a Vowel");
		guessPhrase = new JButton ("Guess a Phrase");

		//set component properties
		p1turn.setEnabled(false);	//make it so players cant change the player turn
		p2turn.setEnabled(false);
		p3turn.setEnabled(false);

		p1money.setForeground(Color.GRAY);
		p2money.setForeground(Color.GRAY);
		p3money.setForeground(Color.GRAY);

		p1turn.setSelected(true);	//initialy starts at player 1

		spin.setEnabled(true);
		guessLett.setEnabled(false);
		buyVowel.setEnabled(false);
		guessPhrase.setEnabled(false);

		spin.addActionListener(this);
		guessLett.addActionListener(this);
		buyVowel.addActionListener(this);
		guessPhrase.addActionListener(this);


		//adjust size and set layout
		setPreferredSize (new Dimension (750, 300));
		setLayout (null);

		//add components
		add (p1money);
		add (p2money);
		add (p3money);
		add (p1turn);
		add (p2turn);
		add (p3turn);
		add (spin);
		add (guessLett);
		add (buyVowel);
		add (guessPhrase);

		//set component bounds 
		p3money.setBounds (620, 50, 100, 20);
		p2money.setBounds (620, 80, 100, 20);
		p1money.setBounds (620, 110, 100, 20);
		p1turn.setBounds (515, 50, 100, 25);
		p2turn.setBounds (515, 80, 100, 25);
		p3turn.setBounds (515, 110, 100, 25);
		spin.setBounds (550, 175, 155, 80);
		guessLett.setBounds (10, 235, 150, 50);
		buyVowel.setBounds (180, 235, 150, 50);
		guessPhrase.setBounds (350, 235, 150, 50);
	}

	public String getEvent(){return event;}
	public void resetEvent(){event="";}	//reset event 

	
	public static Player getPlayer(){return pCurr;}
	//changes the players after each turn
	public void playerRotate(){

		//p1 to p2
		if(p1turn.isSelected()){
			p1turn.setSelected(false);
			p2turn.setSelected(true);
			pCurr = p2;
		}

		//p2 to p3
		else if(p2turn.isSelected()){
			p2turn.setSelected(false);
			p3turn.setSelected(true);
			pCurr = p3;
		}

		//p3 to p1
		else if(p3turn.isSelected()){
			p3turn.setSelected(false);
			p1turn.setSelected(true);
			pCurr = p1;
		}
	}

	//update winnings
	public void updateMoney(){
		p1money.setText("$"+p1.totalWinnings());
		p2money.setText("$"+p2.totalWinnings());
		p3money.setText("$"+p3.totalWinnings());
	}
	
	//confirm selection
	public boolean confirm(JButton b){
		boolean result=false;
		pop.play();
		if (JOptionPane.showConfirmDialog(null, "Are you sure you want to "+b.getText().toLowerCase()+"?", "Confirm",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			result=true;
		} 

		else {
			buttonsON();
			result=false;
		}
		return result;
	}

	public void spinResult(){
		String message="", result = w.spin();
		if(result.equals("Bankrupt"))
			message = "Sorry! You have gone bankrupt.";
		else if(result.equals("Lose a turn"))
			message = "Sorry! You lose a turn.";
		else
			message = "Your prize: $"+Integer.parseInt(result);	
		pop.play();
		JOptionPane.showMessageDialog(null, message);
		
	}

	//set event button methods
	public void buttonsON(){
		spin.setEnabled(false);
		guessLett.setEnabled(true);
		if(pCurr.getWinnings()>250)
			buyVowel.setEnabled(true);
		else
			buyVowel.setEnabled(false);
		guessPhrase.setEnabled(true);
	}
	
	public void buttonsOFF(){
		spin.setEnabled(true);
		guessLett.setEnabled(false);
		buyVowel.setEnabled(false);
		guessPhrase.setEnabled(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(spin)){
			spinner.play();	//plays wheel sound
			spinResult();
			buttonsON();
		}

		else if(e.getSource().equals(guessLett)){
			if(confirm(guessLett)){
				buttonsOFF();
				event = "letter";
			}

		}

		else if(e.getSource().equals(buyVowel)){
			if(confirm(buyVowel)){
				buttonsOFF();
				event = "vowel";
			}
		}

		else if(e.getSource().equals(guessPhrase)){
			if(confirm(guessPhrase)){
				buttonsOFF();
				event = "phrase";
			}
		}

	}


}
