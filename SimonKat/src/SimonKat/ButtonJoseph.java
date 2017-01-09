package SimonKat;

import java.awt.Color;
import java.awt.Graphics2D;

import guiPractice.components.Action;
import guiPractice.components.Component;

public class ButtonJoseph extends Component implements ButtonInterfaceKat {

	private Object act;
	private Color color;
	private Action action;
	private boolean on;
	private static int width = 100;
	private static int height = 100;

	public ButtonJoseph() {
		super(0, 0, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void act() {
		this.act = act;
		update();
	}

	@Override
	public boolean isHovered(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
		update();
	}

	@Override
	public void setAction(Action a) {
		this.action = action;
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
	public void update(Graphics2D arg0) {
		if(on){
			
		}
		else{
			
		}
	}

}
