import java.util.ArrayList;

import processing.core.PApplet;


public class Hero extends Character implements Runnable{

	private ArrayList<Bullet> bullet;
	
	public Hero(int posX, int posY, int size, PApplet app) {
		super(posX, posY, size, app);
		speed=5;
		bullet = new ArrayList<Bullet>();
	}


	public void paint() {
		// TODO Auto-generated method stub
		
		app.fill(0,255,0);
		app.rect(posX, posY, size, size);
		
		for (int i = 0; i < bullet.size(); i++) {
			bullet.get(i).paint();
			bullet.get(i).move();
			
			/*if(eliminarBala) {
				balas.remove(i);
				eliminarBala = false;
			}*/
		}
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
	
	public void shoot() {
		
		Bullet b = new Bullet(posX + 20, posY, app);
		bullet.add(b);
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		moveLeft();
		moveRight();
	}


	public ArrayList<Bullet> getBullet() {
		return bullet;
	}


	public void setBullet(ArrayList<Bullet> bullet) {
		this.bullet = bullet;
	}
	
	
}
