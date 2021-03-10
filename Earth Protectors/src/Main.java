import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;

public class Main extends PApplet {

	public static void main(String[] args) {

		PApplet.main("Main");

	}

	@Override
	public void settings() {

		size(1200, 700);
	}

	private int screenChange = 0;
	private int mil = 0;
	private int s = 0;
	private int m = 0;
	private int score = 0;
	private int defeat = 0;
	private int forMinute = 0;
	private int posX=(width/2);

	Screen inicio;
	PlayerShoots player;
	Blast blast;
	PFont miFuente, miFuente2, miFuente3, miFuente4, miFuente5;

	private ArrayList<Enemy> enemyList;

	@Override
	public void setup() {

		inicio = new Screen(0, 0, this);
		player = new PlayerShoots(posX, 3000, this);
		enemyList = new ArrayList<Enemy>();
		blast = new Blast(300, 300, this);

		miFuente = createFont("Montserrat-Black.ttf", 20);
		miFuente4 = createFont("Montserrat-BlackItalic.ttf", 20);
		miFuente3 = createFont("Montserrat-BlackItalic.ttf", 20);

	}

	@Override
	public void draw() {

		background(255);
		paintScreen();
		paintButtonSelect();

		drawBacktHome();
		time();
		score();

		paintEnemy();
		initEnemy();

		paintPlayer();
		removeEnemy();

	}

	private void paintScreen() {
		switch (screenChange) {
		case 0:
			inicio.drawHome(this);
			break;
		case 1:
			inicio.drawGame(this);
			break;
		case 2:
			inicio.drawInstru(this);
			break;

		case 4:
			inicio.drawStatus(this);
			finishGame();
			break;
		default:
			break;
		}
	}

	private void paintPlayer() {
		if (screenChange == 1) {
			player.draw(this);
		}
	}

	private void initEnemy() {
		if (screenChange == 0) {
			frameCount = 0;
		}
		if (screenChange == 1) {
			frameRate(60);
			if (frameCount == 120) {
				int posX = (int) random(-50, 20);
				enemyList.add(new Enemy(posX, 150, this));
				System.out.println(enemyList.size());
				frameCount = 0;
			}
		}
	}

	private void paintEnemy() {
		if (screenChange == 1) {
			for (int i = 0; i < enemyList.size(); i++) {
				enemyList.get(i).draw(this);
				enemyList.get(i).mov(this);
			}
		}
	}

	private void paintButtonSelect() {
		if (screenChange == 0) {
			if (mouseX > 410 && mouseX < 780 && mouseY > 320 && mouseY < 410) {
				rectMode(CENTER);
				noFill();
				stroke(255, 208, 128);
				strokeWeight(3);
				rect(600, 365, 375, 85, 30);
			}

			if (mouseX > 410 && mouseX < 780 && mouseY > 525 && mouseY < 620) {
				rectMode(CENTER);
				noFill();
				stroke(255, 208, 128);
				strokeWeight(3);
				rect(600, 575, 375, 85, 30);
			}
		}

	}

	private void drawBacktHome() {
		if (screenChange == 1 || screenChange == 2 || screenChange == 4) {
			if (mouseX > 41 && mouseX < 116 && mouseY > 35 && mouseY < 53) {
				strokeWeight(2);
				line(65, 60, 125, 60);
				;
			}
		}
	}

	private void time() {
		if (screenChange == 1) {
			textFont(miFuente);
			textAlign(CENTER, CENTER);
			if (mil <= 59) {
				text(m + ":" + s, 1110, 42);
				mil = mil + 1;
			} else {
				s = s + 1;
				mil = 0;
				m = 0;
				text(m + ":" + s, 1110, 42);
			}

			if (s >= 59) {
				m = m + 1;
				s = 0;
				text(m + ":" + s, 1110, 42);
			}
		}
	}

	private void score() {
		text(score, 960, 42);

	}

	private void finishGame() {
		textFont(miFuente);
		text(score, 230, 322);
		text(m + ":" + s, 230, 367);
		text(defeat, 370, 408);
		for (int i = 0; i < enemyList.size(); i++) {
			if (dist(blast.getPosX(), blast.getPosY(), enemyList.get(i).getPosX(), enemyList.get(i).getPosY()) < 50) {
				defeat = defeat + 1;
			}
		}

	}

	@Override
	public void keyPressed() {
		movPlayer();
	}

	private void movPlayer() {
		if (screenChange == 1) {
			player.mov(this);
		}
	}

	@Override
	public void mousePressed() {
		selectButton();
		backHome();
		shootBlast();
	}

	private void selectButton() {
		if (screenChange == 0) {
			if (mouseX > 410 && mouseX < 780 && mouseY > 320 && mouseY < 410) {
				screenChange = 1;
			}
			if (mouseX > 410 && mouseX < 780 && mouseY > 525 && mouseY < 620) {
				screenChange = 2;
			}

		}
	}

	private void backHome() {
		if (screenChange == 1 || screenChange == 2 || screenChange == 4) {
			if (mouseX > 500 && mouseX < 600 && mouseY > 35 && mouseY < 100) {
				screenChange = 0;
			}
		}
	}

	private void shootBlast() {
		if (screenChange == 1) {
			switch (mouseButton) {
			case LEFT:
				player.shoot();
				;
				break;
			default:
				break;
			}
		}
	}

	private void removeEnemy() {
		for (int i = 0; i < player.getBlast().size(); i++) {
			for (int j = 0; j < enemyList.size(); j++) {
				if (dist(player.getBlast().get(i).getPosX(), player.getBlast().get(i).getPosY(),
						enemyList.get(j).getPosX(), enemyList.get(j).getPosY()) < 50) {
					enemyList.remove(j);
				}
			}

		}
	}
}
