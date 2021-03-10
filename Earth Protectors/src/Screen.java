import processing.core.PApplet;
import processing.core.PImage;

public class Screen {

	private int x, y;
	private PApplet app;
	PImage Inicio, Juego, Instrucciones, Score;

	public Screen(int x, int y, PApplet app) {
		this.x = x;
		this.y = y;
		Inicio = app.loadImage("Inicio.png");
		Juego = app.loadImage("Juego.png");
		Instrucciones = app.loadImage("Instrucciones.png");
		Score = app.loadImage("Score.png");
		// aboutGame = app.loadImage("AboutGame.png");
	}

	public void drawHome(PApplet app) {
		app.image(Inicio, x, y);
	}

	public void drawGame(PApplet app) {
		app.image(Juego, x, y);
	}

	public void drawInstru(PApplet app) {
		app.image(Instrucciones, x, y);
	}

	public void drawStatus(PApplet app) {
		app.image(Score, x, y);
	}
}
