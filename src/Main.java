
import processing.core.PApplet;

public class Main extends PApplet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PApplet.main("Main");
	}

	private Logic logic;
	private boolean moveLeft;
	private boolean moveRight;
	
	public void settings() {
		
		size(600, 800);
	}
	
	public void setup() {
		
		logic = new Logic(this);
	}
	
	public void draw() {
		
		rectMode(CENTER);
		background (0);
		logic.paintAlien();
		logic.paintHero();
		
		if (moveRight==true){

			logic.moveRight();; 
		}

		if (moveLeft==true){

			logic.moveLeft();
		}
	}
	
	public void keyPressed() {
		
		if(keyCode == RIGHT) {
			moveRight=true;
		}
		if(keyCode == LEFT) {
			moveLeft=true;
		}
		
		if (keyCode == ' ') {
			
			logic.shoot();
		}
	}
	
	public void keyReleased() {
		
		if(keyCode == RIGHT) {
			moveRight=false;
		}
		if(keyCode == LEFT) {
			moveLeft=false;
		}
	}
}
