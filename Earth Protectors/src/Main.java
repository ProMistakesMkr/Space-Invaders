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
	Blast baku;
	PFont miFuente, miFuente2, miFuente3, miFuente4, miFuente5;

	@Override
	public void setup() {

		miFuente5 = createFont("Montserrat-Black.ttf", 20);
		miFuente4 = createFont("Montserrat-BlackItalic.ttf", 20);
		miFuente3 = createFont("Montserrat-BlackItalic.ttf", 20);

	}

	@Override
	public void draw() {

		background(255);
		
		
		
	}

}
