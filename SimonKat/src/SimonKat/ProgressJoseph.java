package SimonKat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.components.Component;

public class ProgressJoseph extends Component implements ProgressInterfaceKat {

	private static int width = 100;
	private static int height = 100;
	private boolean gameOver;
	private int setRound;
	private int setSequenceSize;
	
	public ProgressJoseph() {
		super(30, 30, width, height);
		
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
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, width, height);
		int fontSize = 15;
	    g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		g.setColor(Color.black);
		
		if(!gameOver){
			g.drawString("Round "+ setRound, 20, 35);
			g.drawString("Sequence "+ setSequenceSize, 20, 55);
		}
		else{
			g.drawString("Game over", 35,110);
		}
	}

}
