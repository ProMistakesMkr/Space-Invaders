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

	Screen inicio;
	Player player;
	Blast blast;
	PFont miFuente, miFuente2, miFuente3, miFuente4, miFuente5;

	private ArrayList<Enemy> enemyList;

	@Override
	public void setup() {

		inicio = new Screen(0, 0, this);
		player = new PlayerShoots((width / 2), 600, this);
		enemyList = new ArrayList<Enemy>();
		blast = new Blast(0, 0, this);

		miFuente5 = createFont("Montserrat-Black.ttf", 20);
		miFuente4 = createFont("Montserrat-BlackItalic.ttf", 20);
		miFuente3 = createFont("Montserrat-BlackItalic.ttf", 20);

	}

	@Override
	public void draw() {

		background(255);
		paintScreen();
		drawButtonSelect();
		drawBacktHome();
		time();
		score();

		paintEnemy();
		initEnemy();

		drawPlayer();
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
	
	private void drawPlayer() {
		if (screenChange==1) {
			player.draw(this);
		}
	}
	
	private void initEnemy() {
		if(screenChange==0) {
			frameCount=0;
		}
		if(screenChange==1) {
			frameRate(60);
			if (frameCount == 120) {
				int posX = (int) random(-50, 10);
				enemyList.add(new Enemy(posX, 150, this));
				System.out.println(enemyList.size());
				frameCount = 0;
			}
		}
	}
	private void paintEnemy() {
		if(screenChange==1) {
		for (int i = 0; i < enemyList.size(); i++) {
			enemyList.get(i).draw(this);
			enemyList.get(i).mov(this);
			}
		}
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
}
