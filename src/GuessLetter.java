import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GuessLetter extends GuessPanel implements ActionListener{
	//return variables
	private String event, guess;

	//sounds
		PopUp pop = new PopUp();
		
	//components
	private JButton cancel, b, c, d, f, g, h, j, k, l, m, n, p, q, r, s, t, v, w, x, y, z;
	private GridLayout grid;

	public GuessLetter(){
		//return variables
		event="";
		guess="";

		//construct components
		cancel = new JButton("Cancel");
		b = new JButton("B");
		c = new JButton("C");
		d = new JButton("D");
		f = new JButton("F");
		g = new JButton("G");
		h = new JButton("H");
		j = new JButton("J");
		k = new JButton("K");
		l = new JButton("L");
		m = new JButton("M");
		n = new JButton("N");
		p = new JButton("P");
		q = new JButton("Q");
		r = new JButton("R");
		s = new JButton("S");
		t = new JButton("T");
		v = new JButton("V");
		w = new JButton("W");
		x = new JButton("X");
		y = new JButton("Y");
		z = new JButton("Z");

		//size and layout
		setPreferredSize (new Dimension (600, 200));
		grid = new GridLayout(0,7);
		setLayout(grid);

		//component properties
		cancel.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		d.addActionListener(this);
		f.addActionListener(this);
		g.addActionListener(this);
		h.addActionListener(this);
		j.addActionListener(this);
		k.addActionListener(this);
		l.addActionListener(this);
		m.addActionListener(this);
		n.addActionListener(this);
		p.addActionListener(this);
		q.addActionListener(this);
		r.addActionListener(this);
		s.addActionListener(this);
		t.addActionListener(this);
		v.addActionListener(this);
		w.addActionListener(this);
		x.addActionListener(this);
		y.addActionListener(this);
		z.addActionListener(this);

		//add components
		add(b);
		add(c);
		add(d);
		add(f);
		add(g);
		add(h);
		add(j);
		add(k);
		add(l);
		add(m);
		add(n);
		add(p);
		add(q);
		add(r);
		add(s);
		add(t);
		add(v);
		add(w);
		add(x);
		add(y);
		add(z);
		add(cancel);
	}

	//get return variables
	public String getEvent(){return event;}
	public String getGuess(){return guess;}
	public void resetEvent(){event="";}


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
		else if(e.getSource().equals(b)){confirm(b);guess="";}
		else if(e.getSource().equals(c)){confirm(c);guess="";}
		else if(e.getSource().equals(d)){confirm(d);guess="";}
		else if(e.getSource().equals(f)){confirm(f);guess="";}
		else if(e.getSource().equals(g)){confirm(g);guess="";}
		else if(e.getSource().equals(h)){confirm(h);guess="";}
		else if(e.getSource().equals(j)){confirm(j);guess="";}
		else if(e.getSource().equals(k)){confirm(k);guess="";}
		else if(e.getSource().equals(l)){confirm(l);guess="";}
		else if(e.getSource().equals(m)){confirm(m);guess="";}
		else if(e.getSource().equals(n)){confirm(n);guess="";}
		else if(e.getSource().equals(p)){confirm(p);guess="";}
		else if(e.getSource().equals(q)){confirm(q);guess="";}
		else if(e.getSource().equals(r)){confirm(r);guess="";}
		else if(e.getSource().equals(s)){confirm(s);guess="";}
		else if(e.getSource().equals(t)){confirm(t);guess="";}
		else if(e.getSource().equals(v)){confirm(v);guess="";}
		else if(e.getSource().equals(w)){confirm(w);guess="";}
		else if(e.getSource().equals(x)){confirm(x);guess="";}
		else if(e.getSource().equals(y)){confirm(y);guess="";}
		else if(e.getSource().equals(z)){confirm(z);guess="";}
	}
}
