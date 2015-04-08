import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GuessPhrase extends GuessPanel implements ActionListener{
	//return variables
	private String event;
	private String guess;

	//sounds
	PopUp pop = new PopUp();

	//components
	private JTextField phrase;
	private JButton ok, cancel;

	public GuessPhrase(){
		//set return variables
		event="";
		guess="";
		
		//construct components
		phrase = new JTextField(15);
		ok = new JButton("OK");
		cancel =  new JButton("Cancel");
		
		//set component properties
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
		//add components
		add(phrase);
		add(ok);
		add(cancel);
	}
	
	//get return variables
	public String getEvent(){return event;}
	public String getGuess(){return guess;}
	public void resetEvent(){event="";}

	
	//confirm guess
	public boolean confirm(JTextField f){
		boolean result=false;
		pop.play();
		guess=f.getText();
		if (JOptionPane.showConfirmDialog(null, "Is this the guess you gues?\n\""+guess+"\"", "Confirm",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			result=true;
			event="guess";	//set event to phrase
			guess = guess.toUpperCase();
		}
		
		return result;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(ok)){
			confirm(phrase);
			phrase.setText("");
		}
		
		else if(e.getSource().equals(cancel)){
			event="cancel";
			phrase.setText("");
		}
	}

}
