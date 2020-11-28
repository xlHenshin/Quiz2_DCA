import processing.core.PApplet;

public class Main extends PApplet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PApplet.main("Main");
	}

	private Logic logic;
	
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
	}
	
	public void keyPressed() {
		
		if(keyCode == RIGHT) {
			logic.moveRight();
		}
		if(keyCode == LEFT) {
			logic.moveLeft();
		}
	}
}
