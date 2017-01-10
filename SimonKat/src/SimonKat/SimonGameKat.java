package SimonKat;


import guiPractice.GUIApplication;

public class SimonGameKat extends GUIApplication {

	public SimonGameKat(int width, int height) {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initScreen() {
		SimonScreenKat wams = new SimonScreenKat(getWidth(),getHeight());
		setScreen(wams);
	}

	public static void main(String[] args) {
		SimonGameKat game = new SimonGameKat(800,500);
		Thread app = new Thread(game);
		app.start();
	}
}
