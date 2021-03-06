package metier;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Isoc�le extends Forme {
	private int[] xPoint = new int[3];
	private int[] yPoint = new int[3];
	

	public Isoc�le(int x1, int y1, Color contour, Color remplissage, float brush) {
		super.setX1(x1);
		super.setY1(y1);
		super.setContour(contour);
		super.setRemplissage(remplissage);
		super.setBrush(brush);
		for (int i = 0; i < xPoint.length; i++) {
			this.xPoint[i] = x1;
			this.yPoint[i] = y1;
		}
	}

	@Override
	public void tracer(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke( new BasicStroke(super.getBrush()) );
		if ( super.getRemplissage() == Color.WHITE ) {
			g2d.setColor( super.getContour() );
			g2d.drawPolygon(this.xPoint, this.yPoint, 3);
		} else {
			g2d.setColor( super.getRemplissage() );
			g2d.fillPolygon(this.xPoint, this.yPoint, 3);
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
