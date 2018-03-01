import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Forme {
	private int width;
	private int height;
	
	public Rectangle(int x1, int y1, Color contour, Color remplissage) {
		super.setX1(x1);
		super.setY1(y1);
		super.setContour(contour);
		super.setRemplissage(remplissage);
	}
	
	@Override
	public void setParametre(int x1, int x2, int y1, int y2) {	
		
		if(x1 > x2) {
			super.setX1(x2);
			this.width = x1 - x2;
		} else {
			super.setX1(x1);
			this.width = x2 - x1;
		}
		
		if (y1 > y2) {
			super.setY1(y2);
			this.height = y1 - y2;
		} else {
			super.setY1(y1);
			this.height = y2 - y1;
		}		
	}
	
	@Override
	public void tracer(Graphics g) {
		//COULEUR VIDE PAR DEFAULT EST BLANC
		if (super.getRemplissage() == Color.WHITE) {
			g.setColor(super.getContour());
			//CALCULER WIDTH AND HEIGHT DANS LE MOUSSE EVENT
			g.drawRect(super.getX1(), super.getY1(), this.width, this.height);		
		} else {
			g.setColor(super.getRemplissage());
			//CALCULER WIDTH AND HEIGHT DANS LE MOUSSE EVENT
			g.fillRect(super.getX1(), super.getY1(), this.width, this.height);		
		}	
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
}