import java.awt.Color;
import java.awt.Graphics;

/**
 * Cette classe �tend la classe Abstraite Forme ce qui lui permet d'utiliser les
 * m�thodes de la classe abstraite. Cette classe permet de d�ssiner un
 * Rectangle.
 * 
 * @author Adrien
 * @author Steven
 */

public class Rectangle extends Forme {
	/** Attribut hauteur qui repr�sente la hauteur d'un rectangle. */
	private int width;
	/** Attribut largeur qui repr�sente la largeur d'un rectangle. */
	private int height;

	/**
	 * Constructeur qui permet de construire un Rectangle, il appelle la classe
	 * m�re pour utiliser les mutateurs.
	 * 
	 * @param x1
	 *            La premi�re coordonn�e est enregistrer ici lorsqu'on clique.
	 * @param y1
	 *            La deuxi�eme coordonn�e est enregistrer ici lorsqu'on
	 *            relache/drag le clique.
	 * @param contour
	 *            contient la couleur du contour.
	 * @param remplissage
	 *            contient la couleur du remplissage.
	 */
	public Rectangle( int x1, int y1, Color contour, Color remplissage ) {
		super.setX1( x1 );
		super.setY1( y1 );
		super.setContour( contour );
		super.setRemplissage( remplissage );
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
	 *            Variable servant � calculer la largeur du rectangle.
	 * @param y2
	 *            Variable servant � calculer la hauteur du rectangle.
	 */
	@Override
	public void setParametre( int x1, int x2, int y1, int y2 ) {

		if ( x1 > x2 ) {
			super.setX1( x2 );
			this.width = x1 - x2;
		} else {
			super.setX1( x1 );
			this.width = x2 - x1;
		}

		if ( y1 > y2 ) {
			super.setY1( y2 );
			this.height = y1 - y2;
		} else {
			super.setY1( y1 );
			this.height = y2 - y1;
		}
	}

	/**
	 * M�thode qui red�finit la m�thode <code>tracer</code> de la classe m�re Forme.
	 * 
	 * @param g
	 *            C'est le pinceau qui permet de d�ssiner un rectangle.
	 */
	@Override
	public void tracer( Graphics g ) {
		if ( super.getRemplissage() == Color.WHITE ) {
			g.setColor( super.getContour() );
			g.drawRect( super.getX1(), super.getY1(), this.width, this.height );
		} else {
			g.setColor( super.getRemplissage() );
			g.fillRect( super.getX1(), super.getY1(), this.width, this.height );
		}
	}

	/** M�thode qui retourne la variable <code>width</code> */
	public int getWidth() {
		return this.width;
	}

	/** M�thode qui retourne la variable <code>height</code> */
	public int getHeight() {
		return this.height;
	}
}