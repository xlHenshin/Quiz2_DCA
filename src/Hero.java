import processing.core.PApplet;

public class Hero extends Character implements Runnable{

	public Hero(int posX, int posY, int size, PApplet app) {
		super(posX, posY, size, app);
		
		speed=5;
		// TODO Auto-generated constructor stub
	}


	public void paint() {
		// TODO Auto-generated method stub
		
		app.fill(0,255,0);
		app.rect(posX, posY, size, size);
	}


	public void move() {
		// TODO Auto-generated method stub
	}

	public void moveRight() {
		
		posX += speed;
		
		if (posX== 550) {
			
			posX -= speed;
		}
	}
	
	public void moveLeft() {
		
		posX -= speed;
		
		if (posX== 50) {
			
			posX += speed;
		}
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		moveLeft();
		moveRight();
	}
	

}
