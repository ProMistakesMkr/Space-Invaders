import processing.core.PApplet;

public class Blast extends Player {

	int posX;
	int posY;
	PApplet app;
	PlayerShoots playernew;

	public Blast(int posX, int posY, PApplet app) {
		super(posX, posY, app);

		/*
		 * this.posX=posX; this.posY=posY; this.app = app;
		 */
	}

	// PlayerShoots playernew = new PlayerShoots(posX, posY, this);

	@Override
	public void draw(PApplet app) {
		mov(app);
	}

	@Override
	public void mov(PApplet app) {
		/*int JueX, JueY;
		JueX = playernew.getNavX();
		JueY = playernew.getNavY();*/

		app.imageMode(app.CENTER);
		app.image(Blast, posX, posY);
		app.imageMode(app.CORNER);
		posY -= 2;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

}