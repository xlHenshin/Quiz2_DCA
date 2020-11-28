package model;
import java.util.ArrayList;

import javax.swing.Box.Filler;

import exception.Lose;
import exception.Win;
import processing.core.PApplet;

public class Logic {

	private PApplet app;
	
	private ArrayList<Alien> alien;
	private Hero hero;
	
	private int alienCounter;
	private int end;
	private boolean gameOver;
	
	public Logic(PApplet app) {
		
		this.app = app;
		
		alien = new ArrayList<Alien>();
		hero = new Hero(300, 750, 50, app);
		alienCounter=0;
		end= 0;
		gameOver=false;
		createAlien();
		
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

		try {
			impactAlien();
		} catch (Lose e) {
			// TODO Auto-generated catch block
			System.out.println("Game Over");
			gameOver=true;
			end=2;
			
		}
		
		moveAlien();
		
	}
	
	public void paintHero() {
		
		hero.paint();
		Thread newHero = new Thread (hero);
		newHero.start();
		
		try {
			impact();
		} catch (Win e) {
			// TODO Auto-generated catch block
			
			System.out.println("You Win");
			gameOver=true;
			end=1;
			
		
		}
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
		
	}
	
	public void shoot() {
		
		hero.shoot();
	}
	
	public void alienCounter() {
		
		app.fill(255);
		app.text("Destroyed aliens = "+ alienCounter, 50, 50);
	}
	
	public void impact() throws Win{
		
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
					alienCounter++;
					System.out.println("impacto");
					
				}
				
			}
		}
		
		if (alien.size()==0) {
			
			throw new Win("You Win");
			//System.out.println("Ganaste perro");
		}
		
	}
	
	public void impactAlien() throws Lose{
		
		for (int i = 0; i < alien.size(); i++) {
			
			int posX1=alien.get(i).getPosX();
			int posY1=alien.get(i).getPosY();
			int posX2=hero.getPosX();
			int posY2=hero.getPosY();
			int size=hero.getSize();
			
			if (PApplet.dist(posX1, posY1, posX2, posY2) < size) {
				
				throw new Lose("You Lose");
				//System.out.println("Game Over");
			}
		}
	}
	
	public void end() {
		
		switch (end) {
		case 1:
			//win case
			app.fill(255);
			app.rect(300, 400, 150, 100);
			app.fill(0);
			app.text("You Win", 240, 380);
			app.text("Press R to reset", 240, 400);
			break;
			
		case 2:
			//lose case
			app.fill(255);
			app.rect(300, 400, 150, 100);
			app.fill(0);
			app.text("You Lose", 240, 380);
			app.text("Press R to reset", 240, 400);
			break;

		default:
			break;
		}
	}
	
	public void keyPressed(char key) {
		
		if (gameOver==true) {
			if (key =='r') {
				
				if (alien.size()==0) {
					
					hero.getBullet().clear();
					alien.clear();
					System.out.println();
					end=0;
					alienCounter=0;
					gameOver=false;
					createAlien();
					
					
				} else {
					
					hero.getBullet().clear();
					alien.clear();
					System.out.println(alien.size());
					end=0;
					alienCounter=0;
					gameOver=false;
					createAlien();
				}
			}
		}
	}


}
