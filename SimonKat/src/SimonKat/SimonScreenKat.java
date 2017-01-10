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
		changeText("Your turn");
		acceptingInput=true;
		sequenceIndex=0;
	}

	private void playSequence() {
		ButtonInterfaceKat b=null;
		for(int i=0; i<moves.size();i++){
			if(b!=null)
				b.dim();
			
			b=moves.get(i).getButton();
			b.highlight();
			
			int sleepTime=1000*(int)Math.exp(roundNumber/2);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		b.dim();
		
	}

	private void changeText(String string) {
		try {
			txtLabel.setText(string);
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		addButtons(viewObjects);
		progress = getProgress();
		txtLabel = new TextLabel(200,270,300,40,"Let's play Simon!");
		moves = new ArrayList<MoveInterfaceKat>();
		//add 2 moves to start
		lastSelectedButton = -1;
		moves.add(randomMove());
		moves.add(randomMove());
		roundNumber = 0;
		viewObjects.add(txtLabel);
		viewObjects.add(progress);
		
	}

	public MoveInterfaceKat randomMove() {
		ButtonInterfaceKat b=null;
		int randomNumber;
		while(true){
			randomNumber=(int)(Math.random()*(button.length));
			
			if(randomNumber!=lastSelectedButton);
				break;
		}
		b=button[randomNumber];
		lastSelectedButton=randomNumber;
		return getMove(b);
	}

	public MoveInterfaceKat getMove(ButtonInterfaceKat b) {
		return new MoveJoseph(b);
	}

	public ProgressInterfaceKat getProgress() {
		return new ProgressJoseph();
	}

	public void addButtons(ArrayList<Visible> viewObjects) {
		int numberOfButtons=6;
		Color[] color={ Color.blue, Color.red, Color.green, Color.pink, Color.orange, Color.magenta };
		button = new ButtonInterfaceKat[numberOfButtons];
		for(int i=0;i<numberOfButtons;i++){
			button[i]=getAButton();
			button[i].setColor(color[i]);
			button[i].setX(110+i*60);
			button[i].setY(200);
			final ButtonInterfaceKat b = button[i];
			b.dim();
			b.setAction(new Action(){
				public void act(){
					Thread blink = new Thread(new Runnable(){

						public void run(){
							b.highlight();
							
							try {
								Thread.sleep(400);
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
			viewObjects.add(button[i]);
		}
	}

	
	private ButtonInterfaceKat getAButton() {
		
		return new ButtonJoseph();
	}

}
