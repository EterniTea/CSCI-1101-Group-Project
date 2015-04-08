import javax.swing.JPanel;


public abstract class GuessPanel extends JPanel {
	public abstract String getEvent();
	public abstract String getGuess();
	public abstract void resetEvent();
}
