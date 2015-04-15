import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class BuyVowel extends GuessPanel implements ActionListener{
	//return variables
	private String event, guess;
	
	//sounds
		PopUp pop = new PopUp();
	//components
	private JButton cancel, a, e, i, o, u;
	private GridLayout grid;
	
	public BuyVowel(){
		//return variables
		event="";
		guess="";
		
		//construct components
		cancel = new JButton("Cancel");
		a = new JButton("A");
		e = new JButton("E");
		i = new JButton("I");
		o = new JButton("O");
		u = new JButton("U");
		
		//set size and layout
		grid = new GridLayout(0,3);
		
		//set component properties
		cancel.addActionListener(this);
		a.addActionListener(this);
		e.addActionListener(this);
		i.addActionListener(this);
		o.addActionListener(this);
		u.addActionListener(this);
		
		//add components
		add(a);
		add(e);
		add(i);
		add(o);
		add(u);
		add(cancel);
	}
	
	//get return variables
	public String getEvent(){return event;}
	public String getGuess(){return guess;}
	public void resetEvent(){event="";}

	//enable all of the letters
	public void allEnabled(){
		a.setEnabled(true);
		e.setEnabled(true);
		i.setEnabled(true);
		o.setEnabled(true);
		u.setEnabled(true);
	}

	//confirm player action
	public boolean confirm(JButton b){
		boolean result=false;
		pop.play();
		if (JOptionPane.showConfirmDialog(null, "Is "+b.getText()+" your guess?", "Confirm",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			result=true;
			b.setEnabled(false);
			guess=b.getText();
			event="guess";
		}
		
		return result;
	}
		
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(cancel)){event="cancel";}
		else if(e.getSource().equals(a)){confirm(a);guess="A";}
		else if(e.getSource().equals(this.e)){confirm(this.e);guess="E";}
		else if(e.getSource().equals(i)){confirm(i);guess="I";}
		else if(e.getSource().equals(o)){confirm(o);guess="O";}
		else if(e.getSource().equals(u)){confirm(u);guess="U";}
	}
	
}
