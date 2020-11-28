package model;
import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {

	private PApplet app;
	
	private ArrayList<Alien> alien;
	private Hero hero;
	
	public Logic(PApplet app) {
		
		this.app = app;
		
		alien = new ArrayList<Alien>();
		hero = new Hero(300, 750, 50, app);
		createAlien();
		//paintAlien();
	}
	
	public void createAlien() {
		
		for (int i = 0; i < 6; i++) {
			
			alien.add(new Alien((i*55)+50, 100, 50, app));
		}
		
		for (int i = 0; i < 6; i++) {
			
			alien.add(new Alien((i*55)+50, 40, 50, app));
		}
		
		System.out.println(alien.size());
	}
	
	public void paintAlien() {
		
		for (int i = 0; i < alien.size(); i++) {
			alien.get(i).paint();
			Thread newAlien = new Thread(alien.get(i));
			newAlien.start();
		}
		
		moveAlien();
		
	}
	
	public void paintHero() {
		
		hero.paint();
		Thread newHero = new Thread (hero);
		newHero.start();
	}
	
	public void moveRight() {
		
		hero.moveRight();
	}
	
	public void moveLeft() {
		
		hero.moveLeft();
	}
	
	public void moveAlien() {
		
		for (int i = 0; i < alien.size(); i++) {
	
			alien.get(i).move();
		}
	}
	
	public void paintBullet() {
		
		hero.paintBullet();
		Thread newBullet = new Thread (hero);
		newBullet.start();
		
		bulletImpact();
	}
	
	public void shoot() {
		
		hero.shoot();
	}
	
	public void bulletImpact() {
		
		for (int i = 0; i < hero.getBullet().size(); i++) {
			for (int j = 0; j < alien.size(); j++) {
				
				int posX1=hero.getBullet().get(i).getPosX();
				int posY1=hero.getBullet().get(i).getPosY();
				int posX2=alien.get(j).getPosX();
				int posY2=alien.get(j).getPosY();
				int size=alien.get(j).getSize();
				
				if (PApplet.dist(posX1, posY1, posX2, posY2) < size) {
					
					hero.setEliminateBullet(true);
					alien.remove(j);
					System.out.println("impacto");
					
					
				}
				
			}
		}
	}


}
