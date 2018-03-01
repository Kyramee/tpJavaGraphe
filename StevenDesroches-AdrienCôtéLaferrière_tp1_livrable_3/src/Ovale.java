import java.awt.Color;
import java.awt.Graphics;

/**
 * Cette classe �tend la classe Rectangle ce qui lui permet d'utiliser le
 * constructeur de Rectangle gr�ce � l'utilisation du super constructeur. Cette
 * classe permet de d�ssiner un ovale.
 * 
 * @author Adrien
 * @author Steven
 */

public class Ovale extends Rectangle {
	/**
	 * Constructeur qui permet de construire un ovale, il appelle le super
	 * constructeur de la classe Rectangle.
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
	public Ovale( int x1, int y1, Color contour, Color remplissage ) {
		super( x1, y1, contour, remplissage );
	}

	/**
	 * M�thode qui red�finit la m�thode <code>tracer</code> de Rectangle Elle
	 * permet de d�ssiner un ovale sur le JPanel.
	 * 
	 * @param g
	 *            C'est le pinceau qui permet de d�ssiner un ovale.
	 */
	@Override
	public void tracer( Graphics g ) {
		if ( super.getRemplissage() == Color.WHITE ) {
			g.setColor( super.getContour() );
			g.drawOval( super.getX1(), super.getY1(), super.getWidth(), super.getHeight() );
		} else {
			g.setColor( super.getRemplissage() );
			g.fillOval( super.getX1(), super.getY1(), super.getWidth(), super.getHeight() );
		}
	}
}
