import processing.core.PApplet;

public class Blast extends Player {

	public Blast(int posX, int posY, PApplet app) {
		super(posX, posY, app);
	}

	@Override
	public void draw(PApplet app) {
		mov(app);
	}

	@Override
	public void mov (PApplet app) {
		app.imageMode(app.CENTER);
		app.image(Blast, posX, posY);
		app.imageMode(app.CORNER);
		posY-=2;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

}