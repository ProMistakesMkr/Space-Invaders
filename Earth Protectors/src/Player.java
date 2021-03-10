import processing.core.PApplet;
import processing.core.PImage;

public class Player {

	int movX, movY;
	PImage Inicio, Personaje, Blast;
	PImage Instrucciones;
	PImage Score;
	PImage Enemy;
	protected int posX, posY;
	protected PApplet app;

	public Player(int movX, int movY, PApplet app) {

		this.movX = movX;
		this.movY = movY;
		this.app = app;
		Personaje = app.loadImage("Nave.png");
		Enemy = app.loadImage("Alien.png");
		Blast = app.loadImage("Blast.png");

	}

	public void draw(PApplet app) {
		// TODO Auto-generated method stub
		
	}

	public void mov(PApplet app) {
		// TODO Auto-generated method stub
		
	}

}