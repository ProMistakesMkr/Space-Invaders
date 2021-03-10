import java.util.ArrayList;

import processing.core.PApplet;

public class PlayerShoots extends Player{

private ArrayList<Blast> Blast;
	
	public PlayerShoots(int posX, int posY, PApplet app) {
		super(posX, posY, app);
		Blast = new ArrayList<>();
	}
	
	@Override
	public void draw(PApplet app) {
		for (int i = 0; i < Blast.size(); i++) {
			Blast.get(i).draw(app);
		}
		
		app.imageMode(app.CENTER);
		app.image(Personaje, posX, posY);
		app.imageMode(app.CORNER);
		
	}

	@Override
	public void mov(PApplet app) {
		switch (app.key) {
		case 'a' :
			this.posX-= 100;
			if (this.posX<100) {
				this.posX=100;
			}
			break;
			
		case 'd' :
			this.posX+= 100;
			if (this.posX>1100) {
				this.posX=1100;
			}
			break;
		case 'w' :
			this.posY-= 50;
			if (this.posY<550) {
				this.posY=550;
			}
			break;
			
		case 's' :
			this.posY+= 50;
			if (this.posY>600) {
				this.posY=600;
			}
			break;
		default:
			break;
		}
	}
	
	public void mousePressed() {
		shoot();
	}
	
	private void shoot() {
		Blast b = new Blast(this.posX, this.posY,app);
		Blast.add(b);
	}
	
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public ArrayList<Blast> getBaku() {
		return Blast;
	}
}