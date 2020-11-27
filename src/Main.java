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
		
		logic = new Logic();
	}
	
	public void draw() {
		
		background (0);
	}
	
	public void keyPressed() {
		
	}
}
