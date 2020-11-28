package view;

import controller.Controller;
import model.Logic;

import processing.core.PApplet;

public class Main extends PApplet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PApplet.main("view.Main");
	}

	private Controller controller;
	private boolean moveLeft;
	private boolean moveRight;
	
	public void settings() {
		
		size(600, 800);
	}
	
	public void setup() {
		
		controller= new Controller(this);
	}
	
	public void draw() {
		
		rectMode(CENTER);
		background (0);
		
		controller.paintAlien();
		controller.paintHero();
		controller.paintBullet();
		controller.alienCounter();
		controller.end();
		
		if (moveRight==true){

			controller.moveRight();; 
		}

		if (moveLeft==true){

			controller.moveLeft();
		}
	}
	
	public void mouseClicked() {
		
		System.out.println(mouseX);
		System.out.println(mouseY);
	}
	
	public void keyPressed() {
		
		controller.keyPressed(key);
		
		if(keyCode == RIGHT) {
			moveRight=true;
		}
		if(keyCode == LEFT) {
			moveLeft=true;
		}
		
		if (keyCode == ' ') {
			
			controller.shoot();
		}
		
	}
	
	public void keyReleased() {
		
		if(keyCode == RIGHT) {
			moveRight=false;
		}
		if(keyCode == LEFT) {
			moveLeft=false;
		}
	}
}
