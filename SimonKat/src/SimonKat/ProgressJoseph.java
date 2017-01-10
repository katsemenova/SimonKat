package SimonKat;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
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
		gameOver=false;
		update();
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
		FontMetrics fm = g.getFontMetrics();	
		int fontSize = 10;
	    g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		if(!gameOver){
			g.setColor(Color.lightGray);
			g.fillRect(0, 0, width, height);
			g.setColor(Color.black);
			g.drawString("Round: "+setRound, 20, 35);
			g.drawString("Sequence length: "+setSequenceSize, 20, 55);
		}else{
			g.setColor(Color.red);
			g.fillRect(0, 0, width, height);
			g.setColor(Color.black);
			g.drawString("Game over", 20,45);
		}
	}

}
