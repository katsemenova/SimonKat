package SimonKat;

public class MoveJoseph implements MoveInterfaceKat {

	private ButtonInterfaceKat b;
	
	public MoveJoseph(ButtonInterfaceKat b) {
		this.b = b;
	}

	@Override
	public ButtonInterfaceKat getButton() {
		// TODO Auto-generated method stub
		return b;
	}

}
