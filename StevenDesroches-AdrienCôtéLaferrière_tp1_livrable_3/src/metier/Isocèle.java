package metier;

import java.awt.Color;
import java.awt.Graphics;

public class Isocèle extends Forme {
	private int[] xPoint = new int[3];
	private int[] yPoint = new int[3];
	

	public Isocèle(int x1, int y1, Color contour, Color remplissage) {
		super.setX1(x1);
		super.setY1(y1);
		super.setContour(contour);
		super.setRemplissage(remplissage);
		for (int i = 0; i < xPoint.length; i++) {
			this.xPoint[i] = x1;
			this.yPoint[i] = y1;
		}
	}

	@Override
	public void tracer(Graphics g) {
		
		if ( super.getRemplissage() == Color.WHITE ) {
			g.setColor( super.getContour() );
			g.drawPolygon(this.xPoint, this.yPoint, 3);
		} else {
			g.setColor( super.getRemplissage() );
			g.fillPolygon(this.xPoint, this.yPoint, 3);
		}
	}

	@Override
	public void setParametre(int x1, int x2, int y1, int y2) {
		this.xPoint[0] = x1;
		this.yPoint[0] = y1;
		this.xPoint[1] = x2;
		this.yPoint[1] = y2;
		if (x2 > x1) {
			this.xPoint[2] = 2 * x1 - x2;
		} else {
			this.xPoint[2] = x1 + Math.abs(x2 - x1);
		}
		this.yPoint[2] = y2;
	}

}
