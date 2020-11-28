import processing.core.PApplet;

public class Bullet implements Runnable{

	private PApplet app;
	private int posX, posY, speed;
	
	public Bullet(int posX, int posY, PApplet app) {
		
		this.app=app;
		
		this.posX = posX;
		this.posY = posY;
		
		speed=8;
	}
	
	public void paint() {
		
		app.fill(0,0,255);
		app.ellipse(posX, posY, 4, 10);
	}
	
	public void move() {
		
		posY -= speed; 
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		move();
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	

}
