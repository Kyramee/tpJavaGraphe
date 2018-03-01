package metier;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/**
 * Cette classe abstraite comporte les méthodes et les attributs qui se
 * retrouvent dans les différentes classes nommées Rectangle et Trait, mais
 * aussi Ovale par l'extension de la classe rectangle.
 * 
 * @author Adrien
 * @author Steven
 */

public abstract class Forme implements Serializable {
	/** Numéro de série généré par défaut */
	private static final long serialVersionUID = 1L;
	/** Coordonnées du point x des différentes formes. */
	private int x1;
	/** Coordonnées du point y des différentes formes. */
	private int y1;
	/** Variable <code>Color</code> contenant la couleur d'un contour. */
	private Color contour;
	/** Variable <code>Color</code> contenant la couleur d'un remplissage. */
	private Color remplissage;

	/**
	 * Méthode vide qui permet l'implantation des différentes coordonnées et
	 * grandeurs des formes.
	 * 
	 * @param x1
	 *            La première coordonnée est enregistrer ici lorsqu'on clique.
	 * @param y1
	 *            La deuxièeme coordonnée est enregistrer ici lorsqu'on
	 *            relache/drag le clique
	 * @param x2
	 *            C'est une variable utilisé pour calculer la largeur de la
	 *            forme
	 * @param y2
	 *            C'est une variable utilisé pour calculer la hauteur de la
	 *            forme
	 */
	public abstract void setParametre( int x1, int x2, int y1, int y2 );

	/**
	 * Méthode vide qui permet l'implantation des variable qui déssine les
	 * formes sur le JPanel.
	 * 
	 * @param g
	 *            C'est le pinceau qui déssine les formes.
	 */
	public abstract void tracer( Graphics g );

	/** Méthode qui définit la variable <code>x1</code> */
	public void setX1( int x1 ) {
		this.x1 = x1;
	}

	/** Méthode qui définit la variable <code>y1</code> */
	public void setY1( int y1 ) {
		this.y1 = y1;
	}

	/** Méthode qui définit la variable <code>contour</code> */
	public void setContour( Color c ) {
		this.contour = c;
	}

	/** Méthode qui définit la variable <code>remplissage</code> */
	public void setRemplissage( Color c ) {
		this.remplissage = c;
	}

	/** Méthode qui retourne la variable <code>x1</code> */
	public int getX1() {
		return this.x1;
	}

	/** Méthode qui retourne la variable <code>y1</code> */
	public int getY1() {
		return this.y1;
	}

	/** Méthode qui retourne la variable <code>contour</code> */
	public Color getContour() {
		return this.contour;
	}

	/** Méthode qui retourne la variable <code>remplissage</code> */
	public Color getRemplissage() {
		return this.remplissage;
	}
}
