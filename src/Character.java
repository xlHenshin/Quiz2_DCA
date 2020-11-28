import processing.core.PApplet;

public abstract class Character{

	protected PApplet app;
	protected int posX, posY, size, speed;
	
	public Character(int posX, int posY, int size, PApplet app) {
		// TODO Auto-generated constructor stub
		
		this.app=app;
		this.posX=posX;
		this.posY=posY;
		this.size=size;
		
		speed = 1;
	}
	
	public abstract void paint();
	
	
	public abstract void move();
	

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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	
}
