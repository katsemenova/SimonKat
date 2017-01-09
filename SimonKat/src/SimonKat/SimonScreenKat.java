package SimonKat;

import java.awt.Color;
import java.util.ArrayList;

import guiPractice.ClickableScreen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class SimonScreenKat extends ClickableScreen implements Runnable {

	private ProgressInterfaceKat progress;
	private ArrayList<MoveInterfaceKat> moves;
	private int roundNumber;
	private boolean acceptingInput;
	private TextLabel txtLabel;
	private ButtonInterfaceKat[] button;
	private int lastSelectedButton;
	private int sequenceIndex;
	
	public SimonScreenKat(int width, int height) {
		super(width, height);
		Thread app=new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		txtLabel.setText("");
		nextRound();
	}

	private void nextRound() {
		acceptingInput=false;
		roundNumber++;
		moves.add(randomMove());
		progress.setRound(roundNumber);
		progress.setSequenceSize(moves.size());
		changeText("Simon's turn!");
		txtLabel.setText("");
		playSequence();
		acceptingInput=true;
		sequenceIndex=0;
	}

	private void playSequence() {
		ButtonInterfaceKat b=null;
		for(int i=0; i<moves.size();i++){
			if(b!=null)
				b.dim();
			
			b=moves.get(sequenceIndex).getButton();
			b.highlight();
			int sleepTime=1000*(int)Math.exp(roundNumber);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		b.dim();
	}

	private void changeText(String string) {
		try {
			txtLabel.setText(string);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		addButtons();
		progress = getProgress();
		txtLabel = new TextLabel(130,230,300,40,"Let's play Simon!");
		moves = new ArrayList<MoveInterfaceKat>();
		//add 2 moves to start
		lastSelectedButton = -1;
		moves.add(randomMove());
		moves.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(txtLabel);
	}

	public MoveInterfaceKat randomMove() {
		ButtonInterfaceKat b;
		int randomNumber;
		while(true){
			randomNumber=(int)Math.random()*(button.length-1);
			b=button[randomNumber];
			if(b!=button[lastSelectedButton]);
				break;
		}
		lastSelectedButton=randomNumber;
		return getMove(b);
	}

	public MoveInterfaceKat getMove(ButtonInterfaceKat b) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProgressInterfaceKat getProgress() {
		// placeholder
		return null;
	}

	public void addButtons() {
		int numberOfButtons=6;
		Color[] color={Color.blue,Color.pink,Color.green,Color.orange,Color.yellow,Color.black};
		for(int i=0;i<numberOfButtons;i++){
			final ButtonInterfaceKat b = getAButton();
			b.setColor(color[i]);
			b.setX(getWidth()/2+100*(int)Math.cos(Math.PI/3*(i)));
			b.setY(getHeight()/2+100*(int)Math.sin(Math.PI/3*(i)));
			b.setAction(new Action(){
				public void act(){
					Thread blink = new Thread(new Runnable(){

						public void run(){
							b.highlight();
							
							try {
								Thread.sleep(800);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							b.dim();
						
						}
						
						});
					blink.start();
					
					if(acceptingInput){
						//if the user's button matches sequence
						if(b==moves.get(sequenceIndex).getButton())
							sequenceIndex++;
						else{
							progress.gameOver();
							return;
						}	
					}
					if(moves.size()==sequenceIndex){
						Thread nextRound = new Thread(SimonScreenKat.this);
						nextRound.start();
						
					}
				}

				
			});
			viewObjects.add(b);
		}
	}

	
	private ButtonInterfaceKat getAButton() {
		// TODO Auto-generated method stub
		return null;
	}

}
