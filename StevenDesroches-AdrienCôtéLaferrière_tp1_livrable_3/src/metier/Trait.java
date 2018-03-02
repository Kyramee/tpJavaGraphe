package metier;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Cette classe �tend la classe Abstraite Forme ce qui lui permet d'utiliser les
 * m�thodes de la classe abstraite. � Cette classe permet de d�ssiner un trait.
 * 
 * @author Adrien
 * @author Steven
 */

public class Trait extends Forme {
	/** Cette variable sert � calculer le deuxi�me point du trait (x2, y2) */
	private int x2, y2;

	/**
	 * Constructeur qui permet de construire un trait, il appelle la classe m�re
	 * pour utiliser les mutateurs
	 * 
	 * @param x1
	 *            Coordonn�e x du premier point.
	 * @param y1
	 *            Coordonn�e y du premier point.
	 * @param contour
	 *            Couleur du trait.
	 */
	public Trait( int x1, int y1, Color contour ) {
		super.setX1( x1 );
		super.setY1( y1 );
		this.x2 = x1;
		this.y2 = y1;
		super.setContour( contour );
	}

	/**
	 * M�thode qui red�finit la m�thode <code>setParametre</code> de la classe
	 * m�re Forme.
	 * 
	 * @param x1
	 *            Coordonn�e x du premier point.
	 * @param y1
	 *            Coordonn�e y du premier point.
	 * @param x2
	 *            Coordonn�e x du deuxi�me point.
	 * @param y2
	 *            Coordonn�e y du deuxi�me point.
	 */
	@Override
	public void setParametre( int x1, int x2, int y1, int y2, float brush ) {
		this.x2 = x2;
		this.y2 = y2;
		super.setX1( x1 );
		super.setY1( y1 );
		this.setBrush( brush );
	}

	/**
	 * M�thode qui red�finit la m�thode <code>tracer</code> de la classe m�re Forme.
	 * 
	 * @param g
	 *            C'est le pinceau qui permet de d�ssiner un trait.
	 */
	@Override
	public void tracer( Graphics g ) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke( new BasicStroke(getBrush()) );
		g.setColor( super.getContour() );
		g.drawLine( super.getX1(), super.getY1(), this.x2, this.y2 );
		;
	}
}
