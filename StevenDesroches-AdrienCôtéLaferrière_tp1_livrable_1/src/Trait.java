import java.awt.Color;
import java.awt.Graphics;

public class Trait extends Forme {
	
	public Trait(Graphics g, int x1, int x2, int y1, int y2, Color contour) {
		//REMPLIASSAGE NON UTILISER DONC LAISSER NULL
		super.construteur(x1, x2, y1, y2, contour, null);
		tracer(g);
	}
	
	@Override
	public void tracer(Graphics g) {
		g.setColor(super.contour);
		g.drawLine(super.x1, super.y1, super.x2, super.y2);		
	}
}
