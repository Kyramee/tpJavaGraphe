import java.awt.Color;
import java.awt.Graphics;

/**
 * Cette classe étend la classe Abstraite Forme ce qui lui permet d'utiliser les
 * méthodes de la classe abstraite. à Cette classe permet de déssiner un trait.
 * 
 * @author Adrien
 * @author Steven
 */

public class Trait extends Forme {
	/** Cette variable sert à calculer le deuxième point du trait (x2, y2) */
	private int x2, y2;

	/**
	 * Constructeur qui permet de construire un trait, il appelle la classe mère
	 * pour utiliser les mutateurs
	 * 
	 * @param x1
	 *            Coordonnée x du premier point.
	 * @param y1
	 *            Coordonnée y du premier point.
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
	 * Méthode qui redéfinit la méthode <code>setParametre</code> de la classe
	 * mère Forme.
	 * 
	 * @param x1
	 *            Coordonnée x du premier point.
	 * @param y1
	 *            Coordonnée y du premier point.
	 * @param x2
	 *            Coordonnée x du deuxième point.
	 * @param y2
	 *            Coordonnée y du deuxième point.
	 */
	@Override
	public void setParametre( int x1, int x2, int y1, int y2 ) {
		this.x2 = x2;
		this.y2 = y2;
		super.setX1( x1 );
		super.setY1( y1 );
	}

	/**
	 * Méthode qui redéfinit la méthode <code>tracer</code> de la classe mère Forme.
	 * 
	 * @param g
	 *            C'est le pinceau qui permet de déssiner un trait.
	 */
	@Override
	public void tracer( Graphics g ) {
		g.setColor( super.getContour() );
		g.drawLine( super.getX1(), super.getY1(), this.x2, this.y2 );
		;
	}
}
