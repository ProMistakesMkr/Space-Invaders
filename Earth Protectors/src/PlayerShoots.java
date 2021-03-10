import java.util.ArrayList;

import processing.core.PApplet;

public class PlayerShoots extends Player {

	
	int navX = 600;
	int navY=600;
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
		
		app.image(Personaje, navX, navY);
		app.imageMode(app.CORNER);

	}

	@Override
	public void mov(PApplet app) {
		switch (app.key) {
		case 'a':
			this.navX -= 100;
			if (this.navX < 100) {
				this.navX = 100;
			}
			break;

		case 'd':
			this.navX += 100;
			if (this.navX > 1100) {
				this.navX = 1100;
			}
			break;
			
		/*case 'w':
			this.posY -= 50;
			if (this.posY < 550) {
				this.posY = 550;
			}
			break;

		case 's':
			this.posY += 50;
			if (this.posY > 600) {
				this.posY = 600;
			}
			break;
		default:
			break;*/
		}
	}

	public void mousePressed() {
		shoot();
	}

	public void shoot() {
		int sX=navX,sY=navY;
		Blast b = new Blast(sX, sY, app);
		Blast.add(b);
		System.out.println("posicion X"+navX);
		System.out.println("posicion Y" +navY);
		System.out.println(sX);
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	

	public int getNavX() {
		return navX;
	}


	public void setNavX(int navX) {
		this.navX = navX;
	}


	public int getNavY() {
		return navY;
	}


	public void setNavY(int navY) {
		this.navY = navY;
	}


	public void setBlast(ArrayList<Blast> blast) {
		Blast = blast;
	}


	public ArrayList<Blast> getBlast() {
		return Blast;
	}
}