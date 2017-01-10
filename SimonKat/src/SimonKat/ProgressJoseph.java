package SimonKat;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.components.Component;

public class ProgressJoseph extends Component implements ProgressInterfaceKat {

	private static int width = 100;
	private static int height = 100;
	private boolean gameOver = false;
	private int setRound;
	private int setSequenceSize;
	
	public ProgressJoseph() {
		super(50, 50, width, height);
		// TODO Auto-generated constructor stub
	}  

	@Override
	public void gameOver() {
		gameOver = true;
		update();
	}  

	@Override
	public void setRound(int roundNumber) {
		this.setRound = roundNumber;
		update();
	}
 
	@Override
	public void setSequenceSize(int size) {
		this.setSequenceSize = size;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.fillRect(100, 100, width, height);
		g.setColor(Color.black);
		if(!gameOver){
			g.drawString("Round "+ setRound, getX(), getY());
			g.drawString("Sequence "+ setSequenceSize, getX(), getY());
		}
		else{
			g.drawString("Game over", getX(),getY());
		}
	}

}
