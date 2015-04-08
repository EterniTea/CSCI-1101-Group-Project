import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameStart extends JPanel implements ActionListener {
	//returning variables
	String event;
	
	//sounds
		PopUp pop = new PopUp();
	
	//components
	private JLabel entNames, p1, p2, p3;
	
	private JTextField name1, name2, name3;
	
	private JButton confirm1, confirm2, confirm3, startGame;
	
	public GameStart() {
		//returning variables
		event = "";

		//construct components
		entNames = new JLabel("          Please enter the player's names below          ");
		p1 = new JLabel("Player 1: ");
		p2 = new JLabel("Player 2: ");
		p3 = new JLabel("Player 3: ");
		
		name1 = new JTextField(12);
		name2 = new JTextField(12);
		name3 = new JTextField(12);
		
		confirm1 = new JButton("OK");
		confirm2 = new JButton("OK");
		confirm3 = new JButton("OK");
		startGame = new JButton("Start Game");
		
		//set component properties
		confirm1.addActionListener(this);
		confirm2.addActionListener(this);
		confirm3.addActionListener(this);
		startGame.addActionListener(this);
		
		startGame.setEnabled(false);
		
		//adjust size
		 setPreferredSize (new Dimension (300, 150));

		//add components
		add(entNames);
		add(p1);
		add(name1);
		add(confirm1);
		add(p2);
		add(name2);
		add(confirm2);
		add(p3);
		add(name3);
		add(confirm3);
		add(startGame);
		
	}
	
	//returns player input names
	public String getPlayer1(){return name1.getText();}
	public String getPlayer2(){return name2.getText();}
	public String getPlayer3(){return name3.getText();}
	
	//returns the event that was pressed
	public String getEvent(){return event;}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(confirm1)){
			if(confirm1.getText().equals("OK")){
				p1.setEnabled(false);
				name1.setEnabled(false);
				confirm1.setText("Cancel");
				if(!p1.isEnabled()&&!p2.isEnabled()&&!p3.isEnabled())
					startGame.setEnabled(true);
			}
			else{
				p1.setEnabled(true);
				name1.setEnabled(true);
				confirm1.setText("OK");
				startGame.setEnabled(false);
			}
		}
		
		else if(e.getSource().equals(confirm2)){
			if(confirm2.getText().equals("OK")){
				p2.setEnabled(false);
				name2.setEnabled(false);
				confirm2.setText("Cancel");
				if(!p1.isEnabled()&&!p2.isEnabled()&&!p3.isEnabled())
					startGame.setEnabled(true);
			}
			else{
				p2.setEnabled(true);
				name2.setEnabled(true);
				confirm2.setText("OK");
				startGame.setEnabled(false);
			}
		}
		
		else if(e.getSource().equals(confirm3)){
			if(confirm3.getText().equals("OK")){
				p3.setEnabled(false);
				name3.setEnabled(false);
				confirm3.setText("Cancel");
				if(!p1.isEnabled()&&!p2.isEnabled()&&!p3.isEnabled())
					startGame.setEnabled(true);
			}
			else{
				p3.setEnabled(true);
				name3.setEnabled(true);
				confirm3.setText("OK");
				startGame.setEnabled(false);
			}
		}
		
		else if(e.getSource().equals(startGame)){
			event = "start";
		}
				
	}
}
