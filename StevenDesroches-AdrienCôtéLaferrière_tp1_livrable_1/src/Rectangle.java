import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Forme {
	
	public Rectangle(Graphics g, int x1, int x2, int y1, int y2, Color contour, Color remplissage) {
		super.construteur(x1, x2, y1, y2, contour, remplissage);
		tracer(g);
	}

	@Override
	public void tracer(Graphics g) {
		//COULEUR VIDE PAR DEFAULT EST BLANC
		if (super.remplissage == Color.WHITE) {
			g.setColor(super.contour);
			//CALCULER WIDTH AND HEIGHT DANS LE MOUSSE EVENT
			g.drawRect(super.x1, super.y1, super.x2, super.y2);		
		} else {
			g.setColor(super.remplissage);
			//CALCULER WIDTH AND HEIGHT DANS LE MOUSSE EVENT
			g.fillRect(super.x1, super.y1, super.x2, super.y2);		
		}	
	}
}