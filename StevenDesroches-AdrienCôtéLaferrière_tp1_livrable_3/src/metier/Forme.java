package metier;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/**
 * Cette classe abstraite comporte les m�thodes et les attributs qui se
 * retrouvent dans les diff�rentes classes nomm�es Rectangle et Trait, mais
 * aussi Ovale par l'extension de la classe rectangle.
 * 
 * @author Adrien
 * @author Steven
 */

public abstract class Forme implements Serializable {
	/** Num�ro de s�rie g�n�r� par d�faut */
	private static final long serialVersionUID = 1L;
	/** Coordonn�es du point x des diff�rentes formes. */
	private int x1;
	/** Coordonn�es du point y des diff�rentes formes. */
	private int y1;
	/** Variable <code>Color</code> contenant la couleur d'un contour. */
	private Color contour;
	/** Variable <code>Color</code> contenant la couleur d'un remplissage. */
	private Color remplissage;

	/**
	 * M�thode vide qui permet l'implantation des diff�rentes coordonn�es et
	 * grandeurs des formes.
	 * 
	 * @param x1
	 *            La premi�re coordonn�e est enregistrer ici lorsqu'on clique.
	 * @param y1
	 *            La deuxi�eme coordonn�e est enregistrer ici lorsqu'on
	 *            relache/drag le clique
	 * @param x2
	 *            C'est une variable utilis� pour calculer la largeur de la
	 *            forme
	 * @param y2
	 *            C'est une variable utilis� pour calculer la hauteur de la
	 *            forme
	 */
	public abstract void setParametre( int x1, int x2, int y1, int y2 );

	/**
	 * M�thode vide qui permet l'implantation des variable qui d�ssine les
	 * formes sur le JPanel.
	 * 
	 * @param g
	 *            C'est le pinceau qui d�ssine les formes.
	 */
	public abstract void tracer( Graphics g );

	/** M�thode qui d�finit la variable <code>x1</code> */
	public void setX1( int x1 ) {
		this.x1 = x1;
	}

	/** M�thode qui d�finit la variable <code>y1</code> */
	public void setY1( int y1 ) {
		this.y1 = y1;
	}

	/** M�thode qui d�finit la variable <code>contour</code> */
	public void setContour( Color c ) {
		this.contour = c;
	}

	/** M�thode qui d�finit la variable <code>remplissage</code> */
	public void setRemplissage( Color c ) {
		this.remplissage = c;
	}

	/** M�thode qui retourne la variable <code>x1</code> */
	public int getX1() {
		return this.x1;
	}

	/** M�thode qui retourne la variable <code>y1</code> */
	public int getY1() {
		return this.y1;
	}

	/** M�thode qui retourne la variable <code>contour</code> */
	public Color getContour() {
		return this.contour;
	}

	/** M�thode qui retourne la variable <code>remplissage</code> */
	public Color getRemplissage() {
		return this.remplissage;
	}
}
