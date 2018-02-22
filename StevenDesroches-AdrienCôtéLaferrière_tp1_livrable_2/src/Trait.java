import java.awt.Color;
import java.awt.Graphics;

public class Trait extends Forme {
	private int x2, y2;
	
	public Trait(int x1, int y1, Color contour) {
		//REMPLIASSAGE NON UTILISER DONC LAISSER NULL
		super.setX1(x1);
		super.setY1(y1);
		super.setContour(contour);
	}
	
	@Override
	public void setParametre(int x1, int x2, int y1, int y2) {
		this.x2 = x2;
		this.y2 = y2;
		super.setX1(x1);
		super.setY1(y1);
	}
	
	@Override
	public void tracer(Graphics g) {
		g.setColor(super.getContour());
		g.drawLine(super.getX1(), super.getY1(), this.x2, this.y2);;		
	}
}
