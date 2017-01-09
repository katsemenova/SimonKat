package SimonKat;

import java.awt.Color;

import guiPractice.components.Action;
import guiPractice.components.Clickable;

public interface ButtonInterfaceKat extends Clickable {

	void setColor(Color color);

	void setX(int i);

	void setY(int i);

	void setAction(Action a);

	void highlight();

	void dim();

}
