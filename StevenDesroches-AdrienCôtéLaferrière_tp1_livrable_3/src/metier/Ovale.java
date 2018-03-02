package metier;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
	 * @param brush
	 * 			  contient la taille du pinceau.
	 */
	public Ovale( int x1, int y1, Color contour, Color remplissage, float brush) {
		super( x1, y1, contour, remplissage, brush );
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
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke( new BasicStroke(super.getBrush()) );
		if ( super.getRemplissage() == Color.WHITE ) {
			g2d.setColor( super.getContour() );
			g2d.drawOval( super.getX1(), super.getY1(), super.getWidth(), super.getHeight() );
		} else {
			g2d.setColor( super.getRemplissage() );
			g2d.fillOval( super.getX1(), super.getY1(), super.getWidth(), super.getHeight() );
		}
	}
}
