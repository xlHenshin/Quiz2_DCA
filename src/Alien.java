import processing.core.PApplet;

public class Alien extends Character implements Runnable{

	public Alien(int posX, int posY, int size, PApplet app) {
		super(posX, posY, size, app);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint() {
		// TODO Auto-generated method stub
	
		app.fill(255,0,0);
		app.ellipse(posX, posY, size, size);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
		posX +=speed;
		if(posX >= 550 || posX <= 50){
			posY += 120;
			speed*=-1;		
		}
	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		move();
	}


}
