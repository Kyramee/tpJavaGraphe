import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Forme implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int x1, y1;
	private Color contour, remplissage;
	
	public abstract void setParametre(int x1, int x2, int y1, int y2);
	
	public abstract void tracer(Graphics g);
	
	public void setX1 (int x1) {
		this.x1 = x1;
	}
	
	public void setY1 (int y1) {
		this.y1 = y1;
	}
	
	public void setContour(Color c) {
		this.contour = c;
	}
	
	public void setRemplissage(Color c) {
		this.remplissage = c;
	}
	
	public int getX1() {
		return this.x1;
	}
	
	public int getY1() {
		return this.y1;
	}
	
	public Color getContour() {
		return this.contour;
	}
	
	public Color getRemplissage() {
		return this.remplissage;
	}
}
