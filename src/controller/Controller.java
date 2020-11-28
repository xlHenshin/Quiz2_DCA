package controller;

import model.Logic;
import processing.core.PApplet;

public class Controller {

	private PApplet app;
	private Logic logic;
	
	public Controller (PApplet app) {
		
		this.app=app;
		
		logic = new Logic(app);
	}

	public void paintAlien() {
		// TODO Auto-generated method stub
		
		logic.paintAlien();
	}

	public void paintHero() {
		// TODO Auto-generated method stub
		
		logic.paintHero();
	}
	
	public void paintBullet() {
		
		logic.paintBullet();
	}

	public void moveRight() {
		// TODO Auto-generated method stub
		
		logic.moveRight();
	}
	
	public void moveLeft() {
		
		logic.moveLeft();
	}

	public void shoot() {
		// TODO Auto-generated method stub
		
		logic.shoot();
	}
}
