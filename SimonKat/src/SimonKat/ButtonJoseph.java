package SimonKat;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.components.Action;
import guiPractice.components.Component;

public class ButtonJoseph extends Component implements ButtonInterfaceKat {

	private Color color;
	private Action action;
	private boolean on;
	private static int width = 50;
	private static int height = 50;

	public ButtonJoseph() {
		super(0, 0, width, height);
		on=false;
	}

	@Override
	public void act() {
		action.act();
	}

	@Override
	public boolean isHovered(int x, int y) {
		if(x > getX() && y > getY() && x < (getX()+getWidth()) && y < (getY()+getHeight())){
			return true;
		}	
		else{
			return false;
		}
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
		update();
	}

	@Override
	public void setAction(Action a) {
		this.action = a;
		update();
	}

	@Override
	public void highlight() {
		on = true;
		update();
	}

	@Override
	public void dim() {
		on = false;
		update();
	} 

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		if(on){
			g.setColor(Color.lightGray);
			g.fillOval(0, 0, getWidth(), getHeight());
		}else{
			g.setColor(color);
			g.fillOval(0, 0, getWidth(), getHeight());
		}
		
	}
   
}
