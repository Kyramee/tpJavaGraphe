import java.awt.Color;
import java.awt.Graphics;

public abstract class Forme {
	protected int x1, x2, y1, y2;
	protected Color contour, remplissage;
	
	public void construteur(int x1, int x2, int y1, int y2, Color contour, Color remplissage) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.contour = contour;
		this.remplissage = remplissage;
	}
	
	public abstract void tracer(Graphics g);
}
