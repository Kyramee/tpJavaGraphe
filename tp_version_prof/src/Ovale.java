import java.awt.Color;
import java.awt.Graphics;

public class Ovale extends Rectangle {
	
	public Ovale(int x1, int x2, int y1, int y2, Color contour, Color remplissage) {
		super(x1, x2, y1, y2, contour, remplissage);
	}
	
	@Override
	public void tracer(Graphics g) {
		//COULEUR VIDE PAR DEFAULT EST BLANC
		if (super.getRemplissage() == Color.WHITE) {
			g.setColor(super.getContour());
			//CALCULER WIDTH AND HEIGHT DANS LE MOUSSE EVENT
			g.drawOval(super.getX1(), super.getY1(), super.getWidth(), super.getHeight());		
		} else {
			g.setColor(super.getRemplissage());
			//CALCULER WIDTH AND HEIGHT DANS LE MOUSSE EVENT
			g.fillOval(super.getX1(), super.getY1(), super.getWidth(), super.getHeight());		
		}	
	}
}
